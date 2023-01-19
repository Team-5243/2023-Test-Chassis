// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;

public class DriveSubsystem extends SubsystemBase {
  PWMSparkMax fr, fl, br, bl;
  DifferentialDrive diffDrive;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    fl = new PWMSparkMax(Constants.FLCAN);
    //fl.setInverted(true);
    fr = new PWMSparkMax(Constants.FRCAN);
    br = new PWMSparkMax(Constants.BRCAN);
    bl = new PWMSparkMax(Constants.BLCAN);
    //bl.setInverted(true);

    MotorControllerGroup left= new MotorControllerGroup(fl, bl);
    MotorControllerGroup right= new MotorControllerGroup(fr, br);
    diffDrive= new DifferentialDrive(left, right);

    
  }
  public void arcadeDrive(){
    diffDrive.arcadeDrive(Constants.LEFTJOY.getY(), Constants.LEFTJOY.getX());
  }

  public void setMotors(double left, double right) {
    diffDrive.arcadeDrive(left, right);
  }

  public void stopDrive() {
    diffDrive.arcadeDrive(0, 0);
}




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new DriveCommand(this));
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
