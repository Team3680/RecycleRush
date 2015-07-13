package org.usfirst.frc3680.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3680.RecycleRush.Robot;
import org.usfirst.frc3680.RecycleRush.RobotMap;
import org.usfirst.frc3680.RecycleRush.subsystems.ArmOpenClose;
import org.usfirst.frc3680.RecycleRush.subsystems.ArmUpDown;

import edu.wpi.first.wpilibj.*;

public class  ArmOpen extends Command {

    public ArmOpen() {
        requires(Robot.armOpenClose);
    }

    protected void initialize() {
    	
    	if(Robot.armOpenClose.openedTooFar() == true){
        	// Runs when the open limit switch is held.
    		System.out.println("ArmOpen Cannot Run - Lower Limit Switch Pressed");
    	}
    	else{
    		// Moves arm down.
    		System.out.println("Arm is Moving Down");
        	Robot.armOpenClose.armOpen();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("ArmOpen is Running");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Does not allow command to run if it would break anything.
    	return Robot.armOpenClose.openedTooFar() == false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armOpenClose.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
