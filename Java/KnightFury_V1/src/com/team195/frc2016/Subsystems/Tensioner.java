package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class Tensioner {
	private Controllers robotControllers;
	private Sensors robotSensors;
	
	private CANTalon tensionerMotor;
	private DigitalInput tensionerLimitSwitch;
	
	private boolean initiallyHomed = false;
	private boolean isHomed = false;
	
	public Tensioner(Controllers robotControllers, Sensors robotSensors) {
		this.robotControllers = robotControllers;
		this.robotSensors = robotSensors;
		
		tensionerMotor = this.robotControllers.getTensionerMotor();
		tensionerLimitSwitch = this.robotSensors.getTensionerLimitSwitch();
	}
	
	public void home() {
		isHomed = false;
		
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
		
		initiallyHomed = true;
		isHomed = true;
	}
	
	public boolean initiallyHomed() {
		return initiallyHomed;
	}
	
	public boolean isHomed() {
		return isHomed;
	}
}
