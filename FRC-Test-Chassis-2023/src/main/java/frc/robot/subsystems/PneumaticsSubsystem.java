// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.PneumaticsCommand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;

public class PneumaticsSubsystem extends SubsystemBase {
  /** Creates a new PneumaticsSubsytem. */
  Solenoid testSolenoid;
  public PneumaticsSubsystem() {
    testSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    testSolenoid.set(true);
   // pcmCompressor  = new Compressor(0, PneumaticsModuleType.CTREPCM);
  }

  public void PneumaticsControl() {
    if (Constants.LEFTJOY.getRawButton(2)){
      testSolenoid.toggle();
    }
  }

  
  @Override
  public void periodic() {
   // setDefaultCommand(new PneumaticsCommand(this));
    // This method will be called once per scheduler run
  }



    private void ressor(int i, PneumaticsModuleType ctrepcm) {
    }
}
