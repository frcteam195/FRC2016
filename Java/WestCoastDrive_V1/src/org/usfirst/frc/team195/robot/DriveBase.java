package org.usfirst.frc.team195.robot;

import org.usfirst.frc.team195.robot.Controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DriveBase {
	
	Controllers robotControllers;
	
	Joystick driveStick;
	
	CANTalon leftDrive;
	CANTalon rightDrive;
	
	DoubleSolenoid shiftSol;
	
	double x;
	double y;
	double left;
	double right;
	double absLeft;
	double absRight;
	double normalLeft;
	double normalRight;
	static int maxOutput = 1;
	static double joystickDeadband = .02;
	
	boolean highGear = false;
	boolean holdLowGear = false;
	
	DriveBase(Controllers importedControllers) {
		robotControllers = importedControllers;
		
		driveStick = robotControllers.getDriveStick();
		
		leftDrive = robotControllers.getLeftDrive();
		rightDrive = robotControllers.getRightDrive();
		
		shiftSol = robotControllers.getShiftSol();
	}
	
	void arcadeDrive() {
		x = driveStick.getRawAxis(0);
		y = driveStick.getRawAxis(1);
		x = handleDeadband(x, joystickDeadband);
		y = handleDeadband(y , joystickDeadband);
		left = y + x;
		right = y - x;
		absLeft = Math.abs(left);
		absRight = Math.abs(right);
		
		if(absLeft > absRight && absLeft > maxOutput) {
			normalLeft = left / absLeft;
			normalRight = right / absLeft;
		}
		else if(absRight > absLeft && absRight > maxOutput) {
			normalLeft = left / absRight;
			normalRight = right / absRight;
		}
		else {
			normalLeft = left;
			normalRight = right;
		}
		
		normalRight *= -1;
		
		leftDrive.set(normalLeft);
		rightDrive.set(normalRight);
	}
	
	double handleDeadband(double joyVal, double deadBand) {
		return (Math.abs(joyVal) > Math.abs(deadBand)) ? joyVal: 0.0;
	}
	
	void shift() {
		holdLowGear = driveStick.getRawButton(8);
		
		if(driveStick.getRawButton(6)) {
			highGear = true;
		}
		else if(driveStick.getRawButton(7)) {
			highGear = false;
		}
		
		if(holdLowGear) {
			shiftSol.set(Value.kReverse);
		}
		else {
			if(highGear) {
				shiftSol.set(Value.kForward);
			}
			else {
				shiftSol.set(Value.kReverse);
			}
		}
	}
}
