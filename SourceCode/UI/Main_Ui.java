package UI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.KhachHang_DAO;
import Dao.NhanVien_Dao;
import Dao.Phong_DAO;
import Entity.NhanVien;
import Entity.Phong;
import button.MyButton;
import connectDB.ConnectDB;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JCheckBoxMenuItem;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Ui extends JFrame {

	private Graphics g2;
	private JPanel contentPane;
	private ImageIcon iconlogout=new ImageIcon(getClass().getClassLoader().getResource("image/bg_Trangchu.jpg"));
	private ImageIcon bg_main=new ImageIcon(getClass().getClassLoader().getResource("image/logout.png"));
	private MyButton btn_logout;
	private JLabel lb_Actor;
	private JPanel panel_Main;
	private static int manv;
	private NhanVien_Dao nv_dao=new NhanVien_Dao();
	private Phong_DAO phong_Dao=new Phong_DAO();
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main_Ui frame = new Main_Ui(manv);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//					
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Main_Ui(int manv) {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
		e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1554,819);
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(100, 177, 255));
		setJMenuBar(menuBar);
		
		JLabel btn_trangchu = new JLabel("Trang chủ  ");
		btn_trangchu.setBackground(new Color(63, 63, 63));
		btn_trangchu.setForeground(new Color(255, 255, 255));
		btn_trangchu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_trangchu.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/house.png")));
		menuBar.add(btn_trangchu);
		
		JMenu btn_khachhang = new JMenu("Khách Hàng");
		btn_khachhang.setBackground(new Color(255, 255, 255));
		btn_khachhang.setForeground(new Color(255, 255, 255));
		btn_khachhang.setHorizontalAlignment(SwingConstants.CENTER);
		btn_khachhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/people.png")));
		btn_khachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuBar.add(btn_khachhang);
		
		JMenuItem btn_quanlykhachhang = new JMenuItem("Quản lý khách hàng");
		btn_quanlykhachhang.setBackground(new Color(255, 255, 255));
		btn_quanlykhachhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/crm.png")));
		btn_quanlykhachhang.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn_khachhang.add(btn_quanlykhachhang);
		
		JMenuItem btn_timkiemkhachhang = new JMenuItem("Tìm kiếm khách hàng");
		btn_timkiemkhachhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/searchkh.png")));
		btn_timkiemkhachhang.setBackground(new Color(255, 255, 255));
		btn_timkiemkhachhang.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn_khachhang.add(btn_timkiemkhachhang);
		
		JMenu btn_phong = new JMenu("Phòng");
		btn_phong.setForeground(new Color(255, 255, 255));
		btn_phong.setHorizontalAlignment(SwingConstants.CENTER);
		btn_phong.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/room.png")));
		btn_phong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuBar.add(btn_phong);
		
		JMenuItem btn_quanlyphong = new JMenuItem("Quản lý phòng");
		btn_quanlyphong.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/slsing.png")));
		btn_quanlyphong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn_phong.add(btn_quanlyphong);
		
		JMenuItem btn_timkiemphong = new JMenuItem("Tìm kiếm phòng");
		btn_timkiemphong.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/search_phong.png")));
		btn_timkiemphong.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn_phong.add(btn_timkiemphong);
		
		JMenu btn_nhanvien = new JMenu("Nhân viên");
		btn_nhanvien.setForeground(new Color(255, 255, 255));
		btn_nhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		btn_nhanvien.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/admin.png")));
		btn_nhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuBar.add(btn_nhanvien);
		
		JMenuItem btn_quanlynhanvien = new JMenuItem("Quản lý nhân viên");
		btn_quanlynhanvien.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/profile.png")));
		btn_quanlynhanvien.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn_nhanvien.add(btn_quanlynhanvien);
		
		JMenuItem btn_timkiemnhanvien = new JMenuItem("Tìm kiếm nhân viên");
		btn_timkiemnhanvien.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/search_phong.png")));
		btn_timkiemnhanvien.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btn_nhanvien.add(btn_timkiemnhanvien);
		
		JMenu mnNewMenu = new JMenu("Thống kê");
		mnNewMenu.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/analysis.png")));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem btn_quanlythongke = new JMenuItem("Quản lý thống kê");
		btn_quanlythongke.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/statistics.png")));
		btn_quanlythongke.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		mnNewMenu.add(btn_quanlythongke);
		
		JMenu btn_help = new JMenu("Help");
		btn_help.setForeground(new Color(255, 255, 255));
		btn_help.setHorizontalAlignment(SwingConstants.CENTER);
		btn_help.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/question.png")));
		btn_help.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuBar.add(btn_help);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_Main = new JPanel();
		panel_Main.setBackground(new Color(0, 255, 128));
		panel_Main.setBounds(10, 0, 1520, 756);
		contentPane.add(panel_Main);
		panel_Main.setLayout(null);
		
		 btn_logout = new MyButton(new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 102, 102));
		 btn_logout.setText("Logout");
		 btn_logout.setRadius(20);
		btn_logout.setIcon(bg_main);
		btn_logout.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_logout.setBounds(1267, 0, 253, 61);
		panel_Main.add(btn_logout);
		
		NhanVien nv=nv_dao.getNhanVien(manv);
		
		 lb_Actor = new JLabel("Xin Chào, "+nv_dao.getNhanVien(manv).getTenNV());
		lb_Actor.setForeground(new Color(255, 255, 255));
		lb_Actor.setFont(new Font("Tahoma", Font.BOLD, 30));
		lb_Actor.setBounds(0, 0, 600, 61);
		panel_Main.add(lb_Actor);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 71, 1500, 675);
		panel_Main.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 722, 655);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(0, 0, 722, 54);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Phòng");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(128, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 722, 54);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 128));
		panel_3.setBounds(0, 64, 722, 146);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Số phòng đang sử dụng");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 327, 39);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(337, 10, 4, 126);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/singing_page.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 49, 327, 87);
		panel_3.add(lblNewLabel_3);
		
		
		JLabel lb_sophong1 = new JLabel(phong_Dao.getAllPhongtrangthai("Đang sử dụng").size()+"");
		lb_sophong1.setForeground(new Color(255, 255, 255));
		lb_sophong1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_sophong1.setFont(new Font("Tahoma", Font.BOLD, 70));
		lb_sophong1.setBounds(351, 19, 361, 117);
		panel_3.add(lb_sophong1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(0, 255, 128));
		panel_3_1.setBounds(0, 220, 722, 146);
		panel_1.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số phòng còn trống");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(0, 10, 327, 47);
		panel_3_1.add(lblNewLabel_2_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.BLACK);
		panel_4_1.setBounds(337, 10, 4, 126);
		panel_3_1.add(panel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/microphone.png")));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(0, 49, 327, 87);
		panel_3_1.add(lblNewLabel_3_1);
		
		JLabel lb_sophong2 = new JLabel(phong_Dao.getAllPhongtrangthai("Còn trống").size()+"");
		lb_sophong2.setForeground(new Color(255, 255, 255));
		lb_sophong2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_sophong2.setFont(new Font("Tahoma", Font.BOLD, 70));
		lb_sophong2.setBounds(351, 19, 361, 117);
		panel_3_1.add(lb_sophong2);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(255, 255, 128));
		panel_3_2.setBounds(0, 376, 722, 146);
		panel_1.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Số phòng đang bảo trì");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(0, 0, 327, 47);
		panel_3_2.add(lblNewLabel_2_2);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(Color.BLACK);
		panel_4_2.setBounds(337, 10, 4, 126);
		panel_3_2.add(panel_4_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/car.png")));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(0, 49, 327, 87);
		panel_3_2.add(lblNewLabel_3_2);
		
		JLabel lb_sophong3 = new JLabel(phong_Dao.getAllPhongtrangthai("Bảo trì").size()+"");
		lb_sophong3.setForeground(new Color(255, 255, 255));
		lb_sophong3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_sophong3.setFont(new Font("Tahoma", Font.BOLD, 70));
		lb_sophong3.setBounds(351, 10, 361, 117);
		panel_3_2.add(lb_sophong3);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setBackground(new Color(0, 128, 255));
		panel_3_2_1.setBounds(0, 532, 722, 113);
		panel_1.add(panel_3_2_1);
		panel_3_2_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng số phòng");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 10, 309, 93);
		panel_3_2_1.add(lblNewLabel_4);
		
		JPanel panel_4_2_1 = new JPanel();
		panel_4_2_1.setBackground(Color.BLACK);
		panel_4_2_1.setBounds(340, 10, 4, 93);
		panel_3_2_1.add(panel_4_2_1);
		
		JLabel lb_tongsophong = new JLabel(phong_Dao.getAllPhong().size()+"");
		lb_tongsophong.setForeground(new Color(255, 255, 255));
		lb_tongsophong.setHorizontalAlignment(SwingConstants.CENTER);
		lb_tongsophong.setFont(new Font("Tahoma", Font.BOLD, 70));
		lb_tongsophong.setBounds(351, 10, 361, 93);
		panel_3_2_1.add(lb_tongsophong);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(768, 10, 722, 325);
		panel.add(panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 128, 255));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(0, 0, 722, 54);
		panel_1_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Khách hàng");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(0, 0, 722, 54);
		panel_2_1.add(lblNewLabel_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(10, 64, 333, 251);
		panel_1_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Khách hàng đang hát");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 0, 313, 71);
		panel_5.add(lblNewLabel_6);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(Color.BLACK);
		panel_6_1.setBounds(10, 70, 313, 5);
		panel_5.add(panel_6_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 128, 64));
		panel_7.setBounds(10, 81, 313, 160);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel(phong_Dao.getAllPhongtrangthai("Đang sử dụng").size()+"");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 313, 160);
		panel_7.add(lblNewLabel_7);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(255, 255, 255));
		panel_5_1.setBounds(384, 64, 328, 251);
		panel_1_1.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("Tổng khách hàng");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6_1.setBounds(10, 0, 308, 71);
		panel_5_1.add(lblNewLabel_6_1);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(Color.BLACK);
		panel_6_2.setBounds(10, 70, 313, 5);
		panel_5_1.add(panel_6_2);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBackground(new Color(255, 128, 64));
		panel_7_1.setBounds(10, 81, 313, 160);
		panel_5_1.add(panel_7_1);
		panel_7_1.setLayout(null);
		
		JLabel lblNewLabel_7_1 = new JLabel(kh_dao.getAllKhachHang().size()+"");
		lblNewLabel_7_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setBounds(0, 0, 313, 160);
		panel_7_1.add(lblNewLabel_7_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(768, 345, 722, 325);
		panel.add(panel_1_1_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(0, 128, 255));
		panel_2_1_1.setBounds(0, 0, 722, 54);
		panel_1_1_1.add(panel_2_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nhân viên");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(0, 0, 722, 54);
		panel_2_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(Color.WHITE);
		panel_5_2.setBounds(10, 64, 333, 251);
		panel_1_1_1.add(panel_5_2);
		panel_5_2.setLayout(null);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Quản lý");
		lblNewLabel_6_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6_1_2.setBounds(10, 0, 313, 71);
		panel_5_2.add(lblNewLabel_6_1_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 0, 0));
		panel_6.setBounds(10, 70, 313, 5);
		panel_5_2.add(panel_6);
		
		JPanel panel_7_3 = new JPanel();
		panel_7_3.setBackground(new Color(255, 255, 0));
		panel_7_3.setBounds(10, 81, 313, 160);
		panel_5_2.add(panel_7_3);
		panel_7_3.setLayout(null);
		
		JLabel lblNewLabel_7_2 = new JLabel(nv_dao.getNhanVienchucvu("NVQL").size()+"");
		lblNewLabel_7_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_2.setBounds(0, 0, 313, 160);
		panel_7_3.add(lblNewLabel_7_2);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBackground(Color.WHITE);
		panel_5_1_1.setBounds(388, 64, 324, 251);
		panel_1_1_1.add(panel_5_1_1);
		panel_5_1_1.setLayout(null);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Thu ngân");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6_1_1.setBounds(10, 0, 308, 71);
		panel_5_1_1.add(lblNewLabel_6_1_1);
		
		JPanel panel_6_3 = new JPanel();
		panel_6_3.setBackground(Color.BLACK);
		panel_6_3.setBounds(10, 70, 305, 5);
		panel_5_1_1.add(panel_6_3);
		
		JPanel panel_7_2 = new JPanel();
		panel_7_2.setBackground(new Color(255, 255, 0));
		panel_7_2.setBounds(5, 81, 313, 160);
		panel_5_1_1.add(panel_7_2);
		panel_7_2.setLayout(null);
		
		JLabel lblNewLabel_7_3 = new JLabel(nv_dao.getNhanVienchucvu("NVTN").size()+"");
		lblNewLabel_7_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_7_3.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_3.setBounds(0, 0, 313, 160);
		panel_7_2.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(iconlogout);
		lblNewLabel.setBounds(0, 0, 1534, 756);
		panel_Main.add(lblNewLabel);
		
		open_ui(btn_quanlykhachhang, new Quanlykhachhang());
		open_ui(btn_timkiemkhachhang, new Timkiemkhachhang());
		open_ui(btn_quanlyphong, new Quanlyphonghat_2(manv,nv_dao.getNhanVien(manv).getTenNV()));
		open_ui(btn_quanlynhanvien, new quanlynhanvien());
		open_ui(btn_timkiemnhanvien, new Timkiemnhanvien());
		open_ui(btn_timkiemphong, new Timkiemphong());
		open_ui(btn_quanlythongke, new Thongke_ui());
		btn_trangchu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Main.removeAll();
				panel_Main.add(new panel_Main(nv_dao.getNhanVien(manv).getTenNV(),manv));
				panel_Main.repaint();
				panel_Main.revalidate();
			}
		});
		
		btn_logout.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		setVisible(false);
		 		JFrame dangnnhap=new Dangnhap_UI();
		 		dangnnhap.setVisible(true);
		 	}
		 });
		
	}
	public void open_ui(JMenuItem menuitem,JPanel addpn) {		
		menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Main.removeAll();
				panel_Main.add(addpn);
				panel_Main.repaint();
				panel_Main.revalidate();
			}
		});
	}
}
