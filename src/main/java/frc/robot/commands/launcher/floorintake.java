// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher;
import frc.robot.subsystems.CANLauncher;
import static frc.robot.Constants.FloorIntakeConstants.*; 
import edu.wpi.first.wpilibj2.command.Command;

public class floorintake extends Command {
  CANLauncher m_launcher;
  public floorintake(CANLauncher launcher) {
    m_launcher =  launcher;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_launcher.setFloorIntake(kFloorIntakeSpeed);
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
