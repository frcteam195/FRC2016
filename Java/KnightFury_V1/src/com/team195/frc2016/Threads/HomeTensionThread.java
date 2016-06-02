package com.team195.frc2016.Threads;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;

public class HomeTensionThread extends Thread {
	private Controllers robotControllers;
	private Sensors robotSensors;
	
	HomeTensionThread(Controllers robotControllers, Sensors robotSensors) {
		this.robotControllers = robotControllers;
		this.robotSensors = robotSensors;
	}
	
	@Override
	public void run() {
		
	}
}
