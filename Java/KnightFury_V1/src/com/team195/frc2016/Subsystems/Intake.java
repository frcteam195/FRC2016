package com.team195.frc2016.Subsystems;

import com.team195.frc2016.Utilities.Controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;

public class Intake {
	private Joystick buttonBox2;

	private CANTalon intakeMotor;

	public Intake(Controllers robotControllers) {
		buttonBox2 = robotControllers.getButtonBox2();

		intakeMotor = robotControllers.getIntakeMotor();
	}

	public void run() {
		if(buttonBox2.getRawButton(7)) {
			intakeMotor.set(1);
		}
		else if(buttonBox2.getRawButton(3)) {
			intakeMotor.set(-1);
		}
		else {
			intakeMotor.set(0);
		}
	}
}
