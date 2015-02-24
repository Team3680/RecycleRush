package org.usfirst.frc3680.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3680.RecycleRush.Robot;
import org.usfirst.frc3680.RecycleRush.RobotMap;
import edu.wpi.first.wpilibj.*;

public class  ArmClose extends Command {

    public ArmClose() {
        requires(Robot.armOpenClose);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       
        // Checks to see if the arm is already closed too far. If is, do not run.
    	if(Robot.armOpenClose.closedTooFar() == false){
    		// Runs when the closed limit switch is held.
    		System.out.println("ArmDown Cannot Run - Closed Limit Switch Pressed");
    	}
    	else
    	{
    		// Closes arm.
    		System.out.println("Arm is Closing");
    		Robot.armOpenClose.armClose();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("ArmClose is Running");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Does not allow command to run if it would break anything.
        return Robot.armOpenClose.closedTooFar() == false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stops arm.
    	Robot.armOpenClose.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {    	
    	end();
    }
}
