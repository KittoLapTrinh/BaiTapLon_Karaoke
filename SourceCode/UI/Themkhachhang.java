package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import Dao.KhachHang_DAO;
import Entity.KhachHang;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Themkhachhang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	private int ma;
	private String ten;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Themkhachhang frame = new Themkhachhang(ip_makhachhang, ip_tenkhachhang);
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
	public Themkhachhang(JTextField ip_makhachhang,JTextField ip_tenkhachhang) {
		getContentPane().setBackground(new Color(255, 255, 255));
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 929, 440 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds ( ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 929, 381);
		getContentPane().add(scrollPane);
		
		String [] headers = "Mã khách hàng;Tên khách hàng;Giới tính;Ngày sinh;Phone;Email;Địa chỉ".split(";");
		tableModel=new DefaultTableModel(headers,0);
		table = new JTable(tableModel);
		table.getTableHeader().setBackground(new Color(51, 153, 255));
		scrollPane.setViewportView(table);
		
		JButton btn_themkhachhang = new JButton("Th\u00EAm");
		btn_themkhachhang.setBackground(new Color(0, 255, 128));
		btn_themkhachhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/adddv.png")));
		btn_themkhachhang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_themkhachhang.setBounds(10, 388, 153, 42);
		getContentPane().add(btn_themkhachhang);
		
		JButton btn_thoat = new JButton("Tho\u00E1t");
		btn_thoat.setBackground(new Color(255, 128, 128));
		btn_thoat.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/logout_themkh.png")));
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_thoat.setBounds(173, 388, 153, 42);
		getContentPane().add(btn_thoat);
		
		addtable();
		
		btn_themkhachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themKH();
				ip_makhachhang.setText(ma+"");
				ip_tenkhachhang.setText(ten+"");
			}
		});
		
	}
	
	public void addtable() {
		ArrayList<KhachHang> kh=kh_dao.getAllKhachHang();
		for (KhachHang khachhang : kh) {
			Object [] row= {khachhang.getMaKH(),khachhang.getTenKH(), khachhang.getGioiTinh(), khachhang.getNgaySinh(),khachhang.getPhone(), khachhang.getEmail(),khachhang.getDiaChi()};
			tableModel.addRow(row);
		}
	}
	
	public boolean themKH() {
		if (this.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Ban phải chọn dòng");
			return false;
		}
		else {
			int row = table.getSelectedRow();
			ma =(int)tableModel.getValueAt(row, 0);
			ten = (String)tableModel.getValueAt(row, 1).toString();
			this.setVisible(false);
		}
		return true;
	}
}
