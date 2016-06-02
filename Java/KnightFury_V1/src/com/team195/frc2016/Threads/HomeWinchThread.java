package com.team195.frc2016.Threads;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;
import com.team195.frc2016.Subsystems.Winch;

public class HomeWinchThread extends Thread {
	private Winch catapultWinch;
	
	HomeWinchThread(Controllers robotControllers, Sensors robotSensors) {		
		catapultWinch = new Winch(robotControllers, robotSensors);
	}
	
	@Override
	public void run() {
		catapultWinch.home();
	}
}
