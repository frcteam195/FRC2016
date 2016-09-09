#ifndef SRC_SUBSYSTEMS_UNTAKE_H_
#define SRC_SUBSYSTEMS_UNTAKE_H_

#include "WPILib.h"
#include "Utilities/Controllers.h"

class Intake {
private:
	Joystick *armJoystick;

	CANTalon *intakeMotor;

public:
	Intake(Controllers *robotControllers);

	void intakeBall();
};

#endif /* SRC_SUBSYSTEMS_UNTAKE_H_ */
