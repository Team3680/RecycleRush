package org.usfirst.frc3680.RecycleRush;
// TODO: Autonomous. All of it.

// Import all the things.
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc3680.RecycleRush.commands.*;
import org.usfirst.frc3680.RecycleRush.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	// Declare required variables for later in this class.
    Command autonomousCommand;

    public static OI oi;
    public static ArmUpDown armUpDown;
    public static ArmOpenClose armOpenClose;
    public static DriveTrain driveTrain;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize RobotMap.
    	RobotMap.init();
     
        // Connect to Arm and DriveTrain subsystems.
        armUpDown = new ArmUpDown();
        armOpenClose = new ArmOpenClose();
        driveTrain = new DriveTrain();
        
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        autonomousCommand = new AutonomousCommand();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	// TODO Reset all motors and variables.
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        // Declare joystick variables.
        Joystick driveStick;
        Joystick otherStick;
        driveStick = new  Joystick(0); 
        otherStick = new Joystick(1);
        
        // Put encoder value to SmartDashboard.
        SmartDashboard.putNumber("Encoder Value", ArmUpDown.encoder1.getDistance());
        
        // Print to RioLog when lower limit switch is held.
        if(Robot.armUpDown.downTooFar() == true){
        	// Prints to RioLog.
    		System.out.println("Encod1Reset - Lower Limit Switch Pressed");
    		
    		// Reset encoder value to 0.
    		ArmUpDown.encoder1.reset();
      
        }
        
        // Declare gyroscope variable.
        Gyro gyro = new Gyro(1);
        
        while (isEnabled() && isOperatorControl()) {
        	// Backup variables for use if drive train does not work.
        	double magnitude = driveStick.getMagnitude();
            double direction = driveStick.getDirectionDegrees();
            double rotation = driveStick.getY();
        
            // Put backup joystick variables to SmartDashboard.
        	SmartDashboard.putNumber("Magnitude", magnitude);
        	SmartDashboard.putNumber("Direction", direction);
        	SmartDashboard.putNumber("Rotation", rotation);
        	
        	// Mecanum drivetrain code
        	RobotMap.driveTrainDrive.mecanumDrive_Cartesian(otherStick.getX(), driveStick.getX(), rotation, gyro.getAngle());
        	
        	// Put gyro variable to SmartDashboard.
        	Timer.delay(0.005);
        	 SmartDashboard.putNumber("Gyro", gyro.getAngle());
             
        }
    }
    
    

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
