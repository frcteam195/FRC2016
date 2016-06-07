package com.team195.frc2016;

import com.team195.frc2016.Utilities.Controllers;
import com.team195.frc2016.Utilities.Sensors;
import com.team195.frc2016.Subsystems.*;
import com.team195.frc2016.Commands.*;
import com.team195.frc2016.Threads.*;

import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {
	private Controllers robotControllers;
	private Sensors robotSensors;

	private Arm awesomeBar;
	private HomeArmThread homeArm;
	private ControlArm armControlCommand;
	private ArmControlThread controlArm;
	
	private Winch catapultWinch;
	private Tensioner catapultTensioner;
	private Intake robotIntake;

	private HomeWinchThread homeWinch;
	private HomeTensionerThread homeTensioner;
	private IntakeThread runIntake;

	private DriveBase cyberDrive;
	private DriveThread runDrive;

	public Robot() {
		robotControllers = new Controllers();
		robotSensors = new Sensors();

		awesomeBar = new Arm(robotControllers);
		homeArm = new HomeArmThread(awesomeBar);
		armControlCommand = new ControlArm(robotControllers, awesomeBar);
		controlArm = new ArmControlThread(armControlCommand);
		
		catapultWinch = new Winch(robotControllers, robotSensors);
		catapultTensioner = new Tensioner(robotControllers, robotSensors);
		robotIntake = new Intake(robotControllers);

		homeWinch = new HomeWinchThread(catapultWinch);
		homeTensioner = new HomeTensionerThread(catapultTensioner);
		runIntake = new IntakeThread(robotIntake);

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
		
		if(awesomeBar.isHomed() && catapultWinch.isHomed() && catapultTensioner.isHomed()) {
			runDrive.start();
			controlArm.start();
			runIntake.start();
		}
	}

	@Override
	public void test() {

	}

	@Override
	public void disabled() {

	}
}
