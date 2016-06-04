package com.team195.frc2016.Threads;

import com.team195.frc2016.Subsystems.Tensioner;

public class HomeTensionerThread extends Thread {
	private Tensioner catapultTensioner;
	
	public HomeTensionerThread(Tensioner catapultTensioner) {
		this.catapultTensioner = catapultTensioner;
	}
	
	@Override
	public void run() {
		if(!catapultTensioner.isHomed()) {
			catapultTensioner.home();	
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
