/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Drive;

public class Chassis extends SubsystemBase {
  private TalonFX rightmotor1 = new TalonFX(Constants.DRIVE_MOTOR_1_ID);
  private TalonFX rightmotor2 = new TalonFX(Constants.DRIVE_MOTOR_2_ID);
  private TalonFX leftmotor1 = new TalonFX(Constants.DRIVE_MOTOR_3_ID);
  private TalonFX leftmotor2 = new TalonFX(Constants.DRIVE_MOTOR_4_ID);

  /**
   * Creates a new Chassis.
   */
  public Chassis() {
    rightmotor2.follow(rightmotor1);
    leftmotor2.follow(leftmotor1);
    leftmotor1.setInverted(TalonFXInvertType.CounterClockwise);
    leftmotor2.setInverted(TalonFXInvertType.CounterClockwise);
    rightmotor1.setInverted(TalonFXInvertType.Clockwise);
    rightmotor2.setInverted(TalonFXInvertType.Clockwise);
  }

  public void drive(double leftpower, double rightpower){
rightmotor1.set(ControlMode.PercentOutput, rightpower);
leftmotor1.set(ControlMode.PercentOutput, leftpower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
