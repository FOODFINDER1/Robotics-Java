/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private SpeedControllerGroup LeftMotors;
  private SpeedControllerGroup RightMotors;
  private boolean AVal;

  @Override
  public void robotInit() {
    PWMVictorSPX m_RL = new PWMVictorSPX(0);
    PWMVictorSPX m_FL = new PWMVictorSPX(1);
    PWMVictorSPX m_FR = new PWMVictorSPX(2);
    PWMVictorSPX m_RR = new PWMVictorSPX(3);
    
    final SpeedControllerGroup LeftMotors = new SpeedControllerGroup(m_RL, m_FL);
    final SpeedControllerGroup RightMotors = new SpeedControllerGroup(m_RR, m_FR);
    
    
    
    m_myRobot = new DifferentialDrive(LeftMotors, RightMotors);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
    
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
    
    
    
    System.out.println(m_leftStick.getRawButton(1));
    
  
  
  
  }
}
