package com.team195.frc2016.Threads;

import com.team195.frc2016.Controllers;

public class HomeArmThread extends Thread {
	private Controllers robotControllers;

	HomeArmThread(Controllers robotControllers) {
		this.robotControllers = robotControllers;
	}
	
	@Override
	public void run() {
		
	}
}
