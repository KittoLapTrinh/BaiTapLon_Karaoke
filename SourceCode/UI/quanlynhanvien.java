package UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import Dao.NhanVien_Dao;
import Dao.Taikhoan_dao;
import Dao.NhanVien_Dao;
import Entity.NhanVien;
import Entity.Taikhoan;
import connectDB.ConnectDB;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class quanlynhanvien extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField ip_manhanvien;
	private JTextField ip_tennhanvien;
	private JTextField ip_cccd;
	private JTextField ip_sodienthoai;
	private JTextField ip_diachi;
	private JTextField ip_luong;
	private JTextField ip_taikhoan;
	private JTextField ip_matkhau;
	private NhanVien_Dao nv_dao=new NhanVien_Dao();
	private JComboBox cb_chucvu;
	private JComboBox cb_gioitinh;
	private JDateChooser dateNV;
	private Taikhoan_dao tk_dao=new Taikhoan_dao();
	private JButton btn_themtk;

	/**
	 * Create the panel.
	 */
	public quanlynhanvien() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(134, 237, 249));
		
		setBounds(0, 0, 1534,756);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 94, 744, 314);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 724, 41);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		ip_manhanvien = new JTextField();
		ip_manhanvien.setBounds(174, 0, 540, 41);
		panel_3.add(ip_manhanvien);
		ip_manhanvien.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 0, 174, 41);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(10, 61, 724, 41);
		panel.add(panel_3_1);
		
		ip_tennhanvien = new JTextField();
		ip_tennhanvien.setColumns(10);
		ip_tennhanvien.setBounds(174, 0, 540, 41);
		panel_3_1.add(ip_tennhanvien);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(0, 0, 174, 41);
		panel_3_1.add(lblNewLabel_1_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBounds(10, 112, 724, 41);
		panel.add(panel_3_2);
		
		ip_cccd = new JTextField();
		ip_cccd.setColumns(10);
		ip_cccd.setBounds(174, 0, 540, 41);
		panel_3_2.add(ip_cccd);
		
		JLabel lblNewLabel_1_2 = new JLabel("CCCD");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(0, 0, 174, 41);
		panel_3_2.add(lblNewLabel_1_2);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBounds(10, 163, 724, 41);
		panel.add(panel_3_3);
		
		ip_sodienthoai = new JTextField();
		ip_sodienthoai.setColumns(10);
		ip_sodienthoai.setBounds(174, 0, 540, 41);
		panel_3_3.add(ip_sodienthoai);
		
		JLabel lblNewLabel_1_3 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(0, 0, 174, 41);
		panel_3_3.add(lblNewLabel_1_3);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setLayout(null);
		panel_3_4.setBounds(10, 214, 724, 41);
		panel.add(panel_3_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ch\u1EE9c v\u1EE5");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(0, 0, 174, 41);
		panel_3_4.add(lblNewLabel_1_4);
		
		cb_chucvu = new JComboBox();
		cb_chucvu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_chucvu.setModel(new DefaultComboBoxModel(new String[] {"Qu\u1EA3n l\u00FD", "Nh\u00E2n vi\u00EAn"}));
		cb_chucvu.setBounds(175, 0, 539, 41);
		panel_3_4.add(cb_chucvu);
		
		JPanel panel_3_5 = new JPanel();
		panel_3_5.setLayout(null);
		panel_3_5.setBounds(10, 265, 724, 41);
		panel.add(panel_3_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(0, 0, 174, 41);
		panel_3_5.add(lblNewLabel_1_5);
		
		 cb_gioitinh = new JComboBox();
		cb_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb_gioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		cb_gioitinh.setBounds(175, 0, 539, 41);
		panel_3_5.add(cb_gioitinh);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(764, 94, 721, 314);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3_6 = new JPanel();
		panel_3_6.setLayout(null);
		panel_3_6.setBounds(10, 10, 746, 41);
		panel_1.add(panel_3_6);
		
		JLabel lblNewLabel_1_6 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(0, 0, 174, 41);
		panel_3_6.add(lblNewLabel_1_6);
		
		dateNV = new JDateChooser();
		dateNV.setBounds(172, 0, 530, 41);
		panel_3_6.add(dateNV);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBounds(10, 61, 746, 41);
		panel_1.add(panel_3_1_1);
		
		ip_diachi = new JTextField();
		ip_diachi.setColumns(10);
		ip_diachi.setBounds(174, 0, 528, 41);
		panel_3_1_1.add(ip_diachi);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(0, 0, 174, 41);
		panel_3_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBounds(10, 112, 746, 41);
		panel_1.add(panel_3_2_1);
		
		ip_luong = new JTextField();
		ip_luong.setColumns(10);
		ip_luong.setBounds(174, 0, 528, 41);
		panel_3_2_1.add(ip_luong);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("L\u01B0\u01A1ng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(0, 0, 174, 41);
		panel_3_2_1.add(lblNewLabel_1_2_1);
		
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setLayout(null);
		panel_3_3_1.setBounds(10, 163, 746, 41);
		panel_1.add(panel_3_3_1);
		
		ip_taikhoan = new JTextField();
		ip_taikhoan.setColumns(10);
		ip_taikhoan.setBounds(174, 0, 528, 41);
		panel_3_3_1.add(ip_taikhoan);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("T\u00E0i kho\u1EA3n");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(0, 0, 174, 41);
		panel_3_3_1.add(lblNewLabel_1_3_1);
		
		JPanel panel_3_4_1 = new JPanel();
		panel_3_4_1.setLayout(null);
		panel_3_4_1.setBounds(10, 214, 746, 41);
		panel_1.add(panel_3_4_1);
		
		ip_matkhau = new JTextField();
		ip_matkhau.setColumns(10);
		ip_matkhau.setBounds(174, 0, 528, 41);
		panel_3_4_1.add(ip_matkhau);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(0, 0, 174, 41);
		panel_3_4_1.add(lblNewLabel_1_4_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 418, 1475, 207);
		add(scrollPane);
		
		
		String [] headers = "MaNV;TenNV;Gioitinh;CCCD;Phone;ChucVu;DiaChi;NgaySinh;Luong".split(";");
		tableModel=new DefaultTableModel(headers,0);
		table = new JTable(tableModel);
		table.getTableHeader().setBackground(new Color(102, 255, 255));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setForeground(new Color(128, 128, 128));
		panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 635, 1475, 95);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_themnhanvien = new JButton("Thêm");
		btn_themnhanvien.setForeground(new Color(0, 0, 0));
		btn_themnhanvien.setBackground(new Color(0, 255, 255));
		btn_themnhanvien.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/add-user.png")));
		btn_themnhanvien.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_themnhanvien.setBounds(127, 29, 157, 38);
		panel_2.add(btn_themnhanvien);
		
		JButton btn_capnhatnhanvien = new JButton("Cập nhật");
		btn_capnhatnhanvien.setForeground(new Color(0, 0, 0));
		btn_capnhatnhanvien.setBackground(new Color(128, 255, 255));
		btn_capnhatnhanvien.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/update (1).png")));
		btn_capnhatnhanvien.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_capnhatnhanvien.setBounds(378, 29, 188, 38);
		panel_2.add(btn_capnhatnhanvien);
		
		JButton btn_xoanhanvien = new JButton("X\u00F3a ");
		btn_xoanhanvien.setForeground(new Color(0, 0, 0));
		btn_xoanhanvien.setBackground(new Color(255, 128, 128));
		btn_xoanhanvien.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/delete-user.png")));
		btn_xoanhanvien.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_xoanhanvien.setBounds(907, 29, 157, 38);
		panel_2.add(btn_xoanhanvien);
		
		 btn_themtk = new JButton("Thêm tài khoản");
		 btn_themtk.setForeground(new Color(0, 0, 0));
		 btn_themtk.setBackground(new Color(128, 255, 0));
		 btn_themtk.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/adddv.png")));
		 btn_themtk.setSelectedIcon(new ImageIcon(getClass().getClassLoader().getResource("image/padlock.png")));
		btn_themtk.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn_themtk.setBounds(1149, 29, 226, 38);
		panel_2.add(btn_themtk);
		
		JLabel lblNewLabel_2 = new JLabel("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(64, 0, 64));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_2.setBounds(484, 10, 540, 69);
		add(lblNewLabel_2);
		
		addtable();
		ip_tennhanvien.setEditable(false);
		ip_cccd.setEditable(false);
		ip_sodienthoai.setEditable(false);
		ip_diachi.setEditable(false);
		ip_luong.setEditable(false);
		dateNV.setEnabled(false);
		cb_chucvu.setEnabled(false);
		cb_gioitinh.setEnabled(false);
		ip_taikhoan.setEnabled(false);
		ip_matkhau.setEnabled(false);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int index=table.getSelectedRow();
				ip_manhanvien.setText(tableModel.getValueAt(index,0).toString());
				ip_tennhanvien.setText(tableModel.getValueAt(index,1).toString());
				if(tableModel.getValueAt(index, 2).toString().equalsIgnoreCase("Nữ")) {
					cb_gioitinh.setSelectedIndex(1);
				}
				if(tableModel.getValueAt(index, 2).toString().equalsIgnoreCase("Nam")) {
					cb_gioitinh.setSelectedIndex(0);
				}
				ip_cccd.setText(tableModel.getValueAt(index,3).toString());
				ip_sodienthoai.setText(tableModel.getValueAt(index,4).toString());
				if(tableModel.getValueAt(index, 5).toString().equalsIgnoreCase("NVTN")) {
					cb_chucvu.setSelectedIndex(1);
				}
				if(tableModel.getValueAt(index, 5).toString().equalsIgnoreCase("NVQL")) {
					cb_chucvu.setSelectedIndex(0);
				}
				
				ip_diachi.setText(tableModel.getValueAt(index,6).toString());		
				try {
					Date date =new SimpleDateFormat("yyyy-MM-dd").parse((String)tableModel.getValueAt(index, 7).toString());
					dateNV.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				ip_luong.setText(tableModel.getValueAt(index,8).toString());
				if(tk_dao.gettaikhoan(Integer.parseInt(tableModel.getValueAt(index, 0).toString()))!=null) {
					ip_taikhoan.setText(tk_dao.gettaikhoan(Integer.parseInt(tableModel.getValueAt(index, 0).toString())).getNametk());
					ip_matkhau.setText(tk_dao.gettaikhoan(Integer.parseInt(tableModel.getValueAt(index, 0).toString())).getMatkhau());
				}
				else {
					ip_taikhoan.setText("");
					ip_matkhau.setText("");
				}
			}
		});
		
		this.ip_manhanvien.setEditable(false);

		
		btn_themnhanvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(btn_themnhanvien.getText().equalsIgnoreCase("Thêm")) {
            		ip_tennhanvien.setEditable(true);
            		ip_cccd.setEditable(true);
            		ip_sodienthoai.setEditable(true);
            		ip_diachi.setEditable(true);
            		ip_luong.setEditable(true);
            		dateNV.setEnabled(true);
            		cb_chucvu.setEnabled(true);
            		cb_gioitinh.setEnabled(true);
            		btn_themnhanvien.setText("Lưu");
            		
            	}
            	else {
            		if(ip_tennhanvien.getText().equalsIgnoreCase("")||ip_cccd.getText().equalsIgnoreCase("")||ip_luong.getText().equalsIgnoreCase("")||ip_diachi.getText().equalsIgnoreCase("")||ip_sodienthoai.getText().equalsIgnoreCase("")||dateNV.getDate()==null) {
                		JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
                		btn_themnhanvien.setText("Thêm");
                		ip_tennhanvien.setEditable(false);
                		ip_cccd.setEditable(false);
                		ip_sodienthoai.setEditable(false);
                		ip_diachi.setEditable(false);
                		ip_luong.setEditable(false);
                		dateNV.setEnabled(false);
                		cb_chucvu.setEnabled(false);
                		cb_gioitinh.setEnabled(false);
                	}
            		else if(checkregex(ip_tennhanvien.getText(),ip_cccd.getText(),ip_sodienthoai.getText(),ip_luong.getText())==true) {
            			them();
            			btn_themnhanvien.setText("Thêm");
                		ip_tennhanvien.setEditable(false);
                		ip_cccd.setEditable(false);
                		ip_sodienthoai.setEditable(false);
                		ip_diachi.setEditable(false);
                		ip_luong.setEditable(false);
                		dateNV.setEnabled(false);
                		cb_chucvu.setEnabled(false);
                		cb_gioitinh.setEnabled(false);
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "Thêm Thất bại");
                	}
            	}
        		
            	
            
            	
            }
        });
		
		btn_xoanhanvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	if(ip_manhanvien.getText().equalsIgnoreCase("")||ip_cccd.getText().equalsIgnoreCase("")||ip_luong.getText().equalsIgnoreCase("")||ip_diachi.getText().equalsIgnoreCase("")||ip_sodienthoai.getText().equalsIgnoreCase("")||dateNV.getDate()==null) {
            		JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
            	}
            else if(xoa()==true) {
            		
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Xóa Thất bại");
            		
            	}
            	
            }
        });
		
		btn_capnhatnhanvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(ip_manhanvien.getText().equalsIgnoreCase("")) {
            		JOptionPane.showMessageDialog(null, "Chọn nhân viên muốn cập nhật");
            	}
            else if(btn_capnhatnhanvien.getText().equalsIgnoreCase("Cập nhật")) {
            		ip_tennhanvien.setEditable(true);
            		ip_cccd.setEditable(true);
            		ip_sodienthoai.setEditable(true);
            		ip_diachi.setEditable(true);
            		ip_luong.setEditable(true);
            		dateNV.setEnabled(true);
            		cb_chucvu.setEnabled(true);
            		cb_gioitinh.setEnabled(true);
            		btn_capnhatnhanvien.setText("Lưu");
            		
            	}
            	else {
            		if(ip_tennhanvien.getText().equalsIgnoreCase("")||ip_cccd.getText().equalsIgnoreCase("")||ip_luong.getText().equalsIgnoreCase("")||ip_diachi.getText().equalsIgnoreCase("")||ip_sodienthoai.getText().equalsIgnoreCase("")||dateNV.getDate()==null) {
                		JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
                		btn_capnhatnhanvien.setText("Cập nhật");
                		ip_tennhanvien.setEditable(false);
                		ip_cccd.setEditable(false);
                		ip_sodienthoai.setEditable(false);
                		ip_diachi.setEditable(false);
                		ip_luong.setEditable(false);
                		dateNV.setEnabled(false);
                		cb_chucvu.setEnabled(false);
                		cb_gioitinh.setEnabled(false);
                	}
            		else if(checkregex(ip_tennhanvien.getText(),ip_cccd.getText(),ip_sodienthoai.getText(),ip_luong.getText())==true) {
            			luu();
            			btn_capnhatnhanvien.setText("Cập nhật");
                		ip_tennhanvien.setEditable(false);
                		ip_cccd.setEditable(false);
                		ip_sodienthoai.setEditable(false);
                		ip_diachi.setEditable(false);
                		ip_luong.setEditable(false);
                		dateNV.setEnabled(false);
                		cb_chucvu.setEnabled(false);
                		cb_gioitinh.setEnabled(false);
                		
                	}
                	else {
                		JOptionPane.showMessageDialog(null, "Cập nhật Thất bại");
                	}
            	}
            }
        });
		btn_themtk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (ip_manhanvien.getText()==null) {
        			JOptionPane.showMessageDialog(null, "Ban phải chọn nhân viên muốn thêm tài khoản");
        		}
        		else if(ip_taikhoan.getText().equalsIgnoreCase("")||ip_matkhau.getText().equalsIgnoreCase("")) {
        			JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");

        		}
        		else if(tk_dao.gettaikhoan(Integer.parseInt(ip_manhanvien.getText().trim()))!=null) {
        			JOptionPane.showMessageDialog(null, "Nhân viên đã có tài khoản");
        		}
        		else {  			
        			themtaikhoan();
        		}
            	
            }
        });
		
		
		ip_manhanvien.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(tk_dao.gettaikhoan(Integer.parseInt(ip_manhanvien.getText().trim()))!=null) {
					ip_taikhoan.setEnabled(false);
					ip_matkhau.setEnabled(false);
				}
				else {
					ip_taikhoan.setEnabled(true);
					ip_matkhau.setEnabled(true);
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	//Su kien Them
	public boolean them()  {
		
		
		
		

		NhanVien nv=new NhanVien();
//        nv.setMaNV(Integer.parseInt(ip_manhanvien.getText()));
        nv.setTenNV(ip_tennhanvien.getText());
        nv.setCCCD(ip_cccd.getText());
        nv.setGioiTinh(cb_gioitinh.getSelectedItem().toString());
        if(cb_chucvu.getSelectedItem().toString().equalsIgnoreCase("Nhân Viên")) {
        	nv.setChucVu("NVTN");
        }
        if(cb_chucvu.getSelectedItem().toString().equalsIgnoreCase("Quản lý")) {
        	nv.setChucVu("NVQL");
        }
        nv.setPhone(ip_sodienthoai.getText());
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
//	    String date = dcn.format(dateNV.getDate());		
	    nv.setNgaySinh(dateNV.getDate());
        nv.setLuong(Double.parseDouble(ip_luong.getText()));
        nv.setDiaChi(ip_diachi.getText());
        nv_dao.addNhanVien(nv);
        tableModel.setRowCount(0);
        addtable();
		JOptionPane.showMessageDialog(this, "Thêm thành công");
		clearTextField();
		return true;
	}
		
		//Sự kiện xóa
		public boolean xoa() {
			if (this.table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Ban phải chọn dòng cần xoá");
				return false;
			}
			int row = this.table.getSelectedRow();
			String maNhanVien = this.tableModel.getValueAt(row, 0).toString();
			if (JOptionPane.showConfirmDialog(this, "Bạn xác nhận xoá nhân viên đã chọn", "Confirm",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				NhanVien_Dao nhanvien = new NhanVien_Dao();
				try {
					if (nhanvien.xoaNhanVien(maNhanVien)) {
						loadData();
						JOptionPane.showMessageDialog(this, "Xoá nhân viên thành công");
						clearTextField();
						//huy();
						return true;
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(this, "Bị xảy ra lôi khi xoá", "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
			return false;
		}
		
		//Sự kiện cập nhật
		
		
		//Sự kiện lưu
		public boolean luu() {
			int maNhanVien = Integer.parseInt(ip_manhanvien.getText());
			double luong = Double.parseDouble(ip_luong.getText());
			String ten = this.ip_tennhanvien.getText().trim();
			String cccd = this.ip_cccd.getText().trim();
			String sdt = this.ip_sodienthoai.getText().trim();
			String diaChi = this.ip_diachi.getText().trim();
			java.util.Date ngaySinh = this.dateNV.getDate();
			String chucVu = "";
			if(cb_chucvu.getSelectedItem().equals("Quản lý")){
				chucVu="NVQL";
			}
			else {
				chucVu="NVTN";
			}
			String gioiTinh = this.cb_gioitinh.getSelectedItem().toString();
			NhanVien nhanVien = new NhanVien(maNhanVien, ten, gioiTinh, cccd, sdt, chucVu, diaChi, ngaySinh, luong);
			try {
				this.nv_dao.capNhatNhanVien(nhanVien);
				loadData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Lưu thành công");
			clearTextField();
			return true;
		}
		
		
	public void addtable() {
		ArrayList<NhanVien> nv=nv_dao.getAllNhanVien();
		for (NhanVien nhanvien : nv) {
			Object [] row= {nhanvien.getMaNV(),nhanvien.getTenNV(),nhanvien.getGioiTinh(),nhanvien.getCCCD(),nhanvien.getPhone(),nhanvien.getChucVu(),nhanvien.getDiaChi(),nhanvien.getNgaySinh(),nhanvien.getLuong()};
			tableModel.addRow(row);
		}
	}
	public void clearTextField(){
        ip_manhanvien.setText("");
        ip_tennhanvien.setText("");
        ip_cccd.setText("");
        ip_sodienthoai.setText("");
        dateNV.setDate(null);
        ip_luong.setText("");
		ip_diachi.setText("");
        cb_chucvu.setSelectedItem("Quản lý");
        cb_gioitinh.setSelectedItem("Nam");
        ip_tennhanvien.requestFocus();
        ip_taikhoan.setText("");
        ip_matkhau.setText("");
    }
	
	public void loadData() throws SQLException {
		while (this.tableModel.getRowCount() > 0) {
			this.tableModel.removeRow(0);
		}
		this.nv_dao = new NhanVien_Dao();
		List<NhanVien> dsNhanVien = this.nv_dao.getAllNhanVien();
		for (NhanVien nhanvien : dsNhanVien) {
			int maNhanVien = nhanvien.getMaNV();
			String ten = nhanvien.getTenNV();
			String sdt = nhanvien.getPhone();
			String diaChi = nhanvien.getDiaChi();
			String cccd = nhanvien.getCCCD();
			String ngaySinh = nhanvien.getNgaySinh().toString();
			String gioiTinh = nhanvien.getGioiTinh().toString();
			String chucVu = nhanvien.getChucVu().toString();
			Double luong = nhanvien.getLuong();
			tableModel.addRow(new Object[] { maNhanVien, ten, gioiTinh, cccd, sdt, chucVu, diaChi, ngaySinh, luong});
		}

	}
	public boolean themtaikhoan() {
		
			int maNhanVien = Integer.parseInt(ip_manhanvien.getText());
			String tentk=ip_taikhoan.getText();
			String mk=ip_matkhau.getText();
			tk_dao.addtk(new Taikhoan(tentk, mk), maNhanVien);
			return true;	
	}
	public boolean checkregex(String ten,String cccd,String sodienthoai,String luong) {
		boolean flag=true;
		 if(!(ten.matches("^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*"))) {
			JOptionPane.showMessageDialog(null, "Các ký tự đầu tiên phải in hoa, các ký tự đi theo sau in thường");
			flag=false;
		}
		else if(!cccd.matches("\\d+")||cccd.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Căn cước không được để trống và phải là số");
			flag=false;
		}
		else if(!(sodienthoai.matches("^[0]{1}[973]{1}\\d{8}$"))) {
			JOptionPane.showMessageDialog(null,"Sđt bao gồm 10 số và bắt đầu bằng 09 - 07 - 03");
			flag=false;
		}
		else if(luong.equalsIgnoreCase("")||!luong.matches("\\d+")) {
			JOptionPane.showMessageDialog(null,"Lương phải là số và không được để trống");
			flag=false;
		}
		return flag;
		
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
