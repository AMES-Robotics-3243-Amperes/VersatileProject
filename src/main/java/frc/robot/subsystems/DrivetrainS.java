/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
// Driver imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//

//Class imports//
import frc.robot.subsystems.*;
import frc.robot.commands.DriveTrainC;
import frc.robot.JoystUtil;
import frc.robot.Constants;
import frc.robot.RobotContainer;
/**
 * This is driving base code that will later be slave controlled by DT commmand slave
 */
public class DrivetrainS extends SubsystemBase{
    // New motor objects
    static SpeedController motorOne; // SpeedController: Inferface for speed controlling devices
    static SpeedController motorTwo;
    static SpeedController motorThree;
    double SpeedOne = 0.5; // These will be used for the electronics board
    double SpeedTwo = 0.5;
    double SpeedThree = 0.5;
    // Encoder Objects //
    //static Encoder VictorEncodeOne; // Encoder: Class to read quadrature encoders. Devices used to count shaft rotation and can sense direction
    //static Encoder VictorEncodeTwo; // Worry about encoding later 
    //static Encoder VictorEncodeThree;

    //
    public static SpeedControllerGroup m_leftmotors; // SpeedControllerGroup: Allows for multiple speedController objects to be linked together
    public static SpeedControllerGroup m_rightmotors;
    public static SpeedControllerGroup m_Practice; // this is just a practice obj that links all the three motors on the electrical board as one
    static boolean testing = true; // This is just set to be so for testing the elect board
    static double victorOne = 0.0; // This needs to be changed when connected to an actual robot
    static double victorTwo = 0.0; // Same here as well
    static double victorThree = 0.0;
    static double timeAtLastTankDrive = -1;
    static final double SMOOTH_DECLARATION_COEFF = 5;
    
    public DrivetrainS() {
    if(RobotContainer.practiceR){ // incorporate && practice board for if
        motorOne = new WPI_VictorSPX(Constants.DriveConstants.kPracOneID); // Instantiating objects
        motorTwo = new WPI_VictorSPX(Constants.DriveConstants.kPracTwoID);
        motorThree = new WPI_VictorSPX(Constants.DriveConstants.kPracThreeID);

        // public DifferentialDrive driving = new DifferentialDrive(motorOne, motorTwo); - to be worked on later
        m_Practice = new SpeedControllerGroup(motorOne, motorTwo, motorThree);
       // VictorEncodeOne.reset(); //Resets distance recorded on the encoder
       // VictorEncodeTwo.reset();
       // VictorEncodeThree.reset();

    } else {
        // Other motor layouts will be incorporated here in the coming days. 
    }
}
public void setMotorSpeed(double speed){
    motorOne.set(speed);
    motorTwo.set(speed);
    motorThree.set(speed);
}

//public static Encoder getVictorOne(){
   // return VictorEncodeOne;
//}
//public static Encoder getVictorTwo(){
 //   return VictorEncodeTwo;
//}
//public static Encoder getVictorThree(){
 //   return VictorEncodeThree;
//}




//public static void resetEncode(){
   // if(VictorEncodeOne != null && VictorEncodeTwo != null && VictorEncodeThree != null){
  //      VictorEncodeOne.reset();
   //     VictorEncodeTwo.reset();
   //     VictorEncodeThree.reset();
   // }
//}
//public static void setPosition(double leftSet, double rightSet){ // Project for later
 //   double motorSpeedOne;
  //  double motorSpeedTwo;
  //  double motorSpeedThree;
  //  if(VictorEncodeOne != null && VictorEncodeTwo != null && VictorEncodeThree != null){
        // more to be added
  //  } else {
   //     motorSpeedOne = 0;
  //      motorSpeedTwo = 0;
  //      motorSpeedThree = 0;
   // }
    

//}

@Override
public void periodic(){

    SmartDashboard.putNumber("victorOne", SpeedOne);
    SmartDashboard.putNumber("VictorTwo", SpeedTwo);
    SmartDashboard.putNumber("VictorThree", SpeedThree);
}


}

