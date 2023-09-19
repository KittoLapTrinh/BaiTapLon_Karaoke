package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class ClockThread extends Thread {
	private JLabel lb_runtime;
	private String input;
	


	public ClockThread(JLabel lb_runtime,String input) {
		super();
		this.lb_runtime = lb_runtime;
		this.input=input;
	}



	@Override
	public void run() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

		while(true) {
				  Date dt =new Date();		
//					dt = formatter.parse(input);
					String st=formatter.format(dt);
					lb_runtime.setText(st);	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
