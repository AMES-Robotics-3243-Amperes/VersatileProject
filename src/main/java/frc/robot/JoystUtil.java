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
import static java.lang.System.out; // Don't have to keep using Math.(command name)
import static java.lang.Math.*;
import frc.robot.Constants;
/**
 * Add your docs here.
 */
public class JoystUtil {
    
  public static double matchZone(double steer){
    double matchZoneRadius = 0.09; // When joysticks are within 0.09 of eachother

    double result = signum(steer) * max(0, abs(steer)); // Not sure if this will work
    return result;
  }
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
