package org.usfirst.frc3680.RecycleRush.subsystems;


// Imports all the things.
import org.usfirst.frc3680.RecycleRush.RobotMap;
import org.usfirst.frc3680.RecycleRush.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    SpeedController driveTalon = RobotMap.driveTrainDriveTalon;
    SpeedController driveTalon2 = RobotMap.driveTrainDriveTalon2;

    public void initDefaultCommand() {
        }
}

