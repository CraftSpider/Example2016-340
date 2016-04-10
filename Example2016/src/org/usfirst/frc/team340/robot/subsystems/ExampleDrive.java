package org.usfirst.frc.team340.robot.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc.team340.robot.Robot;
import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Dummy subsystem for simple drive code, including motors and encoders.
 *@version 1.0
 */
public class ExampleDrive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	// Drive motors
	private TalonSRX leftDrive;
	private TalonSRX rightDrive;
	
	// Drive speed variables
	public double leftMotorSpeed;
	public double rightMotorSpeed;
	
	// Encoders on motors
	private Encoder leftDriveEncoder;
	private Encoder rightDriveEncoder;

    // Logger
    Logger logger = Robot.getLogger("drive");
	
	public ExampleDrive() {
		leftDrive = new TalonSRX(RobotMap.DriveLeftMotor);
		rightDrive = new TalonSRX(RobotMap.DriveRightMotor);
		
		leftDriveEncoder = new Encoder(RobotMap.DriveLeftEncoder1,RobotMap.DriveLeftEncoder2);
		rightDriveEncoder = new Encoder(RobotMap.DriveRightEncoder1,RobotMap.DriveRightEncoder2);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithXbox());
    }
    
    public void resetEncoder(){
    	leftDriveEncoder.reset();
    	rightDriveEncoder.reset();
    }
    
    public double getLeftEncoder(){
    	return leftDriveEncoder.get();
    }
    
    public double getRightEncoder(){
    	return rightDriveEncoder.get();
    }
    
    public void setLeftDrive(double speed) {
    	if(speed > 1) {
    		speed = 1;
    	} else if(speed < -1) {
    		speed = -1;
    	}
    	leftDrive.set(speed);
    }
    
    public void setRightDrive(double speed) {
    	if(speed > 1) {
    		speed = 1;
    	} else if(speed < -1) {
    		speed = -1;
    	}
    	rightDrive.set(speed);
    }
    
    public void setBothDrive(double leftOutput, double rightOutput){
    	setLeftDrive(leftOutput);
    	setRightDrive(rightOutput);
    }

    public void StopBothDrive() {
        setLeftDrive(0);
        setRightDrive(0);
    }
    
    public void arcadeDrive(double moveValue, double rotateValue){
    	if (moveValue >= 0.0){
    		moveValue = (moveValue * moveValue);	
   		} else {
   			moveValue = -(moveValue * moveValue);
   			
   		}
    	if (rotateValue >= 0.0){
    		rotateValue = (rotateValue * rotateValue);
    	} else {
    		rotateValue = -(rotateValue *rotateValue);
    	}
    	if (moveValue > 0.0) 
        {
        
            if (rotateValue > 0.0) 
            {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } 
        
            else 
            {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        }
        
        else 
        {
            if (rotateValue > 0.0) 
            {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
            else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }
    	setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
   	}
}

