package com.team195.frc2016.Commands;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class HomeMotors {
	private CANTalon armMotor;
	private CANTalon winchMotor;
	private CANTalon tensionerMotor;
	
	private int armHomeValue = -13854;
	
	private DigitalInput winchLimitSwitch;
	private DigitalInput tensionerLimitSwitch;
	
	private boolean armIsHomed = false;
	private boolean winchIsHomed = false;
	private boolean tensionerIsHomed = false;
	
	public HomeMotors(Controllers robotControllers, Sensors robotSensors) {		
		armMotor = robotControllers.getArmMotor();
		winchMotor = robotControllers.getWinchMotor();
		tensionerMotor = robotControllers.getTensionerMotor();
		
		winchLimitSwitch = robotSensors.getWinchLimitSwitch();
		tensionerLimitSwitch = robotSensors.getTensionerLimitSwitch();
	}
	
	public void homeArm() {
		armMotor.setEncPosition(armHomeValue);
		armMotor.changeControlMode(TalonControlMode.Position);
		armMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		armMotor.reverseOutput(true);
		armMotor.reverseSensor(false);
		armMotor.setPID(2, 0, 6);
		armMotor.configNominalOutputVoltage(+0f, -0f);
		armMotor.configPeakOutputVoltage(+9.6f, -9.6f);
		armMotor.enable();
		armMotor.set(armHomeValue);
		
		armIsHomed = true;
	}
	
	public void homeWinch() {
		winchMotor.set(.35);
		Timer.delay(.25);
		while(!winchLimitSwitch.get() || winchMotor.getEncVelocity() != 0);
		winchMotor.set(0);
		winchMotor.setEncPosition(0);
		winchMotor.changeControlMode(TalonControlMode.Position);
		winchMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		winchMotor.reverseOutput(true);
		winchMotor.reverseSensor(false);
		winchMotor.setPID(10, 0, 4);
		winchMotor.setAllowableClosedLoopErr(15);
		winchMotor.enable();
		winchMotor.set(0);
		
		winchIsHomed = true;
	}
	
	public void homeTensioner() {
		tensionerMotor.set(-.5);
		Timer.delay(.06);
		while(!tensionerLimitSwitch.get() || tensionerMotor.getEncVelocity() != 0);
		tensionerMotor.set(0);
		tensionerMotor.setEncPosition(0);
		tensionerMotor.changeControlMode(TalonControlMode.Position);
		tensionerMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		tensionerMotor.reverseOutput(true);
		tensionerMotor.reverseSensor(false);
		tensionerMotor.setPID(3, 0, 4);
		tensionerMotor.setAllowableClosedLoopErr(50);
		tensionerMotor.enable();
		tensionerMotor.set(0);
		
		tensionerIsHomed = true;
	}
	
	public void reHomeArm(boolean reHome) {
		armIsHomed = reHome? false: armIsHomed;
	}
	
	public void reHomeWinch(boolean reHome) {
		winchIsHomed = reHome? false: winchIsHomed;
	}
	
	public void reHomeTensioner(boolean reHome) {
		tensionerIsHomed = reHome? false: tensionerIsHomed;
	}
	
	public boolean homingFinished() {
		return armIsHomed && winchIsHomed && tensionerIsHomed;
	}
}
