package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Detail_nhanvien_about extends JFrame {

	private  JPanel contentPane;
	private static JButton btn_exit;
	private static int MaNV;
	private static String TenNV;
	private static String GioiTinh;
	private static String CCCD;
	private static String Phone;
	private static String ChucVu;
	private static String DiaChi;
	private static Date NgaySinh;
	private static double Luong;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Detail_nhanvien_about frame = new Detail_nhanvien_about( MaNV,TenNV, GioiTinh, CCCD,Phone,ChucVu,DiaChi,NgaySinh,Luong);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Detail_nhanvien_about(int MaNV, String TenNV,
	 String GioiTinh,
	 String CCCD,
	 String Phone,
	 String ChucVu,
	 String DiaChi,
	 Date NgaySinh,
	 double Luong) {
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 629, 440 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds ( ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/businessman.png")));
		lblNewLabel.setBounds(10, 10, 183, 131);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(203, 10, 77, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_tennv = new JLabel(TenNV);
		lb_tennv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_tennv.setBounds(290, 10, 315, 30);
		contentPane.add(lb_tennv);
		
		JLabel lblNewLabel_3 = new JLabel(MaNV+"");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 151, 183, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gi\u1EDBi t\u00EDnh :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(203, 50, 77, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lb_gioitinh = new JLabel(GioiTinh);
		lb_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_gioitinh.setBounds(290, 50, 315, 30);
		contentPane.add(lb_gioitinh);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CCCD :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(203, 90, 77, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lb_cccd = new JLabel(CCCD);
		lb_cccd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_cccd.setBounds(290, 90, 315, 30);
		contentPane.add(lb_cccd);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Phone :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_2.setBounds(203, 130, 77, 30);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lb_phone = new JLabel(Phone);
		lb_phone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_phone.setBounds(290, 130, 315, 30);
		contentPane.add(lb_phone);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Ch\u1EE9c v\u1EE5 :");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_3.setBounds(203, 170, 77, 30);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lb_chucvu = new JLabel(ChucVu);
		lb_chucvu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_chucvu.setBounds(290, 170, 315, 30);
		contentPane.add(lb_chucvu);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("\u0110\u1ECBa ch\u1EC9 :");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_4.setBounds(203, 210, 77, 30);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lb_diachi = new JLabel(DiaChi);
		lb_diachi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_diachi.setBounds(290, 210, 315, 30);
		contentPane.add(lb_diachi);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Ng\u00E0y sinh :");
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_5.setBounds(203, 250, 77, 30);
		contentPane.add(lblNewLabel_1_1_5);
		
		JLabel lb_ngaysinh = new JLabel(NgaySinh+"");
		lb_ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_ngaysinh.setBounds(290, 250, 315, 30);
		contentPane.add(lb_ngaysinh);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("L\u01B0\u01A1ng :");
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_6.setBounds(203, 290, 77, 30);
		contentPane.add(lblNewLabel_1_1_6);
		
		JLabel lb_luong = new JLabel(Luong+"");
		lb_luong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_luong.setBounds(290, 290, 315, 30);
		contentPane.add(lb_luong);
		
		 btn_exit = new JButton("Exit");
		 btn_exit.setBackground(SystemColor.textHighlight);
		 btn_exit.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		setVisible(false);
		 	}
		 });
		 btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exit.setBounds(262, 372, 107, 30);
		contentPane.add(btn_exit);
	}
}
