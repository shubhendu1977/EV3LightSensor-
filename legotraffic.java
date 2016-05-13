
package legopkg;

import lejos.hardware.lcd.LCD;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class legotraffic {
	static Thread t1=new Thread(new MotorDriver());
	static Thread t2=new Thread(new IRSensor());
	public static void main(String[] args) {
	
		System.out.println("THREAD T1 STARTED\n");
		Delay.msDelay(1000);
		System.out.println("THREAD T2 STARTED\n");
		 Delay.msDelay(1000);
		t1.start();
	    t2.start();
		
	}

}
