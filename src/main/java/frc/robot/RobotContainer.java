/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick; // JOYSTICK IMPORTED
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

// Util/Standard Class Imports ------------------------------
import frc.robot.subsystems.*;
import frc.robot.JoystUtil;
import frc.robot.commands.*;
// ---------------------------------------------------------

//WPILib Imports -----------------------------------------
// -----------------------------------------------------



public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  //Joysticks will go here --------------------------

  // --------------------------------------------

  // Practice Robot/Real Robot Checkswitch
  public static boolean practiceR = true;
  //
  // ------------------ Commands
  // ------------------ SUBSYSTEMS ----------------------------
  private static DrivetrainS m_DrivetrainS = new DrivetrainS();
  //----------------------------------------------------------
  public static Joystick driver = new Joystick(0);
  public static Joystick secondary = new Joystick(1);
  
  
  public RobotContainer() {
    // Configure the button bindings
    

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

public Command getAutonomousCommand() {
	return null;
}


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}
