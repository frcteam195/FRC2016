package com.team195.frc2016.Threads;

import com.team195.frc2016.Subsystems.Intake;

import edu.wpi.first.wpilibj.Timer;

public class IntakeThread extends Thread {
	private Intake robotIntake;
	
	private double startTime = 0;
	private double timeToRun = 0;
	
	public IntakeThread(Intake robotIntake) {
		this.robotIntake = robotIntake;
	}
	
	@Override
	public void run() {
		startTime = Timer.getFPGATimestamp() * 1000;
		robotIntake.runIntake();
		timeToRun = (Timer.getFPGATimestamp() * 1000) - startTime;
		
		try {
			Thread.sleep((int) (50 - timeToRun));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
