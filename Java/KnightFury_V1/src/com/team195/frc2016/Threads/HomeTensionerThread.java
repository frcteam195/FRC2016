package com.team195.frc2016.Threads;

import com.team195.frc2016.Subsystems.Tensioner;

public class HomeTensionerThread extends Thread {
	private Tensioner springTensioner;
	
	public HomeTensionerThread(Tensioner springTensioner) {
		this.springTensioner = springTensioner;
	}
	
	@Override
	public void run() {
		springTensioner.home();
	}
}
