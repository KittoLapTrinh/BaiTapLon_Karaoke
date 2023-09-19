package UI;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Entity.DichVu;

import java.awt.Color;
import javax.swing.SwingConstants;

public class Itemdichvu extends JPanel {
	private ImageIcon url;
	private int madv;
	private String ten;
	private double dongia;
	private DichVu dichvu;
	private JTextField ip_getmadv;
	private JTextField ip_gettendv;
	private JTextField ip_getdongia;
	
	public Itemdichvu(ImageIcon url, DichVu dichvu,JTextField ip_getmadv, JTextField ip_gettendv, JTextField ip_getdongia, int madv,String ten,double dongia) {
		super();
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.url = url;
		this.dichvu = dichvu;
		this.ip_gettendv = ip_gettendv;
		this.ip_getdongia = ip_getdongia;
		this.ip_getmadv=ip_getmadv;
		this.ten = ten;
		this.madv=madv;
		this.dongia=dongia;
		setPreferredSize(new Dimension(262, 143));
		setLayout(null);
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lb_Icon = new JLabel("");
		lb_Icon.setIcon(url);
		lb_Icon.setBounds(10, 10, 98, 99);
		add(lb_Icon);
		
		JLabel lb_Name = new JLabel(madv+"");
		lb_Name.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb_Name.setBounds(118, 10, 130, 36);
		add(lb_Name);
		
		JLabel lb_Name_1 = new JLabel(ten);
		lb_Name_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_Name_1.setBounds(118, 55, 130, 36);
		add(lb_Name_1);
		
		JLabel lb_Name_2 = new JLabel("\u0110\u01A1n gi\u00E1 :");
		lb_Name_2.setForeground(new Color(255, 0, 0));
		lb_Name_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Name_2.setBounds(10, 109, 114, 28);
		add(lb_Name_2);
		
		JLabel lb_Name_3 = new JLabel(dongia+"");
		lb_Name_3.setForeground(new Color(255, 0, 0));
		lb_Name_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_Name_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Name_3.setBounds(142, 109, 106, 28);
		add(lb_Name_3);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ip_getmadv.setText(dichvu.getMaDV()+"");
			ip_gettendv.setText(dichvu.getTenDV());
			ip_getdongia.setText(dichvu.getDonGia()+"");
			}
		});
		lb_Icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ip_getmadv.setText(dichvu.getMaDV()+"");
				ip_gettendv.setText(dichvu.getTenDV());
				ip_getdongia.setText(dichvu.getDonGia()+"");
			}
		});
		
	}

	public int getMadv() {
		return madv;
	}
	public void setMadv(int madv) {
		this.madv = madv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getDongia() {
		return dongia;
	}
	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	public DichVu getDichvu() {
		return dichvu;
	}
	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}
	

	
}
