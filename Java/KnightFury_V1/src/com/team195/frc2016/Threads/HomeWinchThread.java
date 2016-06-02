package com.team195.frc2016.Threads;

import com.team195.frc2016.Commands.HomeMotors;

public class HomeWinchThread extends Thread {
	private HomeMotors initWinch;
	
	public HomeWinchThread(HomeMotors initWinch) {
		this.initWinch = initWinch;
	}
	
	@Override
	public void run() {
		initWinch.homeWinch();
	}
}
