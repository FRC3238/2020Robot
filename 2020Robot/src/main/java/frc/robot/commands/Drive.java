/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Drive extends CommandBase {
  private Joystick joystick;
  double sped = 0.0;
  double turn = 0.0;
  double speed = 0.0;

  /**
   * Creates a new Drive.
   */
  public Drive(Joystick joystickOne) {
    addRequirements(RobotContainer.chassis);
    joystick = joystickOne;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (joystick.getRawButtonPressed(3)) {
      sped = sped - 1;
    }
    if (joystick.getRawButtonPressed(4)) {
      sped = sped + 1;
    }
    if (sped == -1) {
      sped = 0;
    }
    if (sped == 0) {
      speed = joystick.getRawAxis(1) * 0.2;
      turn = joystick.getRawAxis(2) * 0.1;
    }
    if (sped == 1) {
      speed = joystick.getRawAxis(1) * 0.4;
      turn = joystick.getRawAxis(2) * 0.3;
    }
    if (sped == 2) {
      speed = joystick.getRawAxis(1) * 0.6;
      turn = joystick.getRawAxis(2) * 0.4;
    }
    if (sped == 3) {
      speed = joystick.getRawAxis(1) * 0.8;
      turn = joystick.getRawAxis(2) * 0.6;
    }
    if (sped >= 4) {
      sped = 3;
    };
//You know, I'm somewhat of a Gamer myself.
    RobotContainer.chassis.drive(-speed + turn, speed + turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}