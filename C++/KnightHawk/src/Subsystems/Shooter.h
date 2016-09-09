#ifndef SRC_SUBSYSTEMS_SHOOTER_H_
#define SRC_SUBSYSTEMS_SHOOTER_H_

#include "WPILib.h"
#include "Utilities/Controllers.h"

class Shooter {
private:
	Joystick *armJoystick;

	CANTalon *triggerMotor;
	CANTalon *winchMotor;

	DigitalInput *ballSensor;

public:
	Shooter(Controllers *robotControllers);

	void shoot();
	void reload();
};

#endif /* SRC_SUBSYSTEMS_SHOOTER_H_ */
