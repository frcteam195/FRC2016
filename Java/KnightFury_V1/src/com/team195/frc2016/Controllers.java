package com.team195.frc2016;

import com.team195.frc2016.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Controllers {
	private Joystick driveStick;
	private Joystick buttonBox1;
	private Joystick buttonBox2;
	
	private CANTalon leftDrive1;
	private CANTalon leftDrive2;
	private CANTalon rightDrive1;
	private CANTalon rightDrive2;
	
	private CANTalon intakeMotor;
	private CANTalon armMotor;
	private CANTalon winchMotor;
	private CANTalon tensionerMotor;
	private CANTalon manipulatorMotor;
	
	private CANTalon leftClimberMotor;
	private CANTalon rightClimberMotor;
	
	private Solenoid trigger;
	private DoubleSolenoid shiftSol;
	private DoubleSolenoid ballHolder;
	
	Controllers() {
		driveStick = new Joystick(RobotMap.driveStickPort);
		buttonBox1 = new Joystick(RobotMap.buttonBox1Port);
		buttonBox2 = new Joystick(RobotMap.buttonBox2Port);
		
		leftDrive1 = new CANTalon(RobotMap.leftDrive1Port);
		leftDrive2 = new CANTalon(RobotMap.leftDrive2Port);
		leftDrive2.changeControlMode(TalonControlMode.Follower);
		leftDrive2.set(RobotMap.leftDrive1Port);
		rightDrive1 = new CANTalon(RobotMap.rightDrive1Port);
		rightDrive2 = new CANTalon(RobotMap.rightDrive2Port);
		rightDrive2.changeControlMode(TalonControlMode.Follower);
		rightDrive2.set(RobotMap.rightDrive1Port);
		
		intakeMotor = new CANTalon(RobotMap.intakeMotorPort);
		armMotor = new CANTalon(RobotMap.armMotorPort);
		winchMotor = new CANTalon(RobotMap.winchMotorPort);
		tensionerMotor = new CANTalon(RobotMap.tensionerMotorPort);
		manipulatorMotor = new CANTalon(RobotMap.manipulatorMotorPort);
		
		leftClimberMotor = new CANTalon(RobotMap.leftClimberMotorPort);
		rightClimberMotor = new CANTalon(RobotMap.rightClimberMotorPort);
		
		trigger = new Solenoid(RobotMap.triggerPort);
		shiftSol = new DoubleSolenoid(RobotMap.shiftSolForwardPort, RobotMap.shiftSolReversePort);
		ballHolder = new DoubleSolenoid(RobotMap.ballholderForwardPort, RobotMap.ballHolderReversePort);
	}
	
	public Joystick getDriveStick() {
		return driveStick;
	}
	
	public Joystick getButtonBox1() {
		return buttonBox1;
	}
	
	public Joystick getButtonBox2() {
		return buttonBox2;
	}
	
	public CANTalon getLeftDrive() {
		return leftDrive1;
	}
	
	public CANTalon getRightDrive() {
		return rightDrive1;
	}
	
	public CANTalon getIntakeMotor() {
		return intakeMotor;
	}
	
	public CANTalon getArmMotor() {
		return armMotor;
	}
	
	public CANTalon getWinchMotor() {
		return winchMotor;
	}
	
	public CANTalon getTensionerMotor() {
		return tensionerMotor;
	}
	
	public CANTalon getManipulatorMotor() {
		return manipulatorMotor;
	}
	
	public CANTalon getLeftClimberMotor() {
		return leftClimberMotor;
	}
	
	public CANTalon getRightClimberMotor() {
		return rightClimberMotor;
	}
	
	public Solenoid getTrigger() {
		return trigger;
	}
	
	public DoubleSolenoid getShiftSol() {
		return shiftSol;
	}
	
	public DoubleSolenoid getBallHolder() {
		return ballHolder;
	}
}
