package com.team195.frc2016.Threads;

import com.team195.frc2016.Subsystems.Winch;

public class HomeWinchThread extends Thread {
	private Winch catapultWinch;
	
	public HomeWinchThread(Winch catapultWinch) {
		this.catapultWinch = catapultWinch;
	}
	
	@Override
	public void run() {
		if(!catapultWinch.isHomed()) {
			catapultWinch.home();	
		}
		else {
			try {
				Thread.sleep(50);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
