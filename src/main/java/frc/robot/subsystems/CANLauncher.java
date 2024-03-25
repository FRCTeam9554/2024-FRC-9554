// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.LauncherConstants.*;
import static frc.robot.Constants.FloorIntakeConstants.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;



public class CANLauncher extends SubsystemBase {
  private final DigitalInput notesensor = new DigitalInput(0);
  CANSparkMax m_launchawheel;
  CANSparkMax m_launchbwheel;
  CANSparkMax m_feedawheel;
  CANSparkMax m_feedbwheel;
  CANSparkMax m_floorintake;

  //Creates new launcher
  public CANLauncher() {
   
    m_launchawheel = new CANSparkMax(kLauncheraID,MotorType.kBrushless);
    m_launchbwheel = new CANSparkMax(kLauncherbID,MotorType.kBrushless); 
    m_feedawheel = new CANSparkMax(kFeederaID,MotorType.kBrushed);
    m_feedbwheel = new CANSparkMax(kFeederbID,MotorType.kBrushed);
    m_floorintake = new CANSparkMax(kFloorIntakeID,MotorType.kBrushless);

    m_launchawheel.restoreFactoryDefaults();
    m_launchbwheel.restoreFactoryDefaults();
    m_feedawheel.restoreFactoryDefaults();
    m_feedbwheel.restoreFactoryDefaults();
    m_floorintake.restoreFactoryDefaults();

    m_launchawheel.setSmartCurrentLimit(kLauncheraLimit);
    m_launchbwheel.setSmartCurrentLimit(kLauncherbLimit);
    m_feedawheel.setSmartCurrentLimit(kFeederaLimit);
    m_feedbwheel.setSmartCurrentLimit(kFeederbLimit);
    m_floorintake.setSmartCurrentLimit(kFloorIntakeLimit);
  }
    public Boolean hasnote(){
      return !notesensor.get();
    }
    public void setLaunchWheels(double kLauncheraSpeed, double kLauncherbSpeed){
      m_launchawheel.set(kLauncheraSpeed);
      m_launchbwheel.set(kLauncherbSpeed);

    }
    public void setFeedWheels(double kFeederaSpeed, double kFeederbSpeed){
      m_feedawheel.set(kFeederaSpeed);
      m_feedbwheel.set(kFeederbSpeed);
    }
    
    public void setFloorIntake(double kFloorIntakeSpeed){
      m_floorintake.set(kFloorIntakeSpeed);
    }

    public void setFloorOuttake(double kFloorOuttakeSpeed){
      m_floorintake.set(kFloorOuttakeSpeed);
    }
    
    public void stop(){
      m_launchawheel.set(0);
      m_launchbwheel.set(0);
      m_feedawheel.set(0);
      m_feedbwheel.set(0);
      m_floorintake.set(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
