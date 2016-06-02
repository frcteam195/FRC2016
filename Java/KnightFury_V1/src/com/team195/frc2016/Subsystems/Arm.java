package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Controllers;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;

public class Arm {
	private CANTalon armMotor;

	public Arm(Controllers robotControllers) {
		armMotor = robotControllers.getArmMotor();
	}

	private int armStartingPosition = -13854;

	private boolean isHomed = false;

	public void home() {
		if(!isHomed) {
			armMotor.setEncPosition(armStartingPosition);
			armMotor.changeControlMode(TalonControlMode.Position);
			armMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			armMotor.reverseOutput(true);
			armMotor.reverseSensor(false);
			armMotor.setPID(2, 0, 6);
			armMotor.configNominalOutputVoltage(+0f, -0f);
			armMotor.configPeakOutputVoltage(+9.6f, -9.6f);
			armMotor.enable();
			armMotor.set(armStartingPosition);

			isHomed = true;
		}
	}

	public void reHome(boolean reHome) {
		isHomed = reHome? false: isHomed;
	}

	private int lastSetpoint = 0;
	
	public void setArmSetpoint(int setpoint) {
		if(isHomed) {
			if(setpoint != lastSetpoint) {
				armMotor.set(setpoint);
			}
			lastSetpoint = setpoint;
		}
	}
}
