package com.team195.frc2016.Utilities;

import com.team195.frc2016.Utilities.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;

public class Sensors {
	RobotMap sensorPorts;
	
	private DigitalInput ballInCatapultSensor;
	private DigitalInput ballInIntakeSensor;
	
	private DigitalInput winchLimitSwitch;
	private DigitalInput tensionerLimitSwitch;
	
	public Sensors() {
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
