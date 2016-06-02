package com.team195.frc2016.Threads;

import com.team195.frc2016.Subsystems.Arm;

public class HomeArmThread extends Thread {
	private Arm awesomeBar;

	public HomeArmThread(Arm awesomeBar) {
		this.awesomeBar = awesomeBar;
	}
	
	@Override
	public void run() {
		awesomeBar.home();
	}
}
