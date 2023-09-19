package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.KhachHang_DAO;
import Dao.Phong_DAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class ThongTinPhong extends JFrame {

	private JPanel contentPane;
	private Phong_DAO phong_dao=new Phong_DAO();
	private KhachHang_DAO kh_dao=new KhachHang_DAO();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongTinPhong frame = new ThongTinPhong();
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
	public ThongTinPhong(int maphong) {
		setBackground(new Color(255, 255, 255));
		
		
		int makh=phong_dao.getPhong(maphong+"").getMakh();
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 900, 600 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds ( ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 450, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/singing.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 119, 111);
		panel.add(lblNewLabel);
		
		JLabel lb_maphong = new JLabel("Mã Phòng: "+maphong);
		lb_maphong.setForeground(new Color(255, 0, 0));
		lb_maphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_maphong.setHorizontalAlignment(SwingConstants.CENTER);
		lb_maphong.setBounds(10, 120, 124, 28);
		panel.add(lb_maphong);
		
		JLabel lb_loaiphong = new JLabel("Loại phòng:\t"+phong_dao.getPhong(maphong+"").getLoaiPhong());
		lb_loaiphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_loaiphong.setHorizontalAlignment(SwingConstants.LEFT);
		lb_loaiphong.setBounds(62, 275, 388, 40);
		panel.add(lb_loaiphong);
		
		JLabel lb_giagio = new JLabel("Giá giờ:\t  "+phong_dao.getPhong(maphong+"").getGiagio()+"    VND/h");
		lb_giagio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_giagio.setHorizontalAlignment(SwingConstants.LEFT);
		lb_giagio.setBounds(62, 325, 388, 34);
		panel.add(lb_giagio);
		
		JLabel lb_giobatdau = new JLabel("Giờ bắt đầu:\t"+phong_dao.getPhong(maphong+"").getGiobatdau());
		lb_giobatdau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_giobatdau.setHorizontalAlignment(SwingConstants.LEFT);
		lb_giobatdau.setBounds(62, 369, 388, 45);
		panel.add(lb_giobatdau);
		
		JButton btnNewButton = new JButton("Tho\u00E1t");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(123, 441, 163, 66);
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/logout.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 0, 0));
		
		JLabel lblNewLabel_5_1 = new JLabel("Thông tin phòng");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_5_1.setBounds(139, 33, 311, 42);
		panel.add(lblNewLabel_5_1);
		
		JLabel lb_tenphong = new JLabel("Tên Phòng:   "+phong_dao.getPhong(maphong+"").getTenPhong());
		lb_tenphong.setHorizontalAlignment(SwingConstants.LEFT);
		lb_tenphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_tenphong.setBounds(62, 199, 388, 28);
		panel.add(lb_tenphong);
		
		JLabel lb_trangthai = new JLabel("Trạng thái:   "+phong_dao.getPhong(maphong+"").getTrangThai());
		lb_trangthai.setHorizontalAlignment(SwingConstants.LEFT);
		lb_trangthai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_trangthai.setBounds(62, 237, 388, 28);
		panel.add(lb_trangthai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(450, 0, 450, 600);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/man.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 108, 106);
		panel_1.add(lblNewLabel_1);
		
		int makh1=phong_dao.getPhong(maphong+"").getMakh();
		if(makh1!=0) {
			JLabel lb_tenkh = new JLabel("Tên KH:   "+kh_dao.getKhachHang(makh).getTenKH());
			lb_tenkh.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_tenkh.setHorizontalAlignment(SwingConstants.LEFT);
			lb_tenkh.setBounds(61, 188, 349, 28);
			panel_1.add(lb_tenkh);
			
			JLabel lb_gioitinh = new JLabel("Giới tính:   "+kh_dao.getKhachHang(makh).getGioiTinh());
			lb_gioitinh.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_gioitinh.setHorizontalAlignment(SwingConstants.LEFT);
			lb_gioitinh.setBounds(61, 226, 349, 28);
			panel_1.add(lb_gioitinh);
			
			JLabel lb_ngaysinh = new JLabel("Ngày sinh:   "+kh_dao.getKhachHang(makh).getNgaySinh());
			lb_ngaysinh.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_ngaysinh.setHorizontalAlignment(SwingConstants.LEFT);
			lb_ngaysinh.setBounds(61, 266, 349, 28);
			panel_1.add(lb_ngaysinh);
			
			JLabel lblNewLabel_3_1 = new JLabel("Mã KH:   "+phong_dao.getPhong(maphong+"").getMakh());
			lblNewLabel_3_1.setForeground(new Color(255, 0, 0));
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1.setBounds(10, 126, 119, 28);
			panel_1.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5 = new JLabel("Thông tin khách hàng");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(128, 38, 312, 42);
			panel_1.add(lblNewLabel_5);
			
			JLabel lb_phone = new JLabel("Phone:   "+kh_dao.getKhachHang(makh).getPhone());
			lb_phone.setHorizontalAlignment(SwingConstants.LEFT);
			lb_phone.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_phone.setBounds(61, 303, 349, 34);
			panel_1.add(lb_phone);
			
			JLabel lb_email = new JLabel("Email:   "+kh_dao.getKhachHang(makh).getEmail());
			lb_email.setHorizontalAlignment(SwingConstants.LEFT);
			lb_email.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_email.setBounds(61, 347, 349, 34);
			panel_1.add(lb_email);
			
			JLabel lb_diachi = new JLabel("Địa Chỉ:   "+kh_dao.getKhachHang(makh).getDiaChi());
			lb_diachi.setHorizontalAlignment(SwingConstants.LEFT);
			lb_diachi.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_diachi.setBounds(61, 391, 349, 34);
			panel_1.add(lb_diachi);
		}
		else {
			
			
			
			
			
			
			JLabel lb_tenkh = new JLabel("Tên KH:   ");
			lb_tenkh.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_tenkh.setHorizontalAlignment(SwingConstants.LEFT);
			lb_tenkh.setBounds(61, 188, 349, 28);
			panel_1.add(lb_tenkh);
			
			JLabel lb_gioitinh = new JLabel("Giới tính:   ");
			lb_gioitinh.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_gioitinh.setHorizontalAlignment(SwingConstants.LEFT);
			lb_gioitinh.setBounds(61, 226, 349, 28);
			panel_1.add(lb_gioitinh);
			
			JLabel lb_ngaysinh = new JLabel("Ngày sinh:   ");
			lb_ngaysinh.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_ngaysinh.setHorizontalAlignment(SwingConstants.LEFT);
			lb_ngaysinh.setBounds(61, 266, 349, 28);
			panel_1.add(lb_ngaysinh);
			
			JLabel lblNewLabel_3_1 = new JLabel("Mã KH:   ");
			lblNewLabel_3_1.setForeground(new Color(255, 0, 0));
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1.setBounds(10, 126, 119, 28);
			panel_1.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5 = new JLabel("Thông tin khách hàng");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(128, 38, 312, 42);
			panel_1.add(lblNewLabel_5);
			
			JLabel lb_phone = new JLabel("Phone:   ");
			lb_phone.setHorizontalAlignment(SwingConstants.LEFT);
			lb_phone.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_phone.setBounds(61, 303, 349, 34);
			panel_1.add(lb_phone);
			
			JLabel lb_email = new JLabel("Email:   ");
			lb_email.setHorizontalAlignment(SwingConstants.LEFT);
			lb_email.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_email.setBounds(61, 347, 349, 34);
			panel_1.add(lb_email);
			
			JLabel lb_diachi = new JLabel("Địa Chỉ:   ");
			lb_diachi.setHorizontalAlignment(SwingConstants.LEFT);
			lb_diachi.setFont(new Font("Tahoma", Font.BOLD, 16));
			lb_diachi.setBounds(61, 391, 349, 34);
			panel_1.add(lb_diachi);
		}
		
		
		
		
	}
}
