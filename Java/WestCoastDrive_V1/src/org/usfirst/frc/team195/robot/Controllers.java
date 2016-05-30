package org.usfirst.frc.team195.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Controllers {
	
	Joystick driveStick;
	
	CANTalon leftDrive1;
	CANTalon leftDrive2;
	CANTalon leftDrive3;
	CANTalon rightDrive1;
	CANTalon rightDrive2;
	CANTalon rightDrive3;

	Compressor robotCompressor;
	
	DoubleSolenoid shiftSol;
	
	Controllers() {
		driveStick = new Joystick(0);
		
		leftDrive1 = new CANTalon(0);
		
		leftDrive2 = new CANTalon(1);
		leftDrive2.changeControlMode(TalonControlMode.Follower);
		leftDrive2.set(0);
		
		leftDrive3 = new CANTalon(2);
		leftDrive3.changeControlMode(TalonControlMode.Follower);
		leftDrive3.set(0);
		
		rightDrive1 = new CANTalon(3);
		
		rightDrive2 = new CANTalon(4);
		rightDrive2.changeControlMode(TalonControlMode.Follower);
		rightDrive2.set(3);
		
		rightDrive3 = new CANTalon(5);
		rightDrive3.changeControlMode(TalonControlMode.Follower);
		rightDrive3.set(3);
		
		robotCompressor = new Compressor();
		
		shiftSol = new DoubleSolenoid(0, 1);
	}
	
	Joystick getDriveStick() {
		return driveStick;
	}
	
	CANTalon getLeftDrive() {
		return leftDrive1;
	}
	
	CANTalon getRightDrive() {
		return rightDrive1;
	}
	
	Compressor getRobotCompressor() {
		return robotCompressor;
	}
	
	DoubleSolenoid getShiftSol() {
		return shiftSol;
	}
}
