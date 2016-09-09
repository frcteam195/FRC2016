#include "Lift.h"

Lift::Lift(Controllers *robotControllers) {
	armJoystick = robotControllers->getArmJoystick();

	liftMotor = robotControllers->getLiftMotor();
}

void Lift::setLift() {

}


void Lift::controlLift() {

}
