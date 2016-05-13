package legopkg;

import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class MotorDriver implements Runnable {

	
	EV3ColorSensor colorSensor;
	SampleProvider colorProvider;
    
	float[] colorSample;
	
	public MotorDriver() {
			
	Port s3=LocalEV3.get().getPort("S3");
	colorSensor = new EV3ColorSensor(s3);
	colorProvider = colorSensor.getColorIDMode();
	colorSample = new float[colorProvider.sampleSize()];
	}
	
 public void run()
	{
while (Button.ESCAPE.isUp()) 
	{
  while(!Thread.interrupted())
  {
	 int currentDtectedColor = colorSensor.getColorID();
	switch (currentDtectedColor)
	{
			case Color.RED :
					Motor.A.setSpeed(0);
					Motor.B.setSpeed(0);
					Motor.A.backward();
					Motor.B.backward();
					Delay.msDelay(2000);
					System.out.println("Got RED ");
					break; 
					
			case Color.GREEN:
				
					Motor.A.setSpeed(360);
					Motor.B.setSpeed(360);
					Motor.A.backward();
					Motor.B.backward();
				    Delay.msDelay(2000);
					System.out.println("Got GREEN ");
				    break; 
		
			case Color.YELLOW:
				
					System.out.println("Got YELLOW ");
					Motor.A.setSpeed(100);
					Motor.B.setSpeed(100);
					Motor.A.backward();
					Motor.B.backward();
					Delay.msDelay(2000);
					break; 
			default: 
			            System.out.println("DEFAULT RUNNING IN GREEN MODE\n");
						Motor.A.setSpeed(260);
						Motor.B.setSpeed(260);
						Motor.A.backward();
						Motor.B.backward();
						Delay.msDelay(2000);
			break; 
	  }
		
   }
   colorSensor.close();
	}//interrupt close
  }//run close
}
	
	

