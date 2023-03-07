// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class PIDArm extends CommandBase {
  /** Creates a new PIDArm. */
  private final ArmSubsystem armSubsystem;
  private final PIDController pidController;
  public PIDArm(ArmSubsystem armSubsystem, double setpoint) {
    this.armSubsystem = armSubsystem;
    this. pidController = new PIDController(0.3, 0.1, 0.01);
    pidController.setSetpoint(setpoint);
    addRequirements(armSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("ArmPIDCmd started");
    pidController.reset();
    //armSubsystem.resetArmEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = pidController.calculate(armSubsystem.getEncoderRotations());
    armSubsystem.setArmMotor(0.2 *speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   System.out.println("ArmPIDCmd ended!");
   armSubsystem.brakeMotor();
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
