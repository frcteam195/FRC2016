package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class Winch {
	private Controllers robotControllers;
	private Sensors robotSensors;
	
	private CANTalon winchMotor;
	private DigitalInput winchLimitSwitch;
	
	private boolean winchIsHomed = false;
	
	public Winch(Controllers robotControllers, Sensors robotSensors) {
		this.robotControllers = robotControllers;
		this.robotSensors = robotSensors;
		
		winchMotor = this.robotControllers.getWinchMotor();
		winchLimitSwitch = this.robotSensors.getWinchLimitSwitch();
	}
	
	public void home() {
		winchIsHomed = false;
		
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
	
	public boolean winchIsHomed() {
		return winchIsHomed;
	}
}
