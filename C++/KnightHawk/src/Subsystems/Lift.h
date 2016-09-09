#ifndef SRC_SUBSYSTEMS_LIFT_H_
#define SRC_SUBSYSTEMS_LIFT_H_

#include "WPILib.h"
#include "Utilities/Controllers.h"

class Lift {
private:
	Joystick *armJoystick;

	CANTalon *liftMotor;

public:
	Lift(Controllers *robotControllers);

	void setLift();
	void controlLift();
};

#endif /* SRC_SUBSYSTEMS_LIFT_H_ */
