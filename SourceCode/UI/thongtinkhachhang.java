package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.HoaDon_DAO;
import Dao.KhachHang_DAO;
import Entity.HoaDon;
import Entity.KhachHang;
import button.MyButton;
import connectDB.ConnectDB;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class thongtinkhachhang extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private JTable table;
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	private HoaDon_DAO don_DAO=new HoaDon_DAO();
	

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					thongtinkhachhang frame = new thongtinkhachhang();
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
	public thongtinkhachhang(int makh) {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
		e.printStackTrace();
		}
		KhachHang kh=kh_dao.getKhachHang(makh);
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 629, 800 );
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds ( ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_hinhdanh = new JLabel("");
		lb_hinhdanh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_hinhdanh.setBounds(10, 10, 134, 152);
		contentPane.add(lb_hinhdanh);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 95, 222));
		panel.setBounds(154, 10, 465, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin kh\u00E1ch h\u00E0ng");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 465, 37);
		panel.add(lblNewLabel);
		
		JLabel lb_tenkhachhang = new JLabel("Tên khách hàng:    "+kh.getTenKH());
		lb_tenkhachhang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb_tenkhachhang.setBounds(154, 62, 465, 48);
		contentPane.add(lb_tenkhachhang);
		
		JLabel lb_gioitinh = new JLabel("Giới tính:    "+kh.getGioiTinh());
		lb_gioitinh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb_gioitinh.setBounds(154, 120, 465, 48);
		contentPane.add(lb_gioitinh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 495, 609, 236);
		contentPane.add(scrollPane);
		
		String [] headers = "MaHD;MaKH;MaPhong;NgayDatPhong;Tongtiendichvu;TongTienphong;MaNV".split(";");
		tableModel=new DefaultTableModel(headers,0);
		table = new JTable(tableModel);
		table.getTableHeader().setBackground(new Color(102, 204, 255));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(33, 95, 222));
		panel_1.setBounds(10, 454, 609, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("H\u00F3a \u0111\u01A1n kh\u00E1ch h\u00E0ng");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 609, 37);
		panel_1.add(lblNewLabel_2);
		
		JLabel lb_makhachhang = new JLabel(makh+"");
		lb_makhachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_makhachhang.setHorizontalAlignment(SwingConstants.CENTER);
		lb_makhachhang.setBounds(10, 172, 134, 31);
		contentPane.add(lb_makhachhang);
		
		JLabel lb_ngaysinh = new JLabel("Ngày sinh:    "+kh.getNgaySinh());
		lb_ngaysinh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb_ngaysinh.setBounds(10, 213, 609, 48);
		contentPane.add(lb_ngaysinh);
		
		JLabel lb_phone = new JLabel("Điện thoại:    "+kh.getPhone());
		lb_phone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb_phone.setBounds(10, 271, 609, 48);
		contentPane.add(lb_phone);
		
		JLabel lb_email = new JLabel("Email:    "+kh.getEmail());
		lb_email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb_email.setBounds(10, 328, 609, 48);
		contentPane.add(lb_email);
		
		JLabel lb_diachi = new JLabel("Địa chỉ:    "+kh.getDiaChi());
		lb_diachi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lb_diachi.setBounds(10, 386, 609, 48);
		contentPane.add(lb_diachi);
		
		MyButton btn_xuatthongtin = new MyButton(new Color(102, 255, 102),new Color(102, 255, 102),new Color(51, 204, 51));
		btn_xuatthongtin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportPDF(table, kh);
			}
		});
		btn_xuatthongtin.setText("Xuất thông tin");
		btn_xuatthongtin.setRadius(15);
		btn_xuatthongtin.setForeground(new Color(255, 255, 255));
		btn_xuatthongtin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_xuatthongtin.setBounds(10, 741, 283, 49);
		contentPane.add(btn_xuatthongtin);
		
		MyButton btn_thoat = new MyButton(new Color(102, 255, 102),new Color(102, 255, 102),new Color(51, 204, 51));
		btn_thoat.setText("Thoát");
		btn_thoat.setRadius(15);
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_thoat.setForeground(new Color(255, 255, 255));
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_thoat.setBounds(303, 741, 316, 49);
		contentPane.add(btn_thoat);
		addtable(makh);
		
	}
	private void exportPDF(JTable jTable,KhachHang kh) {
	    MessageFormat header=new MessageFormat("Mã: "+kh.getMaKH()+" "+"Tên: "+kh.getTenKH());
	    MessageFormat footer=new MessageFormat("END");
	    try {
	    	
			jTable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	private void addtable(int makh) {
		ArrayList<HoaDon> hd=don_DAO.getAllHoaDon();
		for (HoaDon hoaDon : hd) {
			if(hoaDon.getMaKH()==makh) {
				Object[] row= {hoaDon.getMaHD(),hoaDon.getMaKH(),hoaDon.getMaPhong(),hoaDon.getNgayDat(),hoaDon.getTongTienDV(),hoaDon.getTongTienPhong(),hoaDon.getMaNV()};
				tableModel.addRow(row);
			}
		}
	}
}
