// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ManuelArm extends CommandBase {
  /** Creates a new ManuelArm. */
    private ArmSubsystem ManuelArm;
  private final Supplier<Double> speedFunction;
  public ManuelArm(ArmSubsystem ManuelArm,Supplier<Double> speedFunction) {
    this.ManuelArm = ManuelArm;
    this.speedFunction = speedFunction;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ManuelArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    ManuelArm.setArmMotor(realTimeSpeed);
    System.out.println("distance: "+ManuelArm.getEncoderRotations());
    ManuelArm.brakeMotor();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
        System.out.println(ManuelArm.getEncoderRotations());

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
