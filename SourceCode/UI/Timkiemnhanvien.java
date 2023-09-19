package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.NhanVien_Dao;
import Entity.NhanVien;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Timkiemnhanvien extends JPanel {
	private JTextField ip_timkiem;
	private JPanel panel_1;
	private JButton btn_timkiem;
	private JComboBox cb_loc;
private NhanVien_Dao nv_dao=new NhanVien_Dao();
//private String[] url= {getClass().getClassLoader().getResource("image/manager.png",getClass().getClassLoader().getResource("image/manager_women.png",getClass().getClassLoader().getResource("image/businessman.png",getClass().getClassLoader().getResource("image/wm.png"};
private ImageIcon icon1=new ImageIcon(getClass().getClassLoader().getResource("image/manager.png"));
private ImageIcon icon2=new ImageIcon(getClass().getClassLoader().getResource("image/manager_women.png"));
private ImageIcon icon3=new ImageIcon(getClass().getClassLoader().getResource("image/businessman.png"));
private ImageIcon icon4=new ImageIcon(getClass().getClassLoader().getResource("image/wm.png"));
	/**
	 * Create the panel.
	 */
	public Timkiemnhanvien() {
		setBounds(0, 0, 1534,756);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1534, 94);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00ECm ki\u1EBFm theo :");
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/searchnv.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 180, 29);
		panel.add(lblNewLabel);
		
		JComboBox cb_timkiem = new JComboBox();
		cb_timkiem.setBackground(new Color(255, 255, 255));
		cb_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cb_timkiem.setModel(new DefaultComboBoxModel(new String[] {"Tên", "CCCD", "Số điện thoại", "Năm sinh"}));
		cb_timkiem.setBounds(200, 10, 224, 29);
		panel.add(cb_timkiem);
		
		ip_timkiem = new JTextField();
		ip_timkiem.setBounds(200, 49, 224, 35);
		panel.add(ip_timkiem);
		ip_timkiem.setColumns(10);
		
		 cb_loc = new JComboBox();
		 cb_loc.setBackground(new Color(255, 255, 255));
		 
		cb_loc.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Nam ", "Nữ", "Quản lý", "Thu ngân"}));
		cb_loc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cb_loc.setBounds(1283, 10, 224, 29);
		panel.add(cb_loc);
		
		JLabel lblLc = new JLabel("Lọc :");
		lblLc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/filter.png")));
		lblLc.setHorizontalAlignment(SwingConstants.CENTER);
		lblLc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLc.setBounds(1133, 10, 140, 29);
		panel.add(lblLc);
		
		 btn_timkiem = new JButton("T\u00ECm ki\u1EBFm");
		 btn_timkiem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/searchnv.png")));
		 btn_timkiem.setBackground(new Color(255, 255, 255));
		
		btn_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_timkiem.setBounds(434, 49, 140, 35);
		panel.add(btn_timkiem);
		
		JButton btn_refresh = new JButton("Refresh");
		btn_refresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_refresh.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/refresh-page-option.png")));
		btn_refresh.setBackground(new Color(255, 255, 255));
		
		btn_refresh.setBounds(1352, 65, 140, 29);
		panel.add(btn_refresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 1514, 642);
		add(scrollPane);
		
		 panel_1 = new JPanel();
		 panel_1.setBackground(new Color(255, 128, 0));
		 panel_1.setLayout(new WrapLayout());
		scrollPane.setViewportView(panel_1);
		addlist();
		
		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				addlist();
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		btn_timkiem.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panel_1.removeAll();
		 		if(cb_timkiem.getSelectedIndex()==0) {
		 			addlisttheoten(ip_timkiem.getText().trim());
				 }
		 		else if(cb_timkiem.getSelectedIndex()==1) {
		 			searchcccd(ip_timkiem.getText().trim());
		 		}
		 		else if(cb_timkiem.getSelectedIndex()==2) {
		 			searchphone(ip_timkiem.getText().trim());
		 		}
		 		else if(cb_timkiem.getSelectedIndex()==3) {
		 		addlisttheonamsinh(ip_timkiem.getText().trim());
		 		}
		 		
				panel_1.repaint();
				panel_1.revalidate();
		 	}
		 });
		 
		cb_loc.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		panel_1.removeAll();
		 		if(cb_loc.getSelectedItem().equals("Tất cả")) {
		 			addlist();
		 		}
		 		else if(cb_loc.getSelectedIndex()==1) {
		 			addlistgioitinhNam("Nam");
				 }
		 		else if(cb_loc.getSelectedItem().equals("Nữ")) {
		 			addlistgioitinhNu("Nam");
		 			
		 		}
		 		else if(cb_loc.getSelectedItem().equals("Quản lý")) {
		 			addlistchucvu("nvql");
		 			
		 		}
		 		else if(cb_loc.getSelectedItem().equals("Thu ngân")) {
		 			addlistchucvu("nvtn");
		 			
		 		}
				panel_1.repaint();
				panel_1.revalidate();
		 	}
		 });
		 
		
	}
	public void addlist() {
		ArrayList<NhanVien> nv=nv_dao.getAllNhanVien();
		for (NhanVien nhanVien : nv) {
			if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
		}
	}
	public void addlisttheoten(String name) {
		ArrayList<NhanVien> nv=nv_dao.getNhanVientheoten(name);
		if(nv.size()<=0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy !");
			return;
		}
		for (NhanVien nhanVien : nv) {
			if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
		}
	}
	public void addlisttheonamsinh(String namsinh) {
		ArrayList<NhanVien> nv=nv_dao.getNhanVientheonamsinh(namsinh);
		if(nv.size()<=0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy !");
			return;
		}
		for (NhanVien nhanVien : nv) {
			if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
		}
	}
	public void searchcccd(String inputcccd) {
		NhanVien nhanVien=nv_dao.getNhanViencccd(inputcccd);
		 if(nhanVien==null) {
				JOptionPane.showMessageDialog(btn_timkiem, "Không tìm thấy !");
				return;
			}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
			panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
			panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
			panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
			panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
		}
		
	}
	public void searchmanv(int manv) {
		NhanVien nhanVien=nv_dao.getNhanVien(manv);
		 if(nhanVien==null) {
				JOptionPane.showMessageDialog(btn_timkiem, "Không tìm thấy !");
				return;
			}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
			panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
			panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
			panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
			panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
		}
		
	}
	public void searchphone(String phone) {
		NhanVien nhanVien=nv_dao.getNhanVienphone(phone);
		 if(nhanVien==null) {
				JOptionPane.showMessageDialog(btn_timkiem, "Không tìm thấy !");
				return;
			}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
			panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
			panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
			panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
		}
		else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
			panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
		}	
	}
	public void addlistgioitinhNam(String gioitinh) {
		ArrayList<NhanVien> nv=nv_dao.getNhanViengioitinhnam("Nam");
		for (NhanVien nhanVien : nv) {
			if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
		}
	}
	public void addlistgioitinhNu(String gioitinh) {
		ArrayList<NhanVien> nv=nv_dao.getNhanViengioitinhnu(gioitinh);
		for (NhanVien nhanVien : nv) {
			if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
		}
	}
	public void addlistchucvu(String chucvu) {
		ArrayList<NhanVien> nv=nv_dao.getNhanVienchucvu(chucvu);
		for (NhanVien nhanVien : nv) {
			if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon1, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvql")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon2, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Quản lý", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nam")) {
				panel_1.add(new Detail_nhanvien_item(icon3, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
			else if(nhanVien.getChucVu().equalsIgnoreCase("nvtn")&&nhanVien.getGioiTinh().equalsIgnoreCase("nữ")) {
				panel_1.add(new Detail_nhanvien_item(icon4, nhanVien.getTenNV(),String.valueOf(nhanVien.getMaNV()),"Thu ngân", nhanVien.getPhone()));
			}
		}
	}
}
