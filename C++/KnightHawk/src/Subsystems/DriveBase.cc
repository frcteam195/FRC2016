#include "DriveBase.h"

DriveBase::DriveBase(Controllers *robotControllers) {
	driveJoystick = robotControllers->getDriveJoystick();

	leftDrive = robotControllers->getLeftDrive();
	rightDrive = robotControllers->getRightDrive();

	y = 0;
	x = 0;
	left = 0;
	right = 0;
	absLeft = 0;
	absRight = 0;
	maxOutput = 1;
	normalLeft = 0;
	normalRight = 0;
}

void DriveBase::arcadeDrive() {
	y = driveJoystick->GetRawAxis(1);
	x = driveJoystick->GetRawAxis(0);
	left = y + x;
	right = y - x;
	absLeft = abs(left);
	absRight = abs(right);

	if(absLeft > absRight && absLeft > maxOutput) {
		normalLeft = left / absLeft;
		normalRight = right / absLeft;
	}
	else if(absRight > absLeft && absRight > maxOutput) {
		normalLeft = left / absRight;
		normalRight = right / absRight;
	}
	else {
		normalLeft = left;
		normalRight = right;
	}

	normalRight *= -1;

	leftDrive->Set(normalLeft);
	rightDrive->Set(normalRight);
}
