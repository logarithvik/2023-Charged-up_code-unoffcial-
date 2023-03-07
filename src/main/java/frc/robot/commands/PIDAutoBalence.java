// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.IMU;
import frc.robot.subsystems.DrivetrainSubsystem;

public class PIDAutoBalence extends CommandBase {
  /** Creates a new PIDAutoBalence. */
    private DrivetrainSubsystem driveSubsystem;
  private final PIDController pidController;
  private IMU imu;
  public PIDAutoBalence(DrivetrainSubsystem driveSubsystem, IMU imu ) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSubsystem = driveSubsystem;
    //this.imu= imu;
    this.pidController = new PIDController(0.75, 0.1, 0.01);
    pidController.setSetpoint(0);
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("BalencePIDCmd started");
    pidController.reset();    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = pidController.calculate(imu.getPitchAngleDegrees());
    //driveSubsystem.arcadeDrive(0,0.1 *speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  System.out.println("BalencePIDCmd ended!");
  driveSubsystem.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
