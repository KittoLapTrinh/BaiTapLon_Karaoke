package UI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Detail_nhanvien_ca extends JPanel {
	private String url;
	private String tennhanvien;
	private String manhanvien;
	private String chucvu;
	private String phone;
	public Detail_nhanvien_ca(String url, String tennhanvien, String manhanvien, String chucvu, String phone) {
		super();
		setBackground(new Color(0, 255, 255));
		this.url = url;
		this.tennhanvien = tennhanvien;
		this.manhanvien = manhanvien;
		this.chucvu = chucvu;
		this.phone = phone;
		
		setPreferredSize(new Dimension(394, 198));
		setLayout(null);
		
		JLabel lb_icon = new JLabel("");
		lb_icon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lb_icon.setIcon(new ImageIcon(url));
		lb_icon.setBounds(0, 10, 127, 178);
		add(lb_icon);
		
		JLabel lb_manv = new JLabel(manhanvien);
		lb_manv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_manv.setBounds(209, 10, 175, 33);
		add(lb_manv);
		
		JLabel lb_tennv = new JLabel(tennhanvien);
		lb_tennv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_tennv.setBounds(209, 53, 175, 40);
		add(lb_tennv);
		
		JLabel lb_chucvu = new JLabel(chucvu);
		lb_chucvu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_chucvu.setBounds(231, 103, 153, 33);
		add(lb_chucvu);
		
		JLabel lb_phone = new JLabel(phone);
		lb_phone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_phone.setBounds(209, 146, 175, 42);
		add(lb_phone);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 NV: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(137, 10, 62, 33);
		add(lblNewLabel);
		
		JLabel lblMNv = new JLabel("T\u00EAn :");
		lblMNv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNv.setBounds(137, 60, 62, 33);
		add(lblMNv);
		
		JLabel lblChcV = new JLabel("Ch\u1EE9c v\u1EE5 :");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChcV.setBounds(137, 103, 84, 33);
		add(lblChcV);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(137, 146, 62, 33);
		add(lblPhone);
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTennhanvien() {
		return tennhanvien;
	}
	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
	}
	public String getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
