package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Utilities.Controllers;
import com.team195.frc2016.Utilities.Sensors;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class Tensioner {
	private CANTalon tensionerMotor;
	
	private DigitalInput tensionerLimitSwitch;
	
	private boolean isHomed = false;
	
	private int lastTensionerSetpoint = -1;
	
	public Tensioner(Controllers robotControllers, Sensors robotSensors) {
		tensionerMotor = robotControllers.getTensionerMotor();
		
		tensionerLimitSwitch = robotSensors.getTensionerLimitSwitch();
	}
	
	public void home() {
		if(!isHomed) {
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
			
			isHomed = true;
			lastTensionerSetpoint = -1;
		}
	}
	
	public boolean isHomed() {
		return isHomed;
	}
	
	public void reHome(boolean reHome) {
		isHomed = reHome? false: isHomed;
	}
	
	public void setTensionerSetpoint(int setpoint) {
		if(isHomed) {
			if(setpoint != lastTensionerSetpoint) {
				tensionerMotor.set(setpoint);
			}
			lastTensionerSetpoint = setpoint;
		}
	}
}
