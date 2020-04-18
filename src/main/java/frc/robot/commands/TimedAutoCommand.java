/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.TankDriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 * An example command that uses an example subsystem.
 */
public class TimedAutoCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final TankDriveSubsystem tankDriveSubsystem;
  private final Timer timer = new Timer();
  private boolean finished = false;

  /**
   * Creates a new TankDriveCommand
   *
   * @param subsystem The subsystem used by this command.
   */
  public TimedAutoCommand(TankDriveSubsystem subsystem) {
    tankDriveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(tankDriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.print("TimedAutoCommand Execute\n");
    if (timer.hasElapsed(Constants.TIMED_AUTO_10SECS)) {
      finished = true;
      timer.stop();
    } else {
      tankDriveSubsystem.drive(Constants.AUTO_LEFTSPEED, Constants.AUTO_RIGHTSPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tankDriveSubsystem.drive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
