package UI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.NhanVien_Dao;
import Dao.Taikhoan_dao;
import Entity.Taikhoan;
import button.MyButton;
import connectDB.ConnectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Dangnhap_UI extends JFrame {

	private JPanel contentPane;
	private JTextField Ip_User;
	private ImageIcon icon1= new ImageIcon(getClass().getClassLoader().getResource("image/iconshowpassword.png"));
	private ImageIcon icon2=new ImageIcon(getClass().getClassLoader().getResource("image/iconuser.png"));
	private ImageIcon icon3=new ImageIcon(getClass().getClassLoader().getResource("image/iconpassword.png"));
	private ImageIcon bg=new ImageIcon(getClass().getClassLoader().getResource("image/bg.jpg"));
	private JPasswordField ip_pass;
	private JCheckBox ckb_pass;
	private JLabel icon;
	private Taikhoan_dao tk_Dao=new Taikhoan_dao();
	private NhanVien_Dao nv_dao=new NhanVien_Dao();
private MyButton btn_dangnhap;
private MyButton btn_xoatrang;
private  MyButton btn_thoat;
private ImageIcon image;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangnhap_UI frame = new Dangnhap_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dangnhap_UI() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
		e.printStackTrace();
		}
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,  800,400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		btn_thoat = new MyButton(new Color(255, 51, 0),new Color(255, 102, 0),new Color(255, 0, 0));
		btn_thoat.setForeground(new Color(255, 255, 255));
		btn_thoat.setText("Thoát");
		btn_thoat.setRadius(20);
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_thoat.setBounds(452, 313, 156, 40);
		 contentPane.add(btn_thoat);
		
		 btn_dangnhap = new MyButton(new Color(0, 255, 0),new Color(0, 153, 51),new Color(0, 51, 0));
		 btn_dangnhap.setForeground(Color.WHITE);
		 btn_dangnhap.setText("Đăng nhập");
		 btn_dangnhap.setRadius(20);
		 btn_dangnhap.setBackground(Color.GREEN);
		btn_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_dangnhap.setBounds(238, 250, 370, 40);
		contentPane.add(btn_dangnhap);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(238, 197, 370, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ip_pass = new JPasswordField();
		ip_pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ip_pass.setBounds(0, 0, 290, 43);
		ip_pass.setEchoChar('*');
		panel.add(ip_pass);
		
		 ckb_pass = new JCheckBox("");
		 ckb_pass.setBackground(new Color(255, 255, 255));
		 ckb_pass.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(ckb_pass.isSelected()) {
					ip_pass.setEchoChar((char)0);
				}
				else {
					ip_pass.setEchoChar('*');
				}
		 	}
		 });
		
		ckb_pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ckb_pass.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_pass.setBounds(296, 0, 21, 43);
		panel.add(ckb_pass);
		
		 icon = new JLabel("");
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/invisible.png")));
		icon.setBounds(323, 0, 47, 43);
		panel.add(icon);
		
		Ip_User = new JTextField();
		Ip_User.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Ip_User.setColumns(10);
		Ip_User.setBounds(238, 110, 370, 43);
		contentPane.add(Ip_User);
		
		JLabel lb_Tittle_login = new JLabel("\u0110\u0102NG NH\u1EACP");
		lb_Tittle_login.setForeground(new Color(255, 0, 0));
		lb_Tittle_login.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lb_Tittle_login.setBounds(260, 10, 304, 68);
		contentPane.add(lb_Tittle_login);
		
		JLabel lb_icon_user = new JLabel("");
		lb_icon_user.setIcon(icon2);
		lb_icon_user.setBounds(157, 110, 55, 40);
		contentPane.add(lb_icon_user);
		
		JLabel lb_txtaccount = new JLabel("T\u00E0i Kho\u1EA3n :");
		lb_txtaccount.setForeground(Color.RED);
		lb_txtaccount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lb_txtaccount.setBounds(238, 75, 97, 24);
		contentPane.add(lb_txtaccount);
		
		JLabel lb_txtpassword = new JLabel("M\u1EADt kh\u1EA9u :");
		lb_txtpassword.setForeground(Color.RED);
		lb_txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lb_txtpassword.setBounds(238, 163, 97, 24);
		contentPane.add(lb_txtpassword);
		
		JLabel lb_iconpassword = new JLabel("");
		lb_iconpassword.setIcon(icon3);
		lb_iconpassword.setBounds(157, 198, 55, 40);
		contentPane.add(lb_iconpassword);
		
		btn_xoatrang = new MyButton(new Color(255, 51, 0),new Color(255, 102, 0),new Color(255, 0, 0));
		btn_xoatrang.setForeground(new Color(255, 255, 255));
		btn_xoatrang.setText("Xóa trắng");
		btn_xoatrang.setRadius(20);
		btn_xoatrang.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_xoatrang.setBounds(238, 313, 156, 40);
		btn_xoatrang.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btn_xoatrang);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/bg.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 363);
		contentPane.add(lblNewLabel);
		

		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Taikhoan> tk=tk_Dao.getAllNhanVien();
				for (Taikhoan taikhoan : tk) {
					if(Ip_User.getText().equals(taikhoan.getNametk())&&String.valueOf(ip_pass.getPassword()).equals(taikhoan.getMatkhau())) {
						if(nv_dao.getNhanVien(taikhoan.getManv()).getChucVu().equals("NVQL")) {
							JFrame main_ui=new Main_Ui(taikhoan.getManv());
							main_ui.setVisible(true);	
							setVisible(false);
							return;
						}
						else {
							JFrame main_ui=new Main_UI_NV(taikhoan.getManv());
							main_ui.setVisible(true);	
							setVisible(false);
							return;
						}
						
					}
				}
				JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính xác !");
				
			}});
		
		 ckb_pass.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					int x=e.getStateChange();
					
					if(x==ItemEvent.SELECTED) {
						icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/eye.png")));
					}
					else {
						icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/invisible.png")));
					}
					
					
				}
	        });
		
	}
	
}
