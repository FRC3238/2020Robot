/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Drive;

public class Chassis extends SubsystemBase {
  private TalonFX rightmotor1 = new TalonFX(1);
  private TalonFX rightmotor2 = new TalonFX(2);
  private TalonFX leftmotor1 = new TalonFX(3);
  private TalonFX leftmotor2 = new TalonFX(4);
  private CANSparkMax rightmotor1a = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax rightmotor2a = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax leftmotor1a = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax leftmotor2a = new CANSparkMax(4, MotorType.kBrushless);
  /**
   * Creates a new Chassis.
   */
  public Chassis() {
    rightmotor2.follow(rightmotor1);
    leftmotor2.follow(leftmotor1);
    leftmotor1.getInverted();
    leftmotor2.getInverted();
    rightmotor2a.follow(rightmotor1a);
    leftmotor2a.follow(leftmotor1a);
    leftmotor1a.getInverted();
    leftmotor2a.getInverted();
    rightmotor1a.setOpenLoopRampRate(0.2);
    rightmotor2a.setOpenLoopRampRate(0.2);
    leftmotor1a.setOpenLoopRampRate(0.2);
    leftmotor2a.setOpenLoopRampRate(0.2);
  }

  public void drive(double leftpower, double rightpower){
rightmotor1.set(ControlMode.PercentOutput, rightpower);
leftmotor1.set(ControlMode.PercentOutput, leftpower);
rightmotor1a.set(rightpower);
leftmotor1a.set(leftpower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
