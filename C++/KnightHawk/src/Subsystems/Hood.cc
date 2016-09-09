#include "Hood.h"

Hood::Hood(Controllers *robotControllers) {
	armJoystick = robotControllers->getArmJoystick();

	hoodMotor = robotControllers->getHoodMotor();
}

void Hood::setHood() {

}


void Hood::controlHood() {

}
