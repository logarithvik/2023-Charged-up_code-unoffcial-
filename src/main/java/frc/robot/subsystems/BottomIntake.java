// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BottomIntake extends SubsystemBase {
  /** Creates a new BottomIntake. */
  TalonFX motor1 = new TalonFX(Constants.BOTTOM_ROTATE);
  TalonFX motor2 = new TalonFX(Constants.BOTTOM_INTAKE);

  public BottomIntake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
    public void manuelBottomIntake(double speed){
    //intake.set(ControlMode.PercentOutput, speed);
    
  }
}
