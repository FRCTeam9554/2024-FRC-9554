// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.launcher.launchnote;
import frc.robot.commands.launcher.preparelaunch;
import frc.robot.subsystems.CANLauncher;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class shootandbackup extends SequentialCommandGroup {
  CANLauncher launcher; 
  Drivetrain drivetrain;
  public shootandbackup(Drivetrain drivetrain, CANLauncher launcher) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new preparelaunch(launcher).withTimeout(2.0).andThen(
      new launchnote(launcher).withTimeout(1).andThen(
      new backup(drivetrain).andThen(
      new cmdDriveTrain_StopDrive(drivetrain)))));
  }
}
