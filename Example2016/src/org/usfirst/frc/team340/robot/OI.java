package org.usfirst.frc.team340.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team340.robot.OI.LeftTrig1;
import org.usfirst.frc.team340.robot.OI.LeftTrig2;
import org.usfirst.frc.team340.robot.OI.RightTrig1;
import org.usfirst.frc.team340.robot.OI.RightTrig2;
import org.usfirst.frc.team340.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Init & Construct driver controller
	Joystick xBoxDriver = new Joystick(0);
	
	//Init & Construct driver controller buttons
	Button A1 = new JoystickButton(xBoxDriver, 1);
	Button B1 = new JoystickButton(xBoxDriver, 2);
	Button X1 = new JoystickButton(xBoxDriver, 3);
	Button Y1 = new JoystickButton(xBoxDriver, 4);
	Button LB1 = new JoystickButton(xBoxDriver, 5);
	Button RB1 = new JoystickButton(xBoxDriver, 6);
	Button Back1 = new JoystickButton(xBoxDriver, 7);
	Button Start1 = new JoystickButton(xBoxDriver, 8);
	Button LeftStick1 = new JoystickButton(xBoxDriver, 9);
	
	//Turn driver triggers to buttons
	public class RightTrig1 extends Button {
		public boolean get() {
			return xBoxDriver.getRawAxis(3) > .5;
		}
	}
	RightTrig1 rightTrig1 = new RightTrig1();
	
	public class LeftTrig1 extends Button {
		public boolean get() {
			return xBoxDriver.getRawAxis(2) > .5;
		}
	}
	LeftTrig1 leftTrig1 = new LeftTrig1();
	
	//Init & construct co-driver controller
	Joystick xBoxCoDriver = new Joystick(1);
	
	// Init and construct co-driver controller buttons
	Button A2 = new JoystickButton(xBoxCoDriver, 1);
	Button B2 = new JoystickButton(xBoxCoDriver, 2);
	Button X2 = new JoystickButton(xBoxCoDriver, 3);
	Button Y2 = new JoystickButton(xBoxCoDriver, 4);
	Button LB2 = new JoystickButton(xBoxCoDriver, 5);
	Button RB2 = new JoystickButton(xBoxCoDriver, 6);
	Button Back2 = new JoystickButton(xBoxCoDriver, 7);
	Button Start2 = new JoystickButton(xBoxCoDriver, 8);
	Button LeftStick2 = new JoystickButton(xBoxCoDriver, 9);
	
	//Turn co-driver triggers to buttons
	public class RightTrig2 extends Button {
		public boolean get() {
			return xBoxCoDriver.getRawAxis(3) > .5;
		}
	}
	RightTrig2 rightTrig2 = new RightTrig2();
	
	public class LeftTrig2 extends Button {
		public boolean get() {
			return xBoxCoDriver.getRawAxis(2) > .5;
		}
	}
	LeftTrig2 leftTrig2 = new LeftTrig2();
	
	public OI() {
		A1.whenPressed(new ExampleCommand());
	}
	
	public double getDriveMove() {
		return -xBoxDriver.getRawAxis(0);
	}
	
	public double getDriveRotate() {
		return xBoxDriver.getRawAxis(1);
	}
}

