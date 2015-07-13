package org.usfirst.frc3680.RecycleRush.subsystems;


// Import all the things.
import org.usfirst.frc3680.RecycleRush.Robot;
import org.usfirst.frc3680.RecycleRush.RobotMap;
import org.usfirst.frc3680.RecycleRush.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


public class ArmOpenClose extends Subsystem {
    // Declares all motor controllers and limit switches.
	SpeedController smallerMotor = RobotMap.armOpenCloseSmallerMotor;
    protected DigitalInput limitSwitchClose = new DigitalInput(RobotMap.ARMCLOSE_LS);
    protected DigitalInput limitSwitchOpen = new DigitalInput(RobotMap.ARMOPEN_LS);
    
    
    public void armOpen() {
    	// Opens arm at 10% speed.
    	RobotMap.armOpenCloseSmallerMotor.set(-0.1);
    }
    
    public void armClose() {
    	// Closes arm at 20% speed.
    	RobotMap.armOpenCloseSmallerMotor.set(0.2);
    }
    
    public void armStop() {
    	// Stops arm from closing or opening.
    	RobotMap.armOpenCloseSmallerMotor.set(0);
    }
    public boolean openedTooFar(){
    	// Returns when open too far limit switch is hit.
    	return limitSwitchOpen.get() == true;
    }
    
    
    public boolean closedTooFar(){
    	// Returns when closed too far limit switch is hit.
    	return limitSwitchClose.get() == true;
    }
    
    

	public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
}

