// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import static frc.robot.Constants.AmpConstants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType; 

 


public class Amper extends SubsystemBase {

  CANSparkMax ampMotor;
  /** Creates a new Amp. */
  public Amper() {
    ampMotor = new CANSparkMax (kAmpID,MotorType.kBrushless);
    ampMotor.setInverted(true);
  }
  
  public void setPower(double power){
    ampMotor.set(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void stop() {
    ampMotor.set(0);
  }
}
