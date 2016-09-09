#ifndef SRC_UTILITIES_CONTROLLERS_H_
#define SRC_UTILITIES_CONTROLLERS_H_

#include "WPILib.h"

class Controllers {
private:
	Joystick *driveJoystick;
	Joystick *armJoystick;

	CANTalon *leftDriveMotor1;
	CANTalon *leftDriveMotor2;
	CANTalon *leftDriveMotor3;

	CANTalon *rightDriveMotor1;
	CANTalon *rightDriveMotor2;
	CANTalon *rightDriveMotor3;

	CANTalon *liftMotor;

	CANTalon *triggerMotor;
	CANTalon *winchMotor;

	CANTalon *hoodMotor;
	CANTalon *intakeMotor;

	DigitalInput *winchSwitch;
	DigitalInput *ballSensor;

public:
	Controllers();

	Joystick *&getDriveJoystick();
	Joystick *&getArmJoystick();

	CANTalon *&getLeftDrive();
	CANTalon *&getRightDrive();

	CANTalon *&getLiftMotor();

	CANTalon *&getTriggerMotor();
	CANTalon *&getWinchMotor();

	CANTalon *&getHoodMotor();
	CANTalon *&getIntakeMotor();

	DigitalInput *&getWinchSwitch();
	DigitalInput *&getBallSensor();
};

#endif /* SRC_UTILITIES_CONTROLLERS_H_ */
