// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  TalonFX arm = new TalonFX(Constants.ARM_MOTOR);
  private final double KTick2Rotate = 1.0/2046.0;
  
  public ArmSubsystem() {
   //arm.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
    //arm.setSelectedSensorPosition(0, 0, 10);
    


  }

  public void setArmMotor(double speed) {
    arm.set(ControlMode.PercentOutput, speed);
    
    /*if(getEncoderRotations()<(-1)||getEncoderRotations()>37){ 
      arm.set(ControlMode.PercentOutput, 0);
    }*/
  }
    //SmartDashboard.putNumber("arm power (%)", percent);
    //SmartDashboard.putNumber("arm motor current (amps)", arm.getOutputCurrent());
    //SmartDashboard.putNumber("arm motor temperature (C)", arm.getTemperature());
  

  public void brakeMotor(){
    arm.setNeutralMode(NeutralMode.Brake);
  }
        

  public void resetArmEncoders() {
    arm.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //SmartDashboard.putNumber("Arm Encoder Value", arm.getSelectedSensorPosition()*KTick2Rotate);
    //arm.setNeutralMode(NeutralMode.Brake);
    SmartDashboard.putNumber("Arm Encoder Value",getEncoderRotations());

    //System.out.println("wow:"+ arm.getSelectedSensorPosition());

  }
public double getEncoderRotations(){
    double rotate = arm.getSelectedSensorPosition()*KTick2Rotate;
    System.out.println("rotate:"+rotate);
    return rotate;
  }

}
