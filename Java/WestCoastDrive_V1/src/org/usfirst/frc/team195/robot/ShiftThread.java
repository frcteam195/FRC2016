package org.usfirst.frc.team195.robot;

import org.usfirst.frc.team195.robot.DriveBase;

public class ShiftThread extends Thread {

	DriveBase robotDrive;

	ShiftThread(DriveBase robotDrive) {
		this.robotDrive = robotDrive;
	}

	@Override
	public void run() {
		while(true) {
			robotDrive.shift();
		}
	}
}
