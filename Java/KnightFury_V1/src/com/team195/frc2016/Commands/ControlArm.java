package com.team195.frc2016.Commands;

import com.team195.frc2016.Utilities.Controllers;
import com.team195.frc2016.Subsystems.Arm;

import edu.wpi.first.wpilibj.Joystick;

public class ControlArm {
	private Joystick buttonBox1;
	
	private Arm awesomeBar;
	
	public ControlArm(Controllers robotControllers, Arm awesomeBar) {
		buttonBox1 = robotControllers.getButtonBox1();
		
		this.awesomeBar = awesomeBar;
	}
	
	public void setpointControl() {
		if(buttonBox1.getRawButton(7)) {
			awesomeBar.setSetpoint(297);
		} 
		else if(buttonBox1.getRawButton(8)) {
			awesomeBar.setSetpoint(-4800);
		}
		else if(buttonBox1.getRawButton(9)) {
			awesomeBar.setSetpoint(-4200);
		}
		else if(buttonBox1.getRawButton(10)) {
			awesomeBar.setSetpoint(-1500);
		}
	}
}
