#include <Utilities/TaskControl.h>

TaskControl::TaskControl(Controllers *robotControllers) {
	robotDrive = new DriveBase(robotControllers);
	driveTask = new Task("DriveTask", &TaskControl::runDrive, this);

	shooterLift = new Lift(robotControllers);
	setLiftTask = new Task("SetLiftTask", &TaskControl::setLift, this);
	controlLiftTask = new Task("ControlLiftTask", &TaskControl::controlLift, this);

	ballShooter = new Shooter(robotControllers);
	shooterTask = new Task("ShooterTask", &TaskControl::runShooter, this);

	ballIntake = new Intake(robotControllers);
	intakeTask = new Task("IntakeTask", &TaskControl::runIntake, this);

	shooterHood = new Hood(robotControllers);
	setHoodTask = new Task("SetHoodTask", &TaskControl::setHood, this);
	controlHoodTask = new Task("ControlHoodTask", &TaskControl::controlHood, this);
}

void TaskControl::runDrive() {
	while(true) {
		robotDrive->arcadeDrive();
	}
}

void TaskControl::setLift() {
	while(true) {
		shooterLift->setLift();
	}
}

void TaskControl::controlLift() {
	while(true) {
		shooterLift->controlLift();
	}
}

void TaskControl::runShooter() {
	while(true) {
		ballShooter->shoot();
		ballShooter->reload();
	}
}

void TaskControl::runIntake() {
	while(true) {
		ballIntake->intakeBall();
	}
}

void TaskControl::setHood() {
	while(true) {
		shooterHood->setHood();
	}
}

void TaskControl::controlHood() {
	while(true) {
		shooterHood->controlHood();
	}
}

void TaskControl::startThreads() {
	driveTask->join();

	setLiftTask->join();
	controlLiftTask->join();

	shooterTask->join();

	intakeTask->join();

	setHoodTask->join();
	controlHoodTask->join();
}
