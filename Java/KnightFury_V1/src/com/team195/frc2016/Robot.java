package com.team195.frc2016;

import com.team195.frc2016.Controllers;
import com.team195.frc2016.Sensors;
import com.team195.frc2016.Commands.*;
import com.team195.frc2016.Threads.*;

import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {
	private Controllers robotControllers;
	private Sensors robotSensors;

	private HomeMotors motorInit;

	private HomeWinchThread homeWinch;
	private HomeArmThread homeArm;
	private HomeTensionerThread homeTensioner;

	public Robot() {
		robotControllers = new Controllers();
		robotSensors = new Sensors();

		motorInit = new HomeMotors(robotControllers, robotSensors);

		homeArm = new HomeArmThread(motorInit);
		homeWinch = new HomeWinchThread(motorInit);
		homeTensioner = new HomeTensionerThread(motorInit);
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
	}

	@Override
	public void test() {

	}

	@Override
	public void disabled() {

	}
}
