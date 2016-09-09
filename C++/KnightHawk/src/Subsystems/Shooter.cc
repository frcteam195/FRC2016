#include "Shooter.h"

Shooter::Shooter(Controllers *robotControllers) {
	armJoystick = robotControllers->getArmJoystick();

	triggerMotor = robotControllers->getTriggerMotor();
	winchMotor = robotControllers->getWinchMotor();

	ballSensor = robotControllers->getBallSensor();
}

void Shooter::shoot() {

	reload();
}

void Shooter::reload() {

}
