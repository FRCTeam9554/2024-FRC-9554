// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkLowLevel.MotorType;
import static frc.robot.Constants.DrivetrainConstatnts.*;

public class Drivetrain extends SubsystemBase {
  CANSparkMax RightRear = new CANSparkMax(kRightRearID, MotorType.kBrushed);
  CANSparkMax RightFront = new CANSparkMax(kRightFrontID, MotorType.kBrushed);
  CANSparkMax LeftRear = new CANSparkMax(kLeftRearID, MotorType.kBrushed);
  CANSparkMax LeftFront = new CANSparkMax(kLeftFrontID, MotorType.kBrushed);
  DifferentialDrive m_drivetrain;

  public Drivetrain() {
    RightRear.restoreFactoryDefaults();
    RightFront.restoreFactoryDefaults(); 
    LeftRear.restoreFactoryDefaults();
    LeftFront.restoreFactoryDefaults();

    //current limits 
    RightRear.setSmartCurrentLimit(kRightRearLimit);
    RightFront.setSmartCurrentLimit(kRightFrontLimit);
    LeftRear.setSmartCurrentLimit(kLeftRearLimit);
    LeftFront.setSmartCurrentLimit(kLeftFrontLimit);

    //making the motors follow
    LeftRear.follow(LeftFront);
    RightRear.follow(RightFront);

    //invert left side so both side drive forward
    LeftFront.setInverted(true);
    RightFront.setInverted(false);

    m_drivetrain = new DifferentialDrive(RightFront, LeftFront);
  }
  public void arcadeDrive(double speed, double rotation){
    m_drivetrain.arcadeDrive(speed, rotation);
  }
  // Tank drive for student to try out
  public void tankDrive(double leftSpeed, double rightSpeed){ 
    m_drivetrain.tankDrive(leftSpeed, rightSpeed);
  }

  public void stop(){
    RightRear.stopMotor();
    RightFront.stopMotor();
    LeftFront.stopMotor();
    LeftRear.stopMotor();
  }
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
