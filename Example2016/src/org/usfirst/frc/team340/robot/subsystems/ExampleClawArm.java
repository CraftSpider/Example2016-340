
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
    
    /**
     * Send arm to a specified potentiometer angle. Potentiometer for this example has zero corresponding exactly to the bottom and a max value corresponding exactly to the top.
     * <br><br><i>ALWAYS call in a loop.</i>
     */
    public void sendArmToPosition(int position) {
    	if (armAngleSensor.get() > position && !armAtBottom()) {
    		armMotor.set(-1);
    	} else if (armAngleSensor.get() < position && !armAtTop()) {
    		armMotor.set(1);
    	} else {
    		armMotor.stopMotor();
    	}
    }
    
    public void armToBottom() {
    	while(!armAtBottom()) {
    		armMotor.set(-1);
    	}
    	armMotor.stopMotor();
    }
    
    public void armToTop() {
    	while(!armAtTop()) {
    		armMotor.set(1);
    	}
    	armMotor.stopMotor();
    }
    
    public boolean armAtBottom() {
    	return ((armAngleSensor.get() < 1) || bottomSwitch.get());
    }
    
    public boolean armAtTop() {
    	return ((armAngleSensor.get() > 179) || topSwitch.get());
    }
}