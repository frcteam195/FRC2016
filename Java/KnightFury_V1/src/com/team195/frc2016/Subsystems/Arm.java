package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Controllers;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;

public class Arm {
	Controllers robotControllers;
	
	CANTalon armMotor;
	
	private int armHomeValue = -13854;
	
	private boolean armIsHomed = false;
	
	Arm(Controllers robotControllers) {
		this.robotControllers = robotControllers;
		
		armMotor = this.robotControllers.getArmMotor();
	}
	
	public void home() {
		armIsHomed = false;
		
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
	
	public boolean armIsHomed() {
		return armIsHomed;
	}
}
