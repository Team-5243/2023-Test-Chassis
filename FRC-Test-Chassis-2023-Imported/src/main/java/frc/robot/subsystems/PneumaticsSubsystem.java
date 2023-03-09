// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.PneumaticsCommand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

public class PneumaticsSubsystem extends SubsystemBase{
  /** Creates a new PneumaticsSubsytem. */
  DoubleSolenoid testSolenoid;
  Compressor testPCMCompressor;
  public PneumaticsSubsystem() {
    testSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.PENUMATIC_A, Constants.PENUMATIC_B);
    testPCMCompressor = new Compressor(PneumaticsModuleType.CTREPCM);
    testPCMCompressor.enableDigital();
    //testPCMCompressor.disable();
    //testPCMCompressor.enableDigital();
    //testPCMCompressor.enableAnalog(80, 100);

    // pcmCompressor  = new Compressor(0, PneumaticsModuleType.CTREPCM);
  }   

  public void expand() {
    System.out.println(Value.kForward);
    testSolenoid.set(Value.kForward);
  }

  public void retract() {
    System.out.println(Value.kReverse);
    testSolenoid.set(Value.kReverse);
  }

  public void stop() {
    testSolenoid.set(Value.kOff);
  }

  public void toggle() {
    //testSolenoid.toggle(); 
    if (testSolenoid.get().equals(Value.kForward)) {
      retract();
    } else if (testSolenoid.get().equals(Value.kReverse)) {
      expand();
    }
  }

  



    // if(Constants.LEFTJOY.getRawButton(4)){
    //   testSolenoid.toggle();
    // }
  
  
  @Override
  public void periodic() {
   //setDefaultCommand(new PneumaticsCommand(this));
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}
