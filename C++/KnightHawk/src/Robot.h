#ifndef SRC_ROBOT_H_
#define SRC_ROBOT_H_

#include "WPILib.h"

class Robot: public SampleRobot {
public:
	void RobotInit() override;
	void Autonomous() override;
	void OperatorControl() override;
	void Test() override;
};

#endif /*SRC_ROBOT_H_*/
