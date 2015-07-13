package org.usfirst.frc3680.RecycleRush.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3680.RecycleRush.Robot;
import org.usfirst.frc3680.RecycleRush.RobotMap;
import org.usfirst.frc3680.RecycleRush.subsystems.ArmUpDown;
import edu.wpi.first.wpilibj.*;

public class  ArmDown extends Command {

    public ArmDown() {
        requires(Robot.armUpDown);
    }

    protected void initialize() {
    	
    	// Checks to see if the arm is already down too far. If is, do not run.
    	if(Robot.armUpDown.downTooFar() == true){
        	// Runs when the lower limit switch is held.
    		System.out.println("ArmDown Cannot Run - Lower Limit Switch Pressed | Resetting Encoder");
            ArmUpDown.encoder1.reset();
    	}
    	else{
    		// Moves arm down.
    		System.out.println("Arm is Moving Down");
        	Robot.armUpDown.armDown();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Continually outputs to Riolog when ArmDown is running.
    	System.out.println("ArmDown is Running");

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Does not allow command to run if it would break anything.
    	return Robot.armUpDown.downTooFar();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armUpDown.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
