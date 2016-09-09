#ifndef SRC_SUBSYSTEMS_DRIVEBASE_H_
#define SRC_SUBSYSTEMS_DRIVEBASE_H_

#include "WPILib.h"
#include "Utilities/Controllers.h"

class DriveBase {
private:
	Joystick *driveJoystick;

	CANTalon *leftDrive;
	CANTalon *rightDrive;

	double y;
	double x;
	double left;
	double right;
	double absLeft;
	double absRight;
	double maxOutput;
	double normalLeft;
	double normalRight;

public:
	DriveBase(Controllers *robotContorllers);

	void arcadeDrive();
};

#endif /* SRC_SUBSYSTEMS_DRIVEBASE_H_ */
