// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.PneumaticsSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PneumaticsCommand extends CommandBase {
  /** Creates a new PneumaticsCommand. */
  private final PneumaticsSubsystem m_subsystem;
  public PneumaticsCommand(PneumaticsSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_subsystem.retract();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //PUT FINAL METHOD IN HERE DUMBASS!!!!!!!!
    m_subsystem.toggle();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
