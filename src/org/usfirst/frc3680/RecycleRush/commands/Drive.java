package org.usfirst.frc3680.RecycleRush.commands;

import org.usfirst.frc3680.RecycleRush.Robot;
import org.usfirst.frc3680.RecycleRush.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveMecanum(RobotMap.driveStick.getX(), RobotMap.otherStick.getX(), -RobotMap.driveStick.getY(), RobotMap.gyro.getAngle());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
