package com.team195.frc2016.Threads;

import com.team195.frc2016.Commands.ControlArm;

import edu.wpi.first.wpilibj.Timer;

public class ArmControlThread extends Thread {
	private ControlArm armControlCommand;
	
	private double startTime = 0;
	private double timeToRun = 0;
	
	public ArmControlThread(ControlArm armControlCommand) {
		this.armControlCommand = armControlCommand;
	}
	
	@Override
	public void run() {
		startTime = Timer.getFPGATimestamp() * 1000;
		armControlCommand.setpointControl();
		timeToRun = (Timer.getFPGATimestamp() * 1000) - startTime;
		
		try {
			Thread.sleep((int) (50 - timeToRun));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
