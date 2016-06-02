package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class DriveBase {
	private Joystick driveStick;
	
	private CANTalon leftDrive;
	private CANTalon rightDrive;
	
	private DoubleSolenoid shiftSol;
	
	public DriveBase(Controllers robotControllers) {
		driveStick = robotControllers.getDriveStick();
		
		leftDrive = robotControllers.getLeftDrive();
		rightDrive = robotControllers.getRightDrive();
		
		shiftSol = robotControllers.getShiftSol();
	}
	
	double x = 0;
	double y = 0;
	double left = 0;
	double right = 0;
	double absLeft = 0;
	double absRight = 0;
	final int maxOutput = 1;
	double normalLeft = 0;
	double normalRight = 0;
	
	public void arcadeDrive() {
		x = driveStick.getRawAxis(0);
		y = driveStick.getRawAxis(1);
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
	
	private boolean highGear = false;
	private boolean holdLowGear = false;
	
	public void shift() {
		holdLowGear = driveStick.getRawButton(8);
		
		if(driveStick.getRawButton(6))
			highGear = true;
		else if(driveStick.getRawButton(7))
			highGear = false;
		
		if(holdLowGear)
			shiftSol.set(Value.kReverse);
		else {
			if(highGear)
				shiftSol.set(Value.kForward);
			else
				shiftSol.set(Value.kReverse);
		}
	}
}
