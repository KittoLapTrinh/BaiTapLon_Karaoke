package Clock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Countdowtimer {
private int hour;
private int minute;
private int second;
private JLabel lb_minute;
private JLabel lb_hour;
private JLabel lb_second;
private Color color=Color.pink;
private Timer timer;
private JPanel pn;

public Countdowtimer(int hour, int minute,int second, JLabel lb_hour, JLabel lb_minute,JLabel lb_second,JPanel pn) {
	super();
	this.hour = hour;
	this.minute = minute;
	this.lb_minute = lb_minute;
	this.lb_hour = lb_hour;
	this.lb_second=lb_second;
	this.second=second;
	this.pn=pn;
}

public void run() { timer=new Timer(1000, new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(minute==0) {
				if(hour==0) {
					hour=0;
					minute=0;
				}
				if(hour>0&&hour<24) {
				hour--;
				minute=60;
				}
			}
			if(hour==0&&minute==0&&second==0) {
				minute=0;
				hour=0;
				second=0;
				pn.setBackground(color);
				timer.stop();
			}
			if(second==0) {
				if(minute==0) {
					minute=0;
					second=0;
				}
				if(minute>0) {
					minute--;
				second=60;
				}
			}
			else {
			second--;		
			lb_hour.setText(hour+"");
			lb_minute.setText(minute+"");
			lb_second.setText(second+"");
			}
		}
	});
	timer.start();
}

}
