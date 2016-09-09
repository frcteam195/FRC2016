#ifndef SRC_UTILITIES_TASKCONTROL_H_
#define SRC_UTILITIES_TASKCONTROL_H_

#include "WPILib.h"
#include "Controllers.h"
#include "Subsystems/DriveBase.h"
#include "Subsystems/Lift.h"
#include "Subsystems/Shooter.h"
#include "Subsystems/Intake.h"
#include "Subsystems/Hood.h"

class TaskControl {
private:
	DriveBase *robotDrive;
	Task *driveTask;

	Lift *shooterLift;
	Task *setLiftTask;
	Task *controlLiftTask;

	Shooter *ballShooter;
	Task *shooterTask;

	Intake *ballIntake;
	Task *intakeTask;

	Hood *shooterHood;
	Task *setHoodTask;
	Task *controlHoodTask;

public:
	TaskControl(Controllers *robotControllers);

	void runDrive();

	void setLift();
	void controlLift();

	void runShooter();

	void runIntake();

	void setHood();
	void controlHood();

	void startThreads();
};

#endif /* SRC_UTILITIES_TASKCONTROL_H_ */
