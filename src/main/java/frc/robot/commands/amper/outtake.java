// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.amper;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.AmpConstants;
import frc.robot.subsystems.Amper;

public class outtake extends Command {
  Amper m_amper;
  public outtake(Amper amper) {
    m_amper = amper;
    addRequirements(m_amper);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_amper.setPower(AmpConstants.kAmpOuttakePower);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //trying to get the wheel to stop once it has spit out the note
    m_amper.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
