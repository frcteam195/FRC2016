package org.usfirst.frc.team195.robot;

import org.usfirst.frc.team195.robot.DriveBase;

public class DriveThread extends Thread {

	DriveBase robotDrive;

	DriveThread(DriveBase robotDrive) {
		this.robotDrive = robotDrive;
	}

	@Override
	public void run() {
		robotDrive.arcadeDrive();
	}
}
