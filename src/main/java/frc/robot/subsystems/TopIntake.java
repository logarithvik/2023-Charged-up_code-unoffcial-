// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
/*import com.ctre.phoenixpro.hardware.TalonFX;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;*/

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TopIntake extends SubsystemBase {
  /** Creates a new TopIntake. */
  WPI_TalonFX intake;
  boolean m_stopped;

  public TopIntake() {
    m_stopped = false;
    intake= new WPI_TalonFX(Constants.Top_Intake);
  }
  
  public void manuelTopIntake(double speed){
    intake.set(ControlMode.PercentOutput, speed);
    
  }

  public void brakeMotor(){
    intake.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {


   // SmartDashboard.putNumber("Intake Temp",intake.getMotorTemperature());
    //SmartDashboard.putNumber("Intake Current",intake.getOutputCurrent());
    /*double motorTemperature = intake.getMotorTemperature();
    if(m_stopped) {
        if(motorTemperature <= 48) {
            m_stopped = false;
        }
    } else if(motorTemperature > 50) {
        m_stopped = true;
        intake.set(0);
    }

    if(m_stopped) {
        intake.set(0);
    } else {
        // do stuff
    }
    // This method will be called once per scheduler run
    intake.setSmartCurrentLimit(
    25, // stall limit in Amperes
    100 // free speed limit in Amperes
);*/
  }
}
