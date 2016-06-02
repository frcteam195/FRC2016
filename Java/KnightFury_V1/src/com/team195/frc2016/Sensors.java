package com.team195.frc2016;

import com.team195.frc2016.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;

public class Sensors {
	private DigitalInput ballInCatapultSensor;
	private DigitalInput ballInIntakeSensor;
	
	private DigitalInput winchLimitSwitch;
	private DigitalInput tensionerLimitSwitch;
	
	Sensors() {
		ballInCatapultSensor = new DigitalInput(RobotMap.ballInCatapultSensorPort);
		ballInIntakeSensor = new DigitalInput(RobotMap.ballInIntakeSensorPort);
		
		winchLimitSwitch = new DigitalInput(RobotMap.winchLimitSwitchPort);
		tensionerLimitSwitch = new DigitalInput(RobotMap.tensionerLimitSwitchPort);
	}
	
	public DigitalInput getBallInCatapultSensor() {
		return ballInCatapultSensor;
	}
	
	public DigitalInput getBallInIntakeSensor() {
		return ballInIntakeSensor;
	}
	
	public DigitalInput getWinchLimitSwitch() {
		return winchLimitSwitch;
	}
	
	public DigitalInput getTensionerLimitSwitch() {
		return tensionerLimitSwitch;
	}
}
