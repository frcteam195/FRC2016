package org.usfirst.frc.team195.robot;

import org.usfirst.frc.team195.robot.RobotMap;

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
		driveStick = new Joystick(RobotMap.joystickPort);
		
		leftDrive1 = new CANTalon(RobotMap.leftDriveMotor1Port);
		
		leftDrive2 = new CANTalon(RobotMap.leftDriveMotor2Port);
		leftDrive2.changeControlMode(TalonControlMode.Follower);
		leftDrive2.set(RobotMap.leftDriveMotor1Port);
		
		leftDrive3 = new CANTalon(RobotMap.leftDriveMotor3Port);
		leftDrive3.changeControlMode(TalonControlMode.Follower);
		leftDrive3.set(RobotMap.leftDriveMotor1Port);
		
		rightDrive1 = new CANTalon(RobotMap.rightDriveMotor1Port);
		
		rightDrive2 = new CANTalon(RobotMap.rightDriveMotor2Port);
		rightDrive2.changeControlMode(TalonControlMode.Follower);
		rightDrive2.set(RobotMap.rightDriveMotor1Port);
		
		rightDrive3 = new CANTalon(RobotMap.rightDriveMotor3Port);
		rightDrive3.changeControlMode(TalonControlMode.Follower);
		rightDrive3.set(RobotMap.rightDriveMotor1Port);
		
		robotCompressor = new Compressor();
		
		shiftSol = new DoubleSolenoid(RobotMap.shiftSolForwardPort, RobotMap.shiftSolReversePort);
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
