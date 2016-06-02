package com.team195.frc2016;

import com.team195.frc2016.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Controllers {
	private RobotMap controllerPorts;
	
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
		controllerPorts = new RobotMap();
		
		driveStick = new Joystick(controllerPorts.getDriveStickPort());
		buttonBox1 = new Joystick(controllerPorts.getButtonBox1Port());
		buttonBox2 = new Joystick(controllerPorts.getButtonBox2Port());
		
		leftDrive1 = new CANTalon(controllerPorts.getLeftDrive1Port());
		leftDrive1.changeControlMode(TalonControlMode.PercentVbus);
		leftDrive2 = new CANTalon(controllerPorts.getLeftDrive2Port());
		leftDrive2.changeControlMode(TalonControlMode.Follower);
		leftDrive2.set(controllerPorts.getLeftDrive1Port());
		rightDrive1 = new CANTalon(controllerPorts.getRightDrive1Port());
		rightDrive1.changeControlMode(TalonControlMode.PercentVbus);
		rightDrive2 = new CANTalon(controllerPorts.getRightDrive2Port());
		rightDrive2.changeControlMode(TalonControlMode.Follower);
		rightDrive2.set(controllerPorts.getRightDrive1Port());
		
		intakeMotor = new CANTalon(controllerPorts.getIntakeMotorPort());
		intakeMotor.changeControlMode(TalonControlMode.PercentVbus);
		armMotor = new CANTalon(controllerPorts.getArmMotorPort());
		armMotor.changeControlMode(TalonControlMode.PercentVbus);
		winchMotor = new CANTalon(controllerPorts.getWinchMotorPort());
		winchMotor.changeControlMode(TalonControlMode.PercentVbus);
		tensionerMotor = new CANTalon(controllerPorts.getTensionerMotorPort());
		tensionerMotor.changeControlMode(TalonControlMode.PercentVbus);
		manipulatorMotor = new CANTalon(controllerPorts.getManipulatorMotorPort());
		manipulatorMotor.changeControlMode(TalonControlMode.PercentVbus);
		
		leftClimberMotor = new CANTalon(controllerPorts.getLeftClimberMotorPort());
		leftClimberMotor.changeControlMode(TalonControlMode.PercentVbus);
		rightClimberMotor = new CANTalon(controllerPorts.getRightClimberMotorPort());
		rightClimberMotor.changeControlMode(TalonControlMode.PercentVbus);
		
		trigger = new Solenoid(controllerPorts.getTriggerPort());
		shiftSol = new DoubleSolenoid(controllerPorts.getShiftSolForwardPort(), controllerPorts.getShiftSolReversePort());
		ballHolder = new DoubleSolenoid(controllerPorts.getBallHolderForwardPort(), controllerPorts.getBallHolderReversePort());
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
