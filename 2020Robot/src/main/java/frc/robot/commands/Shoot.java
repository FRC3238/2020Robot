/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Shoot extends CommandBase {
  private Timer timer = new Timer();
  /**
   * Creates a new Shoot.
   */
  public Shoot() {
    addRequirements(RobotContainer.shooter);
    addRequirements(RobotContainer.elevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double timerCount = timer.getFPGATimestamp();
    if (timerCount >= 1.5){
      RobotContainer.elevator.driveElevator(0.3);
    }
    if (timerCount <= 0.5){
      NetworkTable ty = NetworkTableInstance.getDefault().getTable("limelight");
    double y = ty.getEntry("ty").getDouble(0.0);
    double distance = 53 / Math.tan(Math.toRadians(31) + Math.toRadians(y));
    double shooterset = distance * 0.002;
    RobotContainer.shooter.shoot(-0.8, -0.1);
    } 
    if (timerCount > 0.5){
      NetworkTable ty = NetworkTableInstance.getDefault().getTable("limelight");
    double y = ty.getEntry("ty").getDouble(0.0);
    double distance = 53 / Math.tan(Math.toRadians(31) + Math.toRadians(y));
    double shooterset = distance * 0.002;
    RobotContainer.shooter.shoot(-0.8, 0.5);
    } // Le Epic Gamer has died
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      RobotContainer.shooter.shoot(0, 0);
      RobotContainer.elevator.driveElevator(0);
      RobotContainer.collector.resetBallCount();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
