// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TopIntake;

public class ManuelTopIntake extends CommandBase {
  /** Creates a new ManuelTopIntake. */
  private TopIntake ManuelTopIntake;
  private final Supplier<Double> speedFunction;
  
  public ManuelTopIntake(TopIntake ManuelTopIntake, Supplier<Double> speedFunction) {
    this.ManuelTopIntake = ManuelTopIntake;
    this.speedFunction = speedFunction;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ManuelTopIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    ManuelTopIntake.manuelTopIntake(realTimeSpeed);
    ManuelTopIntake.brakeMotor();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
