package org.usfirst.frc3680.RecycleRush;
 
// Import all the things.
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Declares all motors and drives.
    public static Victor armUpDownLargerMotor;
    public static Victor armOpenCloseSmallerMotor;
    public static TalonSRX driveTrainDriveTalon;
    public static TalonSRX driveTrainDriveTalon2;
    public static TalonSRX driveTrainDriveTalon3;
    public static TalonSRX driveTrainDriveTalon4;
    public static Joystick driveStick;
    public static RobotDrive driveTrainDrive;
    // Declares DIO ports for limit switches.
    public static final int ARMCLOSE_LS = 2;
    public static final int ARMOPEN_LS = 1;
    public static final int ARMUP_LS = 3;
    public static final int ARMDOWN_LS = 4;
    public static final int ARMUPDOWN_ENC = 9;
    
    public static void init() {
    	// Initializes all motor controllers and drives, and gives them class-specific names. 
        armUpDownLargerMotor = new Victor(3);
        LiveWindow.addActuator("ArmUpDown", "LargerMotor", (Victor) armUpDownLargerMotor);
        
        armOpenCloseSmallerMotor = new Victor(4);
        LiveWindow.addActuator("ArmOpenClose", "SmallerMotor", (Victor) armOpenCloseSmallerMotor);
        //Rear Left
        driveTrainDriveTalon = new TalonSRX(5);
        LiveWindow.addActuator("DriveTrain", "DriveTalon", (TalonSRX) driveTrainDriveTalon);
        //Rear Right
        driveTrainDriveTalon2 = new TalonSRX(6);
        LiveWindow.addActuator("DriveTrain", "DriveTalon2", (TalonSRX) driveTrainDriveTalon2);
      //Front Right
        driveTrainDriveTalon3 = new TalonSRX(7);
        //driveTrainDriveTalon.setBounds(100, 0, 0, 3, 0);
       // driveTrainDriveTalon2.setBounds(100, 0, 0, 3, 0);
        
       
       LiveWindow.addActuator("DriveTrain", "DriveTalon3", (TalonSRX) driveTrainDriveTalon3);
        
       // Front Left
       driveTrainDriveTalon4 = new TalonSRX(8);
        LiveWindow.addActuator("DriveTrain", "DriveTalon4", (TalonSRX) driveTrainDriveTalon4);
       // driveTrainDriveTalon4.setBounds(100, 0, 0, 3, 0);
        driveTrainDrive = new RobotDrive(driveTrainDriveTalon, driveTrainDriveTalon4, driveTrainDriveTalon2, driveTrainDriveTalon3);
        
        // Declares settings for RobotDrive.
        driveTrainDrive.setSafetyEnabled(true);
        driveTrainDrive.setExpiration(0.1);
        driveTrainDrive.setSensitivity(0.5);
        driveTrainDrive.setMaxOutput(1.0);
        }
}
