// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ManualDrive;
import frc.robot.commands.ManuelArm;
import frc.robot.commands.ManuelTopIntake;
import frc.robot.commands.PIDArm;
//import frc.robot.commands.PIDAutoBalence;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.TopIntake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem myDrive  = new DrivetrainSubsystem();
  private final ArmSubsystem Arm = new ArmSubsystem();
  private final TopIntake topIntake= new TopIntake();
  //private final IMU imu= new IMU();
  public static XboxController cont1 = new XboxController(Constants.DRIVE_CONT);
  public static XboxController cont2 = new XboxController(Constants.WEAPONS_CON);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

      myDrive.setDefaultCommand(new ManualDrive(myDrive,
      () -> -0.8*cont1.getRightX(),
      () -> -0.8*cont1.getLeftY(),
      () -> cont1.getLeftBumper()));

      Arm.setDefaultCommand(new ManuelArm( Arm,
      () ->-0.2 * cont2.getRightY()));

      /*if (cont2.getAButtonPressed()){
        Arm.setDefaultCommand(new PIDArm(Arm, 10));
      }*/

      topIntake.setDefaultCommand(new ManuelTopIntake(topIntake,
       () -> 0.7*cont2.getLeftY()));


  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xboxlk}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    /*// Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());*/
    new JoystickButton(cont2,Constants.A_BUTTON ).whileTrue(new PIDArm(Arm, Constants.CONE_ONE));
    new JoystickButton(cont2,Constants.B_BUTTON ).whileTrue(new PIDArm(Arm, Constants.CONE_TWO));
    new JoystickButton(cont2,Constants.START_BUTTON ).whileTrue(new PIDArm(Arm, Constants.pickUP));
    new JoystickButton(cont2,Constants.BACK_BUTTON ).whileTrue(new PIDArm(Arm, Constants.SET_ZERO));
    //new JoystickButton(cont1, Constants.A_BUTTON).whileTrue(new PIDAutoBalence(myDrive, imu));
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
   
    return null;
  }
}
