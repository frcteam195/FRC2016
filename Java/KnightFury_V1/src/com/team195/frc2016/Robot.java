package com.team195.frc2016;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;
import com.team195.frc2016.Subsystems.*;
import com.team195.frc2016.Threads.*;

import edu.wpi.first.wpilibj.SampleRobot;
//import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	private Controllers robotControllers;
	private Sensors robotSensors;
	
	private Winch catapultWinch;
	private HomeWinchThread homeWinch;
	
	private Arm awesomeBar;
	private HomeArmThread homeArm;
	
	private Tensioner springTensioner;
	private HomeTensionerThread homeTensioner;
	
	public Robot() {
		robotControllers = new Controllers();
		robotSensors = new Sensors();
		
		catapultWinch = new Winch(robotControllers, robotSensors);
		homeWinch = new HomeWinchThread(catapultWinch);
		
		awesomeBar = new Arm(robotControllers);
		homeArm = new HomeArmThread(awesomeBar);
		
		springTensioner = new Tensioner(robotControllers, robotSensors);
		homeTensioner = new HomeTensionerThread(springTensioner);
	}
    
    @Override
    public void robotInit() {
    	
    }

    @Override
    public void autonomous() {
    	if(!catapultWinch.initiallyHomed()) {
    		homeWinch.start();
    	}
    	if(!awesomeBar.initiallyHomed()) {
    		homeArm.start();
    	}
    	if(!springTensioner.initiallyHomed()) {
    		homeTensioner.start();
    	}
    }

    @Override
    public void operatorControl() {
    	if(!catapultWinch.initiallyHomed()) {
    		homeWinch.start();
    	}
    	if(!awesomeBar.initiallyHomed()) {
    		homeArm.start();
    	}
    	if(!springTensioner.initiallyHomed()) {
    		homeTensioner.start();
    	}
    }

    @Override
    public void test() {
    	
    }
    
    @Override
    public void disabled() {
    	
    }
}
