package UI;

import javax.swing.JPanel;

import Dao.KhachHang_DAO;
import Dao.NhanVien_Dao;
import Dao.Phong_DAO;
import button.MyButton;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class panel_Main extends JPanel {
	private NhanVien_Dao nv_dao=new NhanVien_Dao();
	private Phong_DAO phong_Dao=new Phong_DAO();
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	private int manv;
	private MyButton btn_logout;


	/**
	 * Create the panel.
	 */
	public panel_Main(String actor,int manv) {
		setBounds(0, 0, 1534, 756);
		setLayout(null);
		
		JPanel panel_Main = new JPanel();
		panel_Main.setLayout(null);
		panel_Main.setBackground(new Color(0, 255, 128));
		panel_Main.setBounds(0, 0, 1520, 756);
		add(panel_Main);
		
		btn_logout = new MyButton(new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 102, 102));
		 btn_logout.setText("Logout");
		 btn_logout.setRadius(20);
		 
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
		 		JFrame dangnnhap=new Dangnhap_UI();
		 		dangnnhap.setVisible(true);
			}
		});
		
		JLabel lb_Actor = new JLabel("Xin Chào, "+actor);
		lb_Actor.setForeground(Color.WHITE);
		lb_Actor.setFont(new Font("Tahoma", Font.BOLD, 30));
		lb_Actor.setBounds(0, 0, 691, 61);
		panel_Main.add(lb_Actor);
		btn_logout.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/logout.png")));
		btn_logout.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_logout.setBounds(1267, 0, 253, 61);
		panel_Main.add(btn_logout);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 71, 1500, 675);
		panel_Main.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 10, 722, 655);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(0, 0, 722, 54);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Phòng");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBackground(new Color(128, 255, 255));
		lblNewLabel_1.setBounds(0, 0, 722, 54);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 128, 128));
		panel_3.setBounds(0, 64, 722, 146);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Số phòng đang sử dụng");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(0, 0, 327, 39);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(337, 10, 4, 126);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/singing_page.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 49, 327, 87);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(phong_Dao.getAllPhongtrangthai("Đang sử dụng").size()+"");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_5.setBounds(351, 19, 361, 117);
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(0, 255, 128));
		panel_3_1.setBounds(0, 220, 722, 146);
		panel_1.add(panel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số phòng còn trống");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
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
		
		JLabel lblNewLabel_5_1 = new JLabel(phong_Dao.getAllPhongtrangthai("Còn trống").size()+"");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_5_1.setBounds(351, 19, 361, 117);
		panel_3_1.add(lblNewLabel_5_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(255, 255, 128));
		panel_3_2.setBounds(0, 376, 722, 146);
		panel_1.add(panel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Số phòng đang bảo trì");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
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
		
		JLabel lblNewLabel_5_2 = new JLabel(phong_Dao.getAllPhongtrangthai("Bảo trì").size()+"");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_5_2.setBounds(351, 10, 361, 117);
		panel_3_2.add(lblNewLabel_5_2);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBackground(new Color(0, 128, 255));
		panel_3_2_1.setBounds(0, 532, 722, 113);
		panel_1.add(panel_3_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng số phòng");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_4.setBounds(10, 10, 309, 93);
		panel_3_2_1.add(lblNewLabel_4);
		
		JPanel panel_4_2_1 = new JPanel();
		panel_4_2_1.setBackground(Color.BLACK);
		panel_4_2_1.setBounds(340, 10, 4, 93);
		panel_3_2_1.add(panel_4_2_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel(phong_Dao.getAllPhong().size()+"");
		lblNewLabel_5_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_5_2_1.setBounds(351, 10, 361, 93);
		panel_3_2_1.add(lblNewLabel_5_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(768, 10, 722, 325);
		panel.add(panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 128, 255));
		panel_2_1.setBounds(0, 0, 722, 54);
		panel_1_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Khách hàng");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(0, 0, 722, 54);
		panel_2_1.add(lblNewLabel_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 64, 333, 251);
		panel_1_1.add(panel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Khách hàng đang hát");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6.setBounds(10, 0, 313, 71);
		panel_5.add(lblNewLabel_6);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(Color.BLACK);
		panel_6_1.setBounds(10, 70, 313, 5);
		panel_5.add(panel_6_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(255, 128, 64));
		panel_7.setBounds(10, 81, 313, 160);
		panel_5.add(panel_7);
		
		JLabel lblNewLabel_7 = new JLabel(phong_Dao.getAllPhongtrangthai("Đang sử dụng").size()+"");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_7.setBounds(0, 0, 313, 160);
		panel_7.add(lblNewLabel_7);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(384, 64, 328, 251);
		panel_1_1.add(panel_5_1);
		
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
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(new Color(255, 128, 64));
		panel_7_1.setBounds(10, 81, 313, 160);
		panel_5_1.add(panel_7_1);
		
		JLabel lblNewLabel_7_1 = new JLabel(kh_dao.getAllKhachHang().size()+"");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 70));
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
		panel_5_2.setLayout(null);
		panel_5_2.setBackground(Color.WHITE);
		panel_5_2.setBounds(10, 64, 333, 251);
		panel_1_1_1.add(panel_5_2);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Quản lý");
		lblNewLabel_6_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6_1_2.setBounds(10, 0, 313, 71);
		panel_5_2.add(lblNewLabel_6_1_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(10, 70, 313, 5);
		panel_5_2.add(panel_6);
		
		JPanel panel_7_3 = new JPanel();
		panel_7_3.setLayout(null);
		panel_7_3.setBackground(Color.YELLOW);
		panel_7_3.setBounds(10, 81, 313, 160);
		panel_5_2.add(panel_7_3);
		
		JLabel lblNewLabel_7_2 = new JLabel(nv_dao.getNhanVienchucvu("NVQL").size()+"");
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_7_2.setBounds(0, 0, 313, 160);
		panel_7_3.add(lblNewLabel_7_2);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBackground(Color.WHITE);
		panel_5_1_1.setBounds(388, 64, 324, 251);
		panel_1_1_1.add(panel_5_1_1);
		
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
		panel_7_2.setLayout(null);
		panel_7_2.setBackground(Color.YELLOW);
		panel_7_2.setBounds(5, 81, 313, 160);
		panel_5_1_1.add(panel_7_2);
		
		JLabel lblNewLabel_7_3 =new JLabel(nv_dao.getNhanVienchucvu("NVTN").size()+"");
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_3.setForeground(Color.WHITE);
		lblNewLabel_7_3.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel_7_3.setBounds(0, 0, 313, 160);
		panel_7_2.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/bg_Trangchu.jpg")));
		lblNewLabel.setBounds(0, 0, 1534, 756);
		panel_Main.add(lblNewLabel);
	}
}
