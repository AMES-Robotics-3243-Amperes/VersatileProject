/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;





// Util/Standard Class Imports ------------------------------
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.JoystUtil;
import frc.robot.commands.DriveTrainC;
// ---------------------------------------------------------

//WPILib Imports -----------------------------------------
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick; // JOYSTICK IMPORTED
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
// -----------------------------------------------------



public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Practice Robot/Real Robot Checkswitch
  public static boolean practiceR = true;
  //
  
  // ------------------ SUBSYSTEMS ----------------------------
  private static DrivetrainS m_DrivetrainS = new DrivetrainS();
  // ------------------ COMMANDS ------------------------------
  private final static DriveTrainC m_DriveTrainC = new DriveTrainC(m_DrivetrainS);
  //-----------------------------------------------------------
  // Variables and object declarations
  public static Joystick driver = new Joystick(0); // Joysticks
  public static Joystick secondary = new Joystick(1);
  static double steerLeft;
  static double steerRight;
  public static boolean isPractice = true; // Change to false when importing actual code.
  //

  
  
  public RobotContainer() {
    // Configure the button bindings
    

    configureButtonBindings();
  }

// Testing new branch
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() { // USE FOR BUTTONS ONLY!
    
     
  }
  public static double configureJoyst(){ // I may have something...
    steerLeft = getJoystickValues(true);
    double steerR = getJoystickValues(false);
    steerLeft = JoystUtil.matchZone(steerLeft);
    return steerLeft;
  }
  public static double getJoystickValues(boolean isLeft){
    double move = isLeft ? JoystUtil.getAxisMagnitude(driver, 0) : JoystUtil.getAxisMagnitude(driver, 1) * Math.signum(driver.getRawAxis(3));
    move = JoystUtil.deadZone(move);
    return move;
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
//Joystick methods --------------------------
public static Command getDriveCommand(){

  return m_DriveTrainC;
}
  
// --------------------------------------------
}
