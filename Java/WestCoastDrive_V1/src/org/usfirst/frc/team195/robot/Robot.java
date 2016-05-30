package org.usfirst.frc.team195.robot;

import org.usfirst.frc.team195.robot.Controllers;
import org.usfirst.frc.team195.robot.DriveBase;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {

	Controllers robotControllers;
	
	Compressor robotCompressor;
	
	DriveBase robotDrive;
    
    public void robotInit() {
    	robotControllers = new Controllers();
    	
    	robotCompressor = robotControllers.getRobotCompressor();
    	robotCompressor.start();
    	
    	robotDrive = new DriveBase(robotControllers);
    }

    public void autonomous() {
    	
    }

    public void operatorControl() {
    	robotDrive.arcadeDrive();
    	robotDrive.shift();
    	Timer.delay(0.005);
    }

    public void test() {
    	
    }
}
