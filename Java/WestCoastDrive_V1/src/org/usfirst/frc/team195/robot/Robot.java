package org.usfirst.frc.team195.robot;

import org.usfirst.frc.team195.robot.Controllers;
import org.usfirst.frc.team195.robot.DriveBase;
import org.usfirst.frc.team195.robot.DriveThread;
import org.usfirst.frc.team195.robot.ShiftThread;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {

	Controllers robotControllers;
	
	Compressor robotCompressor;
	
	DriveBase robotDrive;
	DriveThread robotDriveThread;
	ShiftThread robotShiftThread;
    
	@Override
    public void robotInit() {
    	robotControllers = new Controllers();
    	
    	robotCompressor = robotControllers.getRobotCompressor();
    	robotCompressor.start();
    	
    	robotDrive = new DriveBase(robotControllers);
    	robotDriveThread = new DriveThread(robotDrive);
    	robotShiftThread = new ShiftThread(robotDrive);
    }

	@Override
    public void autonomous() {
    	
    }

	@Override
    public void operatorControl() {
    	robotDriveThread.start();
    	robotShiftThread.start();
    	Timer.delay(0.005);
    }
    
	@Override
    public void test() {
    	
    }
}
