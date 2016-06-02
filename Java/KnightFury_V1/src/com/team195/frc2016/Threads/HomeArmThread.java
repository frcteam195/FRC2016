package com.team195.frc2016.Threads;

import com.team195.frc2016.Commands.HomeMotors;

public class HomeArmThread extends Thread {
	private HomeMotors initArm;

	public HomeArmThread(HomeMotors initArm) {
		this.initArm = initArm;
	}
	
	@Override
	public void run() {
		initArm.homeArm();
	}
}
