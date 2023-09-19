package UI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.LineBorder;

import Clock.Countdowtimer;
import Clock.Stopwatchrunner;
import Entity.Phong;
import time.ClockThread;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class itemphong extends JPanel {
	private int elapsedTime=10;
	private ImageIcon url;
	private String name;
	private Color bgtrangthai;
	private int hour;
	private int minute;
	private int second;
	private boolean trangthai;
	private int maphong;
	private Phong phong;
	private JLabel ip_getmaphong;
	private JLabel ip_gettenphong;
	private JComboBox cb_gettrangthai;
	private JComboBox cb_getloaiphong;

	public itemphong(ImageIcon url,Phong phong,JLabel ip_getmaphong, JLabel ip_gettenphong,JComboBox cb_getloaiphong, String name, Color bgtrangthai,int elapsedTime,int hour,int minute,int second,boolean trangthai) {
		super();
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(bgtrangthai);
		this.url = url;
		this.elapsedTime=elapsedTime;
		this.phong=phong;
		this.name = name;
		this.trangthai=trangthai;
		this.minute=minute;
		this.hour=hour;
		this.second=second;
		this.bgtrangthai=bgtrangthai;
		this.ip_getmaphong=ip_getmaphong;
		this.ip_gettenphong=ip_gettenphong;
		this.cb_getloaiphong=cb_gettrangthai;
		
		setPreferredSize(new Dimension(247, 132));
		setLayout(null);
		
		JLabel lb_icon = new JLabel("");
		lb_icon.setIcon(url);
		lb_icon.setBounds(10, 13, 70, 73);
		add(lb_icon);
		
		JLabel lb_name = new JLabel(name);
		lb_name.setForeground(new Color(255, 255, 255));
		lb_name.setFont(new Font("Dialog", Font.BOLD, 16));
		lb_name.setBounds(191, 60, 54, 26);
		add(lb_name);
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 230, 26);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lb_hour = new JLabel();
		lb_hour.setText("00");
		lb_hour.setHorizontalAlignment(SwingConstants.CENTER);
		lb_hour.setForeground(Color.BLUE);
		lb_hour.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lb_hour);
		
		JLabel lb_runtime_2 = new JLabel();
		lb_runtime_2.setText(":");
		lb_runtime_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_runtime_2.setForeground(Color.BLUE);
		lb_runtime_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lb_runtime_2);
		
		JLabel lb_minute = new JLabel();
		lb_minute.setText("00");
		lb_minute.setHorizontalAlignment(SwingConstants.CENTER);
		lb_minute.setForeground(Color.BLUE);
		lb_minute.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lb_minute);
		
		JLabel lb_runtime_2_1 = new JLabel();
		lb_runtime_2_1.setText(":");
		lb_runtime_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_runtime_2_1.setForeground(Color.BLUE);
		lb_runtime_2_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lb_runtime_2_1);
		
		JLabel lb_second = new JLabel();
		lb_second.setText("00");
		lb_second.setHorizontalAlignment(SwingConstants.CENTER);
		lb_second.setForeground(Color.BLUE);
		lb_second.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.add(lb_second);
		
		JLabel lb_maphong = new JLabel(phong.getMaPhong()+"");
		lb_maphong.setForeground(new Color(255, 255, 255));
		lb_maphong.setFont(new Font("Dialog", Font.BOLD, 16));
		lb_maphong.setBounds(191, 10, 35, 26);
		add(lb_maphong);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn ph\u00F2ng");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(86, 60, 95, 26);
		add(lblNewLabel);
		
		JLabel lblMPhng = new JLabel("M\u00E3 ph\u00F2ng ");
		lblMPhng.setForeground(new Color(255, 255, 255));
		lblMPhng.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMPhng.setBounds(90, 13, 95, 26);
		add(lblMPhng);
		
		if(trangthai==true) {
		Stopwatchrunner cd=new Stopwatchrunner(elapsedTime,second, minute,hour, lb_hour,lb_minute,lb_second,trangthai);
		cd.run();
		}
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ip_getmaphong.setText(phong.getMaPhong()+"");
			ip_gettenphong.setText(phong.getTenPhong());
			if(phong.getLoaiPhong().equalsIgnoreCase("Thường")) {
				cb_getloaiphong.setSelectedIndex(0);
			}
			else {
				cb_getloaiphong.setSelectedIndex(1);
			}
			}
		});
		lb_icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ip_getmaphong.setText(phong.getMaPhong()+"");
			ip_gettenphong.setText(phong.getTenPhong());
			if(phong.getLoaiPhong().equalsIgnoreCase("Thường")) {
				cb_getloaiphong.setSelectedIndex(0);
			}
			else {
				cb_getloaiphong.setSelectedIndex(1);
			}
			}
		});
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	
	
//	public void settextview(JTextField lb_maphong2) {
//		lb_maphong2.setText(maphong+"");
//		
//	}
}
