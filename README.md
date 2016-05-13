# EV3LightSensor-
This is leJOS code for small EV3 project. The purpose of the project is to make two threaded leJOS program. One thread will look for colour and other for IR Sensor Input. 

The detail of the project is as given below 

Color Sensor 

We assembled the robot using the accessories given in the Lego Mindstorm EV3. The colour sensor is used to measure the colour sensed and accordingly give feedback to the motors in real-time to maintain the speed of the robot. The robot starts and maintains a steady speed, The robot slows down when seeing yellow surface in front , gains speed when seeing green surface and stops on encountering red surface . The robot moves in straight line with varying speed depending on the type of the colour observed by it. We run the robot in Reflected light modes. We made the path of traffic robot using paper strips of yellow, green, and red colours. The robot senses the light using the reflected light and varies its speed.

IR Sensor 

The robot takes commands from IR beacon. Two different commands are programmed from beacon First to slow down robot and second to stop it. 


ROBOT AS A REALTIME SYSTEM

Our robot is a real time system. Traffic Robot has two independent tasks to perform and both are assigned to two separate threads of leJOS code.

(a)	Thread 1 : Colour Sensing and driving motor : This is considered as low priority routine task. On the basis of feedback received from the colour sensor the motor speed is controlled. This task runs as Thread 1 in the robot.  
Based on the feedback provided by colour sensor following actions are taken by the robot motor control:

(i)	Sense Yellow 	low speed
(ii)	Sense Green 	High speed
(iii)	Sense Red		Stop



(b)	Thread 2 : IR Command based Motor Control control
The thread 2 is programmed to control motion of robot based on IR Commands received by IR Sensor. Two separate commands are meant for changing robot speed and stopping it. The stopping of robot has been assigned with highest priority,  it terminates the Thread 1 using inter process communication interrupts. 


Implementation 

The project is implemented in leJOS programming language meant for coding on Lego windstorm intelligent brick.  The program runs in two threads. 

Thread 1. is taking feedback from the colour sensor and drives motor based on the colour sensed by the sensor. The colorSensor.getColorID() API  returns the id of the colour sensed by the sensor. Depending on the Colour ID a switch case statement decides the drive power of the motor. 

Thread 2. For capturing input from IR sensor  sensor.getRemoteCommands()  api has been used. It returns the channel and the command button pressed on the IR remote. Depending on the IR Remote command switch case is programmed to change speed of robot  or to stop robot by sending an interrupt to the Thread 1. 


Contributors 

Shubhendu Prakash       E-mail:  shubh_3@yahoo.com
B. Srinivas Goud                 sonu_subbu@yahoo.co.in


