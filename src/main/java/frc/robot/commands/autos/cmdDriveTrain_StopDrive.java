package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class cmdDriveTrain_StopDrive extends Command {
  Drivetrain drive = new Drivetrain();
  public cmdDriveTrain_StopDrive(Drivetrain drive) {
    addRequirements(drive);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
