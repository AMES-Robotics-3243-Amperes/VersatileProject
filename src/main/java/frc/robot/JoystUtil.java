/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
// Library imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import static java.lang.System.out;
import static java.lang.Math.*;
import frc.robot.Constants;
/**
 * Add your docs here.
 */
public class JoystUtil {
    /*
    * Class below helps zero out minor movements falsely registered by the joysticks. 
    * It keeps you moving straight, and prevents the robot from moving while in place.
    * steer1 = joystick One / steer2 = joystick Two
    */
   /* ------- This was, for the most part, imported from last year's code. We just need something more simple for now.
    public static double matchZone(double steer1, double steer2){ 
        double matchZoneRadius = 0.09; //Still don't entirely know what this does.

        double avgSteer = (steer1 + steer2) / 2.0;
        if(Constants.TEST_VERSION){
            SmartDashboard.putNumber("avgSteer", avgSteer);
        }
        double r = matchZoneRadius / 2.0;
        //Defining upper and lower boundaries. Sort of don't know how this works
        double lowerBound = (avgSteer - r <= 0) ? -1 : 0;
        double upperBound = (avgSteer + r >= 0) ? 1 : 0;

    }
    */
    public static double lerp(double a, double b, double f) { //Linear interpolation: midpoint essentially
        return a + f * (b - a);
      }
    public static double deadZone (double dead){
        double deadZoneRadius = 0.09;
        // 0.09 for the joystick is considered too insignificant to be measured.
        return signum(dead) * max(0, abs(dead * (1 + deadZoneRadius)) - deadZoneRadius);
    }

    public static double scaleZone (double scale){
        return scale * abs(scale); // Keeps the value negative
    }
    public static double getAxisMagnitude(Joystick joyst, int xAxis) // Gets vector length (magnitude). The direction is only x or y.
  {
    return sqrt(pow(joyst.getRawAxis(xAxis), 2) + pow(joyst.getRawAxis(xAxis +1), 2));// 1 is added to xAxis to make it yAxis
  }
}
