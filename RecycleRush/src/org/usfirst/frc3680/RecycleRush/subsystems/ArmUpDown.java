package org.usfirst.frc3680.RecycleRush.subsystems;

// Import all the things.
import org.usfirst.frc3680.RecycleRush.RobotMap;
import org.usfirst.frc3680.RecycleRush.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class ArmUpDown extends Subsystem {
	
	// Integrates motors, limit switches, and encoder from the RobotMap Class.
	SpeedController largerMotor = RobotMap.armUpDownLargerMotor;
    protected DigitalInput limitSwitchUp = new DigitalInput(RobotMap.ARMUP_LS);
    protected DigitalInput limitSwitchDown = new DigitalInput(RobotMap.ARMDOWN_LS);
    public static Encoder encoder1 = new Encoder(8, 9, false, EncodingType.k4X);
    
    // Declares methods for arm movements.
     public void armDown() {
    	// Moves arm down at full power.
    	RobotMap.armUpDownLargerMotor.set(-1);
    }
     
    public void armUp() {
    	// Encoder set-up.
    	RobotMap.armUpDownLargerMotor.set(1);
    	encoder1.setMinRate(10);
    	encoder1.setDistancePerPulse(5);
    	encoder1.setReverseDirection(false);
    	encoder1.setSamplesToAverage(7);
    	SmartDashboard.putNumber("Encoder Value", encoder1.getDistance());
    }
     
   
    
    public void armStop() {
    	// Stops motor.
    	RobotMap.armUpDownLargerMotor.set(0);
    }
    
    // Limit switch methods.
    
    public boolean upTooFar(){
    	// If the upper limit switch is hit.
    	return limitSwitchUp.get() == true; 
    }
    
    
    public boolean downTooFar(){
    	// If the lower limit switch is hit.
    	return limitSwitchDown.get() == false;
    }
    
    
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
}

