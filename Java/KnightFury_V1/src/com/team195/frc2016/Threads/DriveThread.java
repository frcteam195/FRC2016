package com.team195.frc2016.Threads;

import com.team195.frc2016.Subsystems.DriveBase;

import edu.wpi.first.wpilibj.Timer;

public class DriveThread extends Thread {
	private DriveBase cyberDrive;
	
	public DriveThread(DriveBase cyberDrive) {
		this.cyberDrive = cyberDrive;
	}
	
	@Override
	public void run() {
		cyberDrive.arcadeDrive();
		cyberDrive.shift();
		Timer.delay(0.005);
	}
}
