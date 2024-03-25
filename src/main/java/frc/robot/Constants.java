// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorPort = 1; 
  }
  public static class LauncherConstants{
    //facing the back a is right b is left 
    public static final int kFeederaID = 1; 
    public static final int kFeederbID = 2; 
    public static final int kLauncheraID = 3;
    public static final int kLauncherbID = 4; 

    //current limit for feeders and launchers 

    public static final int kLauncheraLimit = 120; 
    public static final int kLauncherbLimit = 120; 
    public static final int kFeederaLimit = 60;
    public static final int kFeederbLimit = 60; 

    //speed for wheels when intaking and shooting for speaker

    public static final double kFeederaSpeed = -1; 
    public static final double kFeederbSpeed = 1; 
    public static final double kLauncheraSpeed = 1; 
    public static final double kLauncherbSpeed = -1; 
    public static final double kLauncherDelay = 2; 
    
  }
  //floor intake constants
  public static class FloorIntakeConstants{
    public static final int kFloorIntakeID = 9; 

    //current limit 
    public static final int kFloorIntakeLimit = 80; 

    //speed of wheels when intaking 
    public static final double kFloorIntakeSpeed = -1;
    public static final double kFloorOuttakeSpeed = 1;  

  }
  public static class DrivetrainConstatnts{

    public static final int kRightRearID = 5;
    public static final int kRightFrontID = 6; 
    public static final int kLeftRearID = 7;
    public static final int kLeftFrontID = 8;

    //current limit for drivetrain
    public static final int kRightRearLimit = 60; 
    public static final int kRightFrontLimit = 60;
    public static final int kLeftRearLimit = 60;
    public static final int kLeftFrontLimit = 60;
  }

  public static class AmperConstants{
    public static final int kAmperID = 10; 
    public static final int kAmperExtendSpeed = 1; 
    public static final int kAmperRetractSpeed = -1;
    public static final int KAmperIdlePower = 0; 
    public static final int kAmperCurrentLimit = 60; 

  }
}
