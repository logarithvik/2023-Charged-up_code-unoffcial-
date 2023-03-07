// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class PIDAuto extends CommandBase {
  /** Creates a new PIDAuto. */
  private DrivetrainSubsystem driveSubsystem;
  private final PIDController pidController;
  public PIDAuto(DrivetrainSubsystem driveSubsystem, double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSubsystem =  driveSubsystem;
    this.pidController = new PIDController(0.75, 0.1, 0.01);
    pidController.setSetpoint(setpoint);
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("PID auto started!");
    pidController.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }
   /*double speed = pidController.calculate(driveSubsystem.getEncodermeters());
    driveSubsystem.arcadeDrive(speed, 0);
  } */ 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.arcadeDrive(0, 0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
