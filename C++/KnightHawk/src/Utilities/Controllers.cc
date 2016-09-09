#include "Controllers.h"

Controllers::Controllers() {
	driveJoystick = new Joystick(0);
	armJoystick = new Joystick(1);

	leftDriveMotor1 = new CANTalon(1);
	leftDriveMotor2 = new CANTalon(2);
	leftDriveMotor2->SetControlMode(CANSpeedController::kFollower);
	leftDriveMotor2->Set(1);
	leftDriveMotor3 = new CANTalon(3);
	leftDriveMotor3->SetControlMode(CANSpeedController::kFollower);
	leftDriveMotor3->Set(1);

	rightDriveMotor1 = new CANTalon(4);
	rightDriveMotor2 = new CANTalon(5);
	rightDriveMotor2->SetControlMode(CANSpeedController::kFollower);
	rightDriveMotor2->Set(4);
	rightDriveMotor3 = new CANTalon(6);
	rightDriveMotor3->SetControlMode(CANSpeedController::kFollower);
	rightDriveMotor3->Set(4);

	liftMotor = new CANTalon(7);

	triggerMotor = new CANTalon(8);
	winchMotor = new CANTalon(9);

	hoodMotor = new CANTalon(10);
	intakeMotor = new CANTalon(11);

	winchSwitch = new DigitalInput(1);
	ballSensor = new DigitalInput(2);
}

Joystick *&Controllers::getDriveJoystick() {
	return driveJoystick;
}

Joystick *&Controllers::getArmJoystick() {
	return armJoystick;
}

CANTalon *&Controllers::getLeftDrive() {
	return leftDriveMotor1;
}

CANTalon *&Controllers::getRightDrive() {
	return rightDriveMotor1;
}

CANTalon *&Controllers::getLiftMotor() {
	return liftMotor;
}

CANTalon *&Controllers::getTriggerMotor() {
	return triggerMotor;
}

CANTalon *&Controllers::getWinchMotor() {
	return winchMotor;
}

CANTalon *&Controllers::getHoodMotor() {
	return hoodMotor;
}

CANTalon *&Controllers::getIntakeMotor() {
	return intakeMotor;
}

DigitalInput *&Controllers::getWinchSwitch() {
	return winchSwitch;
}

DigitalInput *&Controllers::getBallSensor() {
	return ballSensor;
}
