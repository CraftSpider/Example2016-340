
package org.usfirst.frc.team340.robot.subsystems;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
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
	
	private TalonSRX armMotor;
	private TalonSRX clawMotor;
	
	private Solenoid leftPiston;
	private Solenoid rightPiston;
	
	private AnalogPotentiometer armAngleSensor;
	private DigitalInput bottomSwitch;
	private DigitalInput topSwitch;
	
	public ExampleClawArm() {
		armMotor = new TalonSRX(RobotMap.ClawArmMotor);
		clawMotor = new TalonSRX(RobotMap.ClawTopMotor);
		
		leftPiston = new Solenoid(RobotMap.ClawLeftPiston);
		rightPiston = new Solenoid(RobotMap.ClawRightPiston);
		
		armAngleSensor = new AnalogPotentiometer(RobotMap.ClawArmAngleSensor);
		
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
    
    public void sendArmToPosition(int position) {
    	if (armAngleSensor.get() > position && !bottomSwitch.get()) {
    		armMotor.set(-1);
    	} else if (armAngleSensor.get() < position && !topSwitch.get()) {
    		armMotor.set(1);
    	} else {
    		armMotor.stopMotor();
    	}
    }
}

