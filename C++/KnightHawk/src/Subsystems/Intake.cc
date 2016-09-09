#include "Intake.h"

Intake::Intake(Controllers *robotControllers) {
	armJoystick = robotControllers->getArmJoystick();

	intakeMotor = robotControllers->getIntakeMotor();
}

void Intake::intakeBall() {
	if(armJoystick->GetRawButton(2)) {
		intakeMotor->Set(1);
	}
	else if(armJoystick->GetRawButton(3)) {
		intakeMotor->Set(-1);
	}
	else {
		intakeMotor->Set(0);
	}
}
