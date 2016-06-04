package com.team195.frc2016;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;
import com.team195.frc2016.Subsystems.*;
//import com.team195.frc2016.Commands.*;
import com.team195.frc2016.Threads.*;

import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {
	private Controllers robotControllers;
	private Sensors robotSensors;

	private Arm awesomeBar;
	private Winch catapultWinch;
	private Tensioner catapultTensioner;

	private HomeWinchThread homeWinch;
	private HomeArmThread homeArm;
	private HomeTensionerThread homeTensioner;

	private DriveBase cyberDrive;
	private DriveThread runDrive;

	public Robot() {
		robotControllers = new Controllers();
		robotSensors = new Sensors();

		awesomeBar = new Arm(robotControllers);
		catapultWinch = new Winch(robotControllers, robotSensors);
		catapultTensioner = new Tensioner(robotControllers, robotSensors);

		homeArm = new HomeArmThread(awesomeBar);
		homeWinch = new HomeWinchThread(catapultWinch);
		homeTensioner = new HomeTensionerThread(catapultTensioner);

		cyberDrive = new DriveBase(robotControllers);
		runDrive = new DriveThread(cyberDrive);
	}

	@Override
	public void robotInit() {

	}

	@Override
	public void autonomous() {
		if(!homeArm.isAlive())
			homeArm.start();
		if(!homeWinch.isAlive())
			homeWinch.start();
		if(!homeTensioner.isAlive())
			homeTensioner.start();
	}

	@Override
	public void operatorControl() {
		if(!homeArm.isAlive())
			homeArm.start();
		if(!homeWinch.isAlive())
			homeWinch.start();
		if(!homeTensioner.isAlive())
			homeTensioner.start();
		if(awesomeBar.isHomed() && catapultWinch.isHomed() && catapultTensioner.isHomed())
			runDrive.start();
	}

	@Override
	public void test() {

	}

	@Override
	public void disabled() {

	}
}
