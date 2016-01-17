
package org.usfirst.frc.team340.robot.subsystems;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Dummy subsystem for a simple Arm with a claw at the end. Includes motors, solenoids, and digital sensors.
 *@version 1.0
 */
public class ExampleClawArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	TalonSRX armMotor;
	TalonSRX clawMotor;
	
	Solenoid leftPiston;
	Solenoid rightPiston;
	
	public ExampleClawArm() {
		armMotor = new TalonSRX(RobotMap.ClawArmMotor);
		clawMotor = new TalonSRX(RobotMap.ClawTopMotor);
		
		leftPiston = new Solenoid(RobotMap.ClawLeftPiston);
		rightPiston = new Solenoid(RobotMap.ClawRightPiston);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void openClaw() {
    	leftPiston.set(true);
    	rightPiston.set(true);
    }
    
    public void closeClaw() {
    	leftPiston.set(false);
    	rightPiston.set(false);
    }
    
}

