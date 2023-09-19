package UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import UI.itemkhachhang;
import button.MyButton;
import UI.WrapLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Dao.KhachHang_DAO;
import Entity.KhachHang;
import Entity.NhanVien;

import java.awt.Color;

public class Timkiemkhachhang extends JPanel {
	private String gioitinh[]= {"nam","nu"};	
	private ImageIcon icon1=new ImageIcon(getClass().getClassLoader().getResource("image/young-man.png"));
	private ImageIcon icon2=new ImageIcon(getClass().getClassLoader().getResource("image/girl.png"));
	private JTextField ip_timkiem;
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	private MyButton btn_timkiem;
	private JComboBox cb_loc;
	private JComboBox cb_timkiem ;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public Timkiemkhachhang() {
		setBackground(new Color(0, 153, 255));
		setBounds(0, 0, 1534,756);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 1514, 673);
		add(scrollPane);
		
		 panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(new WrapLayout());
		scrollPane.setViewportView(panel);
		
		//test
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Kh\u00E1ch h\u00E0ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 301, 52);
		add(lblNewLabel);
		
		JLabel lub_loc = new JLabel("L\u1ECDc :");
		lub_loc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/filter.png")));
		lub_loc.setHorizontalAlignment(SwingConstants.CENTER);
		lub_loc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lub_loc.setBounds(1313, 10, 127, 29);
		add(lub_loc);
		
		 cb_loc = new JComboBox();
		 cb_loc.setBackground(new Color(255, 255, 255));
		cb_loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_loc.setModel(new DefaultComboBoxModel(new String[] {"T\u1EA5t c\u1EA3", "Nam", "N\u1EEF"}));
		cb_loc.setBounds(1311, 40, 213, 29);
		add(cb_loc);
		
		ip_timkiem = new JTextField();
		ip_timkiem.setBounds(346, 40, 220, 29);
		add(ip_timkiem);
		ip_timkiem.setColumns(10);
		
		JLabel lub_loc_1 = new JLabel("T\u00ECm ki\u1EBFm");
		lub_loc_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/searchnv.png")));
		lub_loc_1.setHorizontalAlignment(SwingConstants.CENTER);
		lub_loc_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lub_loc_1.setBounds(217, 10, 127, 29);
		add(lub_loc_1);
		
		 cb_timkiem = new JComboBox();
		 cb_timkiem.setBackground(new Color(255, 255, 255));
		cb_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_timkiem.setModel(new DefaultComboBoxModel(new String[] {"Số điện thoại", "Email", "Tên khách hàng", "Năm sinh"}));
		cb_timkiem.setBounds(346, 10, 219, 29);
		add(cb_timkiem);
		
		 btn_timkiem = new MyButton(new Color(102, 255, 255), new Color(255, 255, 255), new Color(0, 0, 255));
		 btn_timkiem.setText("Tìm kiếm");
		 btn_timkiem.setBackground(new Color(255, 255, 255));
		btn_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_timkiem.setBounds(573, 42, 111, 29);
		add(btn_timkiem);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				addlist();
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1133, 42, 168, 29);
		add(btnNewButton);
		
		addlist();
		
		btn_timkiem.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panel.removeAll();
		 		if(cb_timkiem.getSelectedIndex()==0) {
		 			getkhphone(ip_timkiem.getText().trim());
				 }
		 		else if(cb_timkiem.getSelectedIndex()==1) {
		 			getkhemail(ip_timkiem.getText().trim());
		 		}
		 		else if(cb_timkiem.getSelectedIndex()==2) {
		 			addkhachhangtheoten(ip_timkiem.getText().trim());
		 		}
		 		else if(cb_timkiem.getSelectedIndex()==3) {
		 			addkhachhangtheonamsinh(ip_timkiem.getText().trim());
		 		}
		 		
		 		
				panel.repaint();
				panel.revalidate();
		 	}
		 });
		
		cb_loc.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panel.removeAll();
		 		if(cb_loc.getSelectedItem().equals("Tất cả")) {
		 			addlist();
		 		}
		 		else if(cb_loc.getSelectedIndex()==1) {
		 			addlistgioitinhNam("Nam");
				 }
		 		else if(cb_loc.getSelectedItem().equals("Nữ")) {
		 			addlistgioitinhnu("Nam");	
		 		}
		 		panel.repaint();
		 		panel.revalidate();
		 	}

			
		 });
		
	}
	public	static void shuffleArray(String[] listiconphong2)
	  {
	    // If running on Java 6 or older, use `new Random()` on RHS here
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = listiconphong2.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      String a = listiconphong2[index];
	      listiconphong2[index] = listiconphong2[i];
	      listiconphong2[i] = a;
	    }
	  }
	
	public void addlist() {
		ArrayList<KhachHang> kh=kh_dao.getAllKhachHang();
		for (KhachHang khachhang : kh) {
			if(khachhang.getGioiTinh().equalsIgnoreCase("Nam")) {
				panel.add(new itemkhachhang(icon1, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
			}
			else if(khachhang.getGioiTinh().equalsIgnoreCase("Nữ")) {
				panel.add(new itemkhachhang(icon2, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
			}

		}
	}
	public void getkhphone(String phone) {
		KhachHang khachhang=kh_dao.getKhachHangPhone(phone);
		
		if(khachhang==null) {
			JOptionPane.showMessageDialog(btn_timkiem, "Không tìm thấy !");
			return;
		}
	else if(khachhang.getGioiTinh().equalsIgnoreCase("Nam")) {
			panel.add(new itemkhachhang(icon1, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
		}
		else if(khachhang.getGioiTinh().equalsIgnoreCase("Nữ")) {
			panel.add(new itemkhachhang(icon2, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
		}
	}
	public void getkhemail(String Email) {
		KhachHang khachhang=kh_dao.getKhachHangemail(Email);
		if(khachhang==null) {
			JOptionPane.showMessageDialog(btn_timkiem, "Không tìm thấy !");
			return;
		}
	else if(khachhang.getGioiTinh().equalsIgnoreCase("Nam")) {
			panel.add(new itemkhachhang(icon1, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
		}
		else if(khachhang.getGioiTinh().equalsIgnoreCase("Nữ")) {
			panel.add(new itemkhachhang(icon2, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
		}
	}
	public void getkhmakh(String Makhachhang) {
		KhachHang khachhang=kh_dao.getKhachHangmakh(Makhachhang);
		if(khachhang==null) {
			JOptionPane.showMessageDialog(btn_timkiem, "Không tìm thấy !");
			return;
		}
	else if(khachhang.getGioiTinh().equalsIgnoreCase("Nam")) {
			panel.add(new itemkhachhang(icon1, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
		}
		else if(khachhang.getGioiTinh().equalsIgnoreCase("Nữ")) {
			panel.add(new itemkhachhang(icon2, khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getPhone()));
		}
	}
	private void addlistgioitinhNam(String gioitinh) {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> khachhang=kh_dao.getKhachHanggioitinhnam(gioitinh);
		for (KhachHang khachHang2 : khachhang) {
			if(khachHang2.getGioiTinh().equalsIgnoreCase("Nam")) {
				panel.add(new itemkhachhang(icon1, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
			}
			else if(khachHang2.getGioiTinh().equalsIgnoreCase("Nữ")) {
				panel.add(new itemkhachhang(icon2, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
			}
		}
	}
		private void addlistgioitinhnu(String gioitinh) {
			// TODO Auto-generated method stub
			ArrayList<KhachHang> khachhang=kh_dao.getKhachHanggioitinhnu(gioitinh);
			for (KhachHang khachHang2 : khachhang) {
				if(khachHang2.getGioiTinh().equalsIgnoreCase("Nam")) {
					panel.add(new itemkhachhang(icon1, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
				}
				else if(khachHang2.getGioiTinh().equalsIgnoreCase("Nữ")) {
					panel.add(new itemkhachhang(icon2, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
				}
			}
	}
		private void addkhachhangtheoten(String ten) {
			ArrayList<KhachHang> kh=kh_dao.getAllKhachHangtheoten(ten);
			if(kh.size()<=0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy !");
				return;
			}
			else {for (KhachHang khachHang2 : kh) {
				if(khachHang2.getGioiTinh().equalsIgnoreCase("Nam")) {
					panel.add(new itemkhachhang(icon1, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
				}
				else if(khachHang2.getGioiTinh().equalsIgnoreCase("Nữ")) {
					panel.add(new itemkhachhang(icon2, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
				}
			}
			}
		}
		private void addkhachhangtheonamsinh(String namsinh) {
			ArrayList<KhachHang> kh=kh_dao.getAllKhachHangtheonamsinh(namsinh);
			if(kh.size()<=0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy !");
				return;
			}
			else {for (KhachHang khachHang2 : kh) {
				if(khachHang2.getGioiTinh().equalsIgnoreCase("Nam")) {
					panel.add(new itemkhachhang(icon1, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
				}
				else if(khachHang2.getGioiTinh().equalsIgnoreCase("Nữ")) {
					panel.add(new itemkhachhang(icon2, khachHang2.getMaKH(), khachHang2.getTenKH(), khachHang2.getPhone()));
				}
			}
			}
		}
}
