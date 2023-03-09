// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveCommand;

public class DriveSubsystem extends SubsystemBase {
  PWMSparkMax fr, fl, br, bl;
  double s = 0, rot = 0, a = 0.5;
  DifferentialDrive diffDrive;
/*fdshfhdjshfhgtjvddsgsjfhdisjgdfgsdjglsfhdsjfshfsdjiotfds System.Out.Println("L") */
  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    fl = new PWMSparkMax(Constants.FLCAN);
    //fl.setInverted(false);
    fr = new PWMSparkMax(Constants.FRCAN);
    //fr.setInverted(false);
    br = new PWMSparkMax(Constants.BRCAN);
    //br.setInverted(false);
    bl = new PWMSparkMax(Constants.BLCAN);
    //bl.setInverted(true);

    MotorControllerGroup left= new MotorControllerGroup(fl, bl);
    MotorControllerGroup right= new MotorControllerGroup(fr, br);
    diffDrive= new DifferentialDrive(left, right);
  }

  
  public void arcadeDrive(){
    diffDrive.arcadeDrive(Constants.LEFTJOY.getX(), -1*Constants.LEFTJOY.getY());
  }

  public void LParcadeDrive(){
    diffDrive.arcadeDrive(
      -a*Constants.LEFTJOY.getX() + (a-1)*rot, 
      a*Constants.LEFTJOY.getY() + (a-1)*s);
      s = Constants.LEFTJOY.getY();
      rot = Constants.LEFTJOY.getX();
  }

  public void tankDrive(){
    diffDrive.tankDrive(-1*Constants.LEFTJOY.getY(), Constants.RIGHTJOY.getY());
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
