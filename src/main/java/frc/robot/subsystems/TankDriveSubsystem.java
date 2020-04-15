/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class TankDriveSubsystem extends SubsystemBase {
  // Speed Controllers
  private final Talon leftFront = new Talon(Constants.LEFT_FRONT);
  private final Talon rightFront = new Talon(Constants.RIGHT_FRONT);
  
  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftFront, rightFront);
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public TankDriveSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

}
