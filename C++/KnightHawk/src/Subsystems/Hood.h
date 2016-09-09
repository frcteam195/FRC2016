#ifndef SRC_SUBSYSTEMS_HOOD_H_
#define SRC_SUBSYSTEMS_HOOD_H_

#include "WPILib.h"
#include "Utilities/Controllers.h"

class Hood {
private:
	Joystick *armJoystick;

	CANTalon *hoodMotor;

	/*
		TBD
	*/
public:
	Hood(Controllers *robotControllers);

	void setHood();
	void controlHood();
};

#endif /* SRC_SUBSYSTEMS_HOOD_H_ */
