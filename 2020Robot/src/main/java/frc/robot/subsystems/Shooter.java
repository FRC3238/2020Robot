/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private TalonFX Order66 = new TalonFX(5);
  private TalonFX order66 = new TalonFX(6);
  private TalonSRX Feeder = new TalonSRX(7);
  /**
   * Creates a new Shooter.
   */
  public Shooter() {
  }

  public void shoot(double Order66Power, double feederPower){
    Feeder.set(ControlMode.PercentOutput, feederPower);
    Order66.set(ControlMode.PercentOutput, Order66Power);
    order66.set(ControlMode.PercentOutput, Order66Power);  
      
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
