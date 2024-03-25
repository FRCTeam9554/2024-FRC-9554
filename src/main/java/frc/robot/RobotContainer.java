// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.amper.extend;
import frc.robot.commands.amper.idle;
import frc.robot.commands.amper.retract;
import frc.robot.commands.amper.slowspeedlaunch;
//import frc.robot.commands.amper.slowspeedlaunch;
import frc.robot.commands.autos.shootandbackup;
import frc.robot.commands.launcher.floorintake;
import frc.robot.commands.launcher.floorouttake;
import frc.robot.commands.launcher.launchnote;
import frc.robot.commands.launcher.preparelaunch;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.CANLauncher;
import frc.robot.subsystems.Amper;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final CANLauncher m_launcher = new CANLauncher();
  public final Drivetrain m_drivetrain =  new Drivetrain();
  public final Amper m_amper = new Amper();
  private final CommandXboxController m_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorPort);
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }
  private void configureBindings() {
    //default command to drvie using the joysticks
    m_drivetrain.setDefaultCommand(
      new RunCommand(
        ()-> m_drivetrain.tankDrive(-m_driverController.getLeftY(), -m_driverController.getRightY()), m_drivetrain)
    );
    //m_drivetrain.setDefaultCommand(
    //  new RunCommand(
    //    ()-> m_drivetrain.arcadeDrive
    //    (m_driverController.getLeftY(), 
    //      m_driverController.getRightX()), m_drivetrain));

    //operator will launch when pushing right bumper and floorintake when pushing right bumber
    m_operatorController.leftBumper().whileTrue(new preparelaunch(m_launcher).
      withTimeout(0.5).andThen(new launchnote(m_launcher)).andThen());
    m_operatorController.rightBumper().whileTrue(new floorintake(m_launcher));
    m_operatorController.b().whileTrue(new floorouttake(m_launcher));
  
     
      
  //operator will use amper with slowspeedlaunch
  m_amper.setDefaultCommand(new idle(m_amper));
    m_operatorController.a().whileTrue(new slowspeedlaunch(m_launcher)); 
    m_operatorController.x().whileTrue(new extend(m_amper));
    m_operatorController.y().whileTrue(new retract(m_amper));

  
  }
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
   return new shootandbackup(m_drivetrain, m_launcher);
  }
}
