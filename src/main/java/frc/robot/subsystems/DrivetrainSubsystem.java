// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
 private WPI_TalonFX  leftMotor1 = new WPI_TalonFX(Constants.LEFT_FRONT_MOTOR);
  private WPI_TalonFX  leftMotor2 = new WPI_TalonFX(Constants.LEFT_REAR_MOTOR);
  private WPI_TalonFX  rightMotor1 = new WPI_TalonFX(Constants.RIGHT_FRONT_MOTOR);
  private WPI_TalonFX  rightMotor2 = new WPI_TalonFX(Constants.RIGHT_REAR_MOTOR);
  

 private final double kDriveTick2Feet = 1.0/128*Math.PI/12;

  MotorControllerGroup rightGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
  MotorControllerGroup leftGroup = new MotorControllerGroup(leftMotor1, leftMotor2);
  DifferentialDrive myDrive = new DifferentialDrive(leftGroup, rightGroup);
  
  public DrivetrainSubsystem() {
    
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public double getEncoderFeet(){
    double leftValue = leftMotor1.getSelectedSensorPosition()*kDriveTick2Feet;
    double rightValue = rightMotor1.getSelectedSensorPosition()*kDriveTick2Feet;
    double distance = (rightValue+leftValue)/2;
    return distance;
  }



  public void arcadeDrive(double speed, double rotation) {
    myDrive.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    myDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void curvatureDrive(double xSpeed, double zRotation, boolean turnInPlace) {
    myDrive.curvatureDrive(xSpeed, zRotation, turnInPlace);
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
