// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

/** An example command that uses an example subsystem. */
public class ManualDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private DrivetrainSubsystem driveSubsystem;
    private final Supplier<Double> speedFunction, turnFunction;
    private final Supplier<Boolean> slowMode;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ManualDrive(DrivetrainSubsystem driveSubsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction, Supplier<Boolean> slowMode) {
    this.driveSubsystem = driveSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    this.slowMode = slowMode;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();
    boolean slow = slowMode.get();

    
    if (slow) {
      realTimeSpeed *= 0.5;
      realTimeTurn *= 0.5;
    } 
    

    driveSubsystem.arcadeDrive(realTimeSpeed, realTimeTurn);
    // driveSubsystem.curvatureDrive(realTimeTurn, realTimeSpeed, slow);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Manual drive disengaged");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
