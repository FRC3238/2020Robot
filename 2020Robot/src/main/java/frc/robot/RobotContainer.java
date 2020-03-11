/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Collect123;
import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;
import frc.robot.commands.collect;
import frc.robot.commands.collect4;
import frc.robot.commands.collect5;
import frc.robot.commands.lignUp;
import frc.robot.commands.stopSpin;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Chassis chassis = new Chassis();
  public static Shooter shooter = new Shooter();
  private Joystick joystickOne = new Joystick(0);
  public static Elevator elevator = new Elevator(); //Defines the Elevator Subsystem. 
  public static Collector collector = new Collector();
  //public static Climber climber = new Climber(); //Defines Climber

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // set default commands
    chassis.setDefaultCommand(new Drive(joystickOne));
    collector.setDefaultCommand(new stopSpin());
    //climber.setDefaultCommand(new RunCommand(() -> climber.stopClimber()));
    // Configure the button bindings
    configureButtonBindings();
  }

 /** private ShuffleboardTab tab = Shuffleboard.getTab("variables are defined in here");
  private NetworkTableEntry firstWait =
  tab.add("First wait", 2)
  .getEntry();
  private NetworkTableEntry secondWait =
  tab.add("Second Wait", 0.5)
  .getEntry();

    double waiting = secondWait.getDouble(0.5);
    double firstWaiting = firstWait.getDouble(2);

  public Command getSimpleAutoCommand(){
    return new SequentialCommandGroup(
    new WaitCommand(firstWaiting),
    new ParallelDeadlineGroup(new WaitCommand(waiting), 
        new RunCommand(() -> chassis.drive(0.2, 0.2), chassis))
  );
  }*/ 
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton two = new JoystickButton(joystickOne, 2);
    two.whenHeld(new lignUp(joystickOne));
    JoystickButton trigger = new JoystickButton(joystickOne, 1);
    trigger.whenHeld(new Shoot());
    JoystickButton eleven = new JoystickButton(joystickOne, 11);
    JoystickButton twelve = new JoystickButton(joystickOne, 12);
    twelve.whenHeld(new RunCommand(() -> collector.Raise()));
    eleven.whenHeld(new collect());
    eleven.whenHeld(new RunCommand(() -> collector.Lower()));
    
    JoystickButton ten = new JoystickButton(joystickOne, 10);
    JoystickButton nine = new JoystickButton(joystickOne, 9);
    //ten.whenHeld(new RunCommand(() -> climber.raiseClimber()));
    //nine.whenHeld(new RunCommand(() -> climber.lowerClimber()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
                  new WaitCommand(3), 
                  new ParallelDeadlineGroup(
                          new WaitCommand(3),
                          new lignUp(joystickOne)
                  ),
                  new ParallelDeadlineGroup(
                          new WaitCommand(6),
                          new Shoot()), 
                  new ParallelDeadlineGroup(
                          new WaitCommand(1), 
                          new RunCommand(() -> chassis.drive(-0.2, -0.2)))
                  );
    }
}
         //////////
            //     //     
           //           //////////
          //     //    //  //  //
         //     //    //  //  //