package com.team195.frc2016;

import com.team195.frc2016.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;

public class Sensors {
	RobotMap sensorPorts;
	
	private DigitalInput ballInCatapultSensor;
	private DigitalInput ballInIntakeSensor;
	
	private DigitalInput winchLimitSwitch;
	private DigitalInput tensionerLimitSwitch;
	
	Sensors() {
		sensorPorts = new RobotMap();
		
		ballInCatapultSensor = new DigitalInput(sensorPorts.getBallInCatapultSensorPort());
		ballInIntakeSensor = new DigitalInput(sensorPorts.getBallInIntakeSensorPort());
		
		winchLimitSwitch = new DigitalInput(sensorPorts.getWinchLimitSwitchPort());
		tensionerLimitSwitch = new DigitalInput(sensorPorts.getTensionerLimitSwitchPort());
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
