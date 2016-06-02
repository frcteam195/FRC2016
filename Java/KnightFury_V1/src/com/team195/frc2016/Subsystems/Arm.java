package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Controllers;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;

public class Arm {
	private Controllers robotControllers;
	
	private CANTalon armMotor;
	
	private int armHomeValue = -13854;
	
	private boolean initiallyHomed = false;
	private boolean isHomed = false;
	
	public Arm(Controllers robotControllers) {
		this.robotControllers = robotControllers;
		
		armMotor = this.robotControllers.getArmMotor();
	}
	
	public void home() {
		isHomed = false;
		
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
