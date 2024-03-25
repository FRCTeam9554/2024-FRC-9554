// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.amper;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANLauncher;

public class slowspeedlaunch extends Command {
  CANLauncher m_launcher;
  public slowspeedlaunch(CANLauncher launcher) {
    m_launcher = launcher;
  addRequirements(m_launcher);  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_launcher.setLaunchWheels(0.15, -0.15);
    m_launcher.setFeedWheels(-0.15, 0.15);
    m_launcher.setFloorIntake(-0.15);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_launcher.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
