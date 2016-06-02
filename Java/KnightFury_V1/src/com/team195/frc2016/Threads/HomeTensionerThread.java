package com.team195.frc2016.Threads;

import com.team195.frc2016.Commands.HomeMotors;

public class HomeTensionerThread extends Thread {
	private HomeMotors initTensioner;
	
	public HomeTensionerThread(HomeMotors initTensioner) {
		this.initTensioner = initTensioner;
	}
	
	@Override
	public void run() {
		initTensioner.homeTensioner();
	}
}
