package org.usfirst.frc.team340.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//
	// Motor Ports
	//
	
	public static int DriveLeftMotor = 0;
	public static int DriveRightMotor = 1;
	
	public static int ClawLeftMotor = 2;
	public static int ClawRightMotor = 3;
	
	//
	// Digital I/O Ports
	//
	
	public static int DriveLeftEncoder1 = 0;
	public static int DriveLeftEncoder2 = 1;
	public static int DriveRightEncoder1 = 2;
	public static int DriveRightEncoder2 = 3;
}
