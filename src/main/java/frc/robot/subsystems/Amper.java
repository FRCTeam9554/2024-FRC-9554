// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import static frc.robot.Constants.AmperConstants.*;

public class Amper extends SubsystemBase {
  CANSparkMax amper; 

  public Amper() {
    amper = new CANSparkMax(kAmperID, MotorType.kBrushed);
    amper.setSmartCurrentLimit(kAmperCurrentLimit);
    

  }

  public void setExtendSpeed(int kAmperExtendSpeed){
    amper.set(kAmperExtendSpeed);
  }

  public void setRetractSpeed(int kAmperRetractSpeed){
    amper.set(kAmperRetractSpeed);
  }
 
  public void setIdlePower(int KAmperIdlePower){
    amper.set(KAmperIdlePower);
  }
  public void stop(){
    amper.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
