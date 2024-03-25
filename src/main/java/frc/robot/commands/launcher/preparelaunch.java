// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANLauncher;
import static frc.robot.Constants.LauncherConstants.*;

public class preparelaunch extends Command {
    CANLauncher m_launcher;
  public preparelaunch(CANLauncher launcher) {
    m_launcher = launcher; 
    addRequirements(m_launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_launcher.setLaunchWheels(kLauncheraSpeed, kLauncherbSpeed);
  }
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
