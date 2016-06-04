package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Utilities.Controllers;
import com.team195.frc2016.Utilities.Sensors;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class Winch {
	private CANTalon winchMotor;

	private DigitalInput winchLimitSwitch;
	
	private boolean isHomed = false;
	
	private int lastWinchSetpoint = -1;

	public Winch(Controllers robotControllers, Sensors robotSensors) {
		winchMotor = robotControllers.getWinchMotor();

		winchLimitSwitch = robotSensors.getWinchLimitSwitch();
	}

	public void home() {
		if(!isHomed) {
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

			isHomed = true;
			lastWinchSetpoint = -1;
		}
	}

	public boolean isHomed() {
		return isHomed;
	}

	public void reHome(boolean reHome) {
		isHomed = reHome? false: isHomed;
	}

	public void setWinchSetpoint(int setpoint) {
		if(isHomed) {
			if(setpoint != lastWinchSetpoint) {
				winchMotor.set(setpoint);
			}
			lastWinchSetpoint = setpoint;
		}
	}
}
