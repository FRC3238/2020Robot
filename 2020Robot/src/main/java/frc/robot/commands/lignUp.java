/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class lignUp extends CommandBase {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private Joystick joystick;
  double turn = 0;
  /**
   * Creates a new lignUp.
   */
  public lignUp(Joystick joystickOne) {
    joystick = joystickOne;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    table.getEntry("ledModes").setNumber(3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = table.getEntry("tx").getDouble(0.0);
    if (x >= 5){
      turn = x * 0.02;
    } else{
      turn = x * 0.03;
    }
    double speed = joystick.getRawAxis(1);
    RobotContainer.chassis.drive(speed -turn, speed + turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    table.getEntry("ledModes").setNumber(1);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
         //////////
            //     //     
           //           //////////
          //     //    //  //  //
         //     //    //  //  //