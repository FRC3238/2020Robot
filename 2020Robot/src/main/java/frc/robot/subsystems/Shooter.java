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
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private TalonFX Order66 = new TalonFX(Constants.SHOOTER_MOTOR_2);
  private TalonFX order66 = new TalonFX(Constants.SHOOTER_MOTOR_1);
  private TalonSRX Feeder = new TalonSRX(Constants.SHOOTER_FEEDER_ID);
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    Order66.configOpenloopRamp(0.2);
    order66.configOpenloopRamp(0.2);
    Feeder.configOpenloopRamp(0.5);
    order66.follow(Order66);
    order66.setInverted(TalonFXInvertType.Clockwise);
    Order66.setInverted(TalonFXInvertType.CounterClockwise);
  }

  public void shoot(double Order66Power, double feederPower){
    Feeder.set(ControlMode.PercentOutput, -feederPower);
    Order66.set(ControlMode.PercentOutput, Order66Power);
    
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
