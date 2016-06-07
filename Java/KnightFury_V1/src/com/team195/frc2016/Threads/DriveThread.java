package com.team195.frc2016.Threads;

import com.team195.frc2016.Subsystems.DriveBase;

import edu.wpi.first.wpilibj.Timer;

public class DriveThread extends Thread {
	private DriveBase cyberDrive;
	
	private double startTime = 0;
	private double timeToRun = 0;
	
	public DriveThread(DriveBase cyberDrive) {
		this.cyberDrive = cyberDrive;
	}
	
	@Override
	public void run() {
		startTime = Timer.getFPGATimestamp() * 1000;
		cyberDrive.arcadeDrive();
		cyberDrive.shift();
		timeToRun = (Timer.getFPGATimestamp() * 1000) - startTime;
		
		try {
			Thread.sleep((int) (50 - timeToRun));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
