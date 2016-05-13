package legopkg;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
public class IRSensor implements Runnable {

 
	EV3IRSensor sensor = new EV3IRSensor(SensorPort.S4);
    byte[] commands = new byte[EV3IRSensor.IR_CHANNELS];
    float[] distances = new float[sensor.sampleSize()];
    public IRSensor()
    { }
    public void run()
    {
    
		    while(true)
		    {
				       sensor.getRemoteCommands(commands, 0, commands.length);
				       System.out.println("IR commands: " + commands[0]);
				        Delay.msDelay(5000);
				       if(commands[0]==1)
				       {
				  
				    	    Motor.A.setSpeed(400);
							Motor.B.setSpeed(400);
							Motor.A.backward();
							Motor.B.backward();
							Delay.msDelay(5000);
				       }
				       
				   	if (commands[0]==2)
						{	
				     	Motor.A.stop();
				 		Motor.B.stop();
				 		legotraffic.t1.interrupt();	    
				 		break;
							
						}
				       
		       
		    }
	
    }//end of run
	
	
	
}
