package org.usfirst.frc3680.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3680.RecycleRush.Robot;
import org.usfirst.frc3680.RecycleRush.RobotMap;
import org.usfirst.frc3680.RecycleRush.subsystems.ArmUpDown;
import edu.wpi.first.wpilibj.*;

public class  ArmUp extends Command {

    public ArmUp() {
        requires(Robot.armUpDown);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.armUpDown.upTooFar() == false){
        	// Runs when the upper limit switch is held.
    		System.out.println("ArmUp Cannot Run - Upper Limit Switch Pressed");
    		ArmUpDown.encoder1.reset();	
    	}
    	else{
    		// Moves arm up.
        	Robot.armUpDown.armUp();
        	
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Continually outputs to Riolog when ArmUp is running.
    	System.out.println("ArmUp is Running"); 
    	if(Robot.armUpDown.encoder1.getDistance() >= 100){
        		end();
        	}
    	
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Calls when the upper limit switch is pressed. Allows end() to run.
    	return Robot.armUpDown.upTooFar() == false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stops the arm from moving up or down.
    	Robot.armUpDown.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	// Stops command from running.
    	end();
    }
}
