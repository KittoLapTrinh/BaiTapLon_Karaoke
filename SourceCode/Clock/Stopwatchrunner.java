package Clock;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatchrunner {
 int elapsedTime=50;
 int seconds;
 int minutes;
 int hours;
 boolean started = false;
 String seconds_string = String.format("%02d", seconds);
 String minutes_string = String.format("%02d", minutes);
 String hours_string = String.format("%02d", hours);
 private Timer timer;
 private JLabel lb_second;
 private JLabel lb_minute;
 private JLabel lb_hour;
 
 
 
 
 
 







public Stopwatchrunner(int elapsedTime, int seconds, int minutes, int hours,
		JLabel lb_hour, JLabel lb_minute,JLabel lb_second, boolean started) {
	super();
	this.elapsedTime = elapsedTime;
	this.seconds = seconds;
	this.minutes = minutes;
	this.hours = hours;
	this.started = started;
	this.lb_second = lb_second;
	this.lb_minute = lb_minute;
	this.lb_hour = lb_hour;
}






public void run() { timer=new Timer(1000, new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			 elapsedTime=elapsedTime+1000;
			   hours = (elapsedTime/3600000);
			   minutes = (elapsedTime/60000) % 60;
			   seconds = (elapsedTime/1000) % 60;
			   seconds_string = String.format("%02d", seconds);
			   minutes_string = String.format("%02d", minutes);
			   hours_string = String.format("%02d", hours);
			   lb_second.setText(seconds_string);
			   lb_minute.setText(minutes_string);
			   lb_hour.setText(hours_string);
		}
	});
if(started==true) {
	 timer.start();
}
else {
	timer.stop();
}
}
//public void start() {
//	  timer.start();
//	 }
//	 
//public	 void stop() {
//	  timer.stop();
//	 }

//Timer timer = new Timer(1000, new ActionListener() {
//  
//  public void actionPerformed(ActionEvent e) {
//   elapsedTime=elapsedTime+1000;
//   hours = (elapsedTime/3600000);
//   minutes = (elapsedTime/60000) % 60;
//   seconds = (elapsedTime/1000) % 60;
//   seconds_string = String.format("%02d", seconds);
//   minutes_string = String.format("%02d", minutes);
//   hours_string = String.format("%02d", hours);
//  }
//  
// });

// @Override
// public void actionPerformed(ActionEvent e) {
//  
//  if(e.getSource()==startButton) {
//   
//   if(started==false) {
//    started=true;
//    startButton.setText("STOP");
//    start();
//   }
//   else {
//    started=false;
//    startButton.setText("START");
//    stop();
//   }
//   
//  }
//  if(e.getSource()==resetButton) {
//   started=false;
//   startButton.setText("START");
//   reset();
//  }
//  
// }
 

// 
// void reset() {
//  timer.stop();
//  elapsedTime=0;
//  seconds =0;
//  minutes=0;
//  hours=0;
//  seconds_string = String.format("%02d", seconds);
//  minutes_string = String.format("%02d", minutes);
//  hours_string = String.format("%02d", hours);
// }

}
