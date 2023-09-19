package UI;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class itemkhachhang extends JPanel {
	private ImageIcon url;
	private int id;
	private String ten;
	private String phone;
	public itemkhachhang(ImageIcon url, int id, String ten ,String phone) {
		super();
		setBackground(new Color(0, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.url = url;
		this.ten = ten;
		this.id=id;
		this.phone=phone;
		setPreferredSize(new Dimension(407, 136));
		setLayout(null);
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lb_Icon = new JLabel("");
		lb_Icon.setIcon(url);
		lb_Icon.setBounds(10, 10, 98, 116);
		add(lb_Icon);
		
		JLabel lb_makhachhang = new JLabel(id+"");
		lb_makhachhang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_makhachhang.setBounds(214, 10, 183, 27);
		add(lb_makhachhang);
		
		JLabel lb_tenkhachhang = new JLabel(ten);
		lb_tenkhachhang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_tenkhachhang.setBounds(214, 47, 183, 27);
		add(lb_tenkhachhang);
		
		JLabel lb_phone = new JLabel(phone);
		lb_phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_phone.setBounds(214, 84, 183, 27);
		add(lb_phone);
		
		JLabel ln_title_name = new JLabel("Name :");
		ln_title_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ln_title_name.setBounds(128, 47, 76, 27);
		add(ln_title_name);
		
		JLabel lb_title_id = new JLabel("ID :");
		lb_title_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_title_id.setBounds(128, 10, 76, 27);
		add(lb_title_id);
		
		JLabel lb_title_phone = new JLabel("Phone :");
		lb_title_phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_title_phone.setBounds(128, 84, 76, 27);
		add(lb_title_phone);
	}

	
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
