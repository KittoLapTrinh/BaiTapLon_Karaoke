package UI;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Date;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import Checkregex.RegexThemKhachHang;

import javax.swing.JScrollPane;

import Dao.KhachHang_DAO;
import Dao.Phong_DAO;
import Entity.KhachHang;
import Entity.Phong;
import button.MyButton;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Quanlykhachhang extends JPanel {
	
	private DefaultTableModel tableModel;
	private JTextField ip_makhachhang;
	private JTextField ip_tenkhachhang;
	private JTextField ip_sodienthoai;
	private JTextField ip_diachi;
	private JTextField ip_email;
	private JTable table;
	private JDateChooser dateChooser;
	private JComboBox cb_gioitinh;
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	private JTextField ip_timkiemmakhachhang;
	private RegexThemKhachHang rg_themkhachhang=new RegexThemKhachHang();
	private JLabel lb_soluongkhach;
	private Phong_DAO phong_DAO=new Phong_DAO();
	private String output="C:\\Users\\admin\\Desktop\\danhsachkhachhang.xls";

	/**
	 * Create the panel.
	 */
	public Quanlykhachhang() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1534,756);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1540, 756);
		add(panel);
		panel.setLayout(null);
		TitledBorder titledBorder=new TitledBorder("Thông tin khách hàng");
		titledBorder.setTitleFont(new Font("Arial", Font.ITALIC, 20));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		Border border = BorderFactory.createTitledBorder(titledBorder);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(border);
		
		panel_1.setBounds(0, 81, 455, 675);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lb_makhachhang = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng");
		lb_makhachhang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lb_makhachhang.setBounds(22, 56, 128, 24);
		panel_1.add(lb_makhachhang);
		
		JLabel lb_tenkhachhang = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lb_tenkhachhang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lb_tenkhachhang.setBounds(22, 119, 128, 24);
		panel_1.add(lb_tenkhachhang);
		
		JLabel lb_sodienthoai = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lb_sodienthoai.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lb_sodienthoai.setBounds(22, 182, 128, 24);
		panel_1.add(lb_sodienthoai);
		
		JLabel lb_email = new JLabel("Email");
		lb_email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lb_email.setBounds(22, 373, 128, 24);
		panel_1.add(lb_email);
		
		JLabel lb_ngaysinh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lb_ngaysinh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lb_ngaysinh.setBounds(22, 436, 128, 24);
		panel_1.add(lb_ngaysinh);
		
		ip_makhachhang = new JTextField();
		ip_makhachhang.setBounds(188, 56, 250, 30);
		panel_1.add(ip_makhachhang);
		ip_makhachhang.setColumns(10);
		
		ip_tenkhachhang = new JTextField();
		ip_tenkhachhang.setColumns(10);
		ip_tenkhachhang.setBounds(188, 119, 250, 30);
		panel_1.add(ip_tenkhachhang);
		
		ip_sodienthoai = new JTextField();
		ip_sodienthoai.setColumns(10);
		ip_sodienthoai.setBounds(188, 182, 250, 30);
		panel_1.add(ip_sodienthoai);
		
		ip_email = new JTextField();
		ip_email.setColumns(10);
		ip_email.setBounds(188, 373, 250, 30);
		panel_1.add(ip_email);
		
		ip_diachi = new JTextField();
		ip_diachi.setColumns(10);
		ip_diachi.setBounds(188, 436, 250, 30);
		panel_1.add(ip_diachi);
		
		JButton btn_xoakhachhang = new MyButton(new Color(255, 80, 80),new Color(255, 80, 80), new Color(255, 0, 0));
		btn_xoakhachhang.setForeground(new Color(255, 255, 255));
		btn_xoakhachhang.setText("Xóa");
		btn_xoakhachhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/delete.png")));
		btn_xoakhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_xoakhachhang.setBounds(257, 535, 188, 53);
		panel_1.add(btn_xoakhachhang);
		
		JButton btn_suakhachhang = new MyButton(new Color(102, 255, 51),new Color(102, 255, 51), new Color(0, 153, 51));
		btn_suakhachhang.setForeground(new Color(255, 255, 255));
		btn_suakhachhang.setText("Sửa");
		btn_suakhachhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/support.png")));
		btn_suakhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_suakhachhang.setBounds(10, 535, 188, 53);
		panel_1.add(btn_suakhachhang);
		
		JButton btn_Themkhachhang = new MyButton(new Color(102, 255, 51),new Color(102, 255, 51), new Color(0, 153, 51));
		btn_Themkhachhang.setForeground(new Color(255, 255, 255));
		btn_Themkhachhang.setText("Thêm");
		btn_Themkhachhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/add-user.png")));
		btn_Themkhachhang.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_Themkhachhang.setBounds(10, 612, 428, 53);
		panel_1.add(btn_Themkhachhang);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u1EDBi T\u00EDnh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(22, 245, 128, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y Sinh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(22, 315, 128, 24);
		panel_1.add(lblNewLabel_1_1);
		
		cb_gioitinh = new JComboBox();
		cb_gioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cb_gioitinh.setBounds(188, 246, 250, 30);
		panel_1.add(cb_gioitinh);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(188, 309, 250, 30);
		panel_1.add(dateChooser);
		
		JButton btn_timkiem = new JButton("T\u00ECm ki\u1EBFm");
		btn_timkiem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/searchnv.png")));
		btn_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_timkiem.setBounds(1054, 32, 188, 29);
		panel_1.add(btn_timkiem);
		
		ip_timkiemmakhachhang = new JTextField();
		ip_timkiemmakhachhang.setBounds(1252, 32, 188, 29);
		panel_1.add(ip_timkiemmakhachhang);
		ip_timkiemmakhachhang.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(465, 201, 1065, 545);
		panel.add(scrollPane);
		
		String [] headers = "MaKH;TenKH;Gioitinh;NgaySinh;Phone;Email;DiaChi".split(";");
		tableModel=new DefaultTableModel(headers,0);
		table = new JTable(tableModel);
		table.getTableHeader().setBackground(new Color(102, 255, 255));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n l\u00FD kh\u00E1ch h\u00E0ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 10, 417, 61);
		panel.add(lblNewLabel);
		
		addtable();

		
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
				ip_makhachhang.setText(tableModel.getValueAt(index,0).toString());
				ip_tenkhachhang.setText(tableModel.getValueAt(index,1).toString());
				if(tableModel.getValueAt(index, 2).toString().equalsIgnoreCase("Nữ")) {
					cb_gioitinh.setSelectedIndex(1);
				}
				if(tableModel.getValueAt(index, 2).toString().equalsIgnoreCase("Nam")) {
					cb_gioitinh.setSelectedIndex(0);
				}
				
				ip_sodienthoai.setText(tableModel.getValueAt(index,4).toString());
				
				Date date;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse((String)tableModel.getValueAt(index, 3).toString());
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
				ip_email.setText(tableModel.getValueAt(index,5).toString());	
				ip_diachi.setText(tableModel.getValueAt(index,6).toString());		
				
				
			}
		});
		
		ip_makhachhang.setEditable(false);
		ip_tenkhachhang.setEditable(false);
		ip_sodienthoai.setEditable(false);
		ip_email.setEditable(false);
		ip_diachi.setEditable(false);
		dateChooser.setEnabled(false);
		cb_gioitinh.setEnabled(false);
		
		JLabel lb_regextenkh = new JLabel("New label");
		lb_regextenkh.setVisible(false);
		lb_regextenkh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_regextenkh.setForeground(new Color(255, 0, 0));
		lb_regextenkh.setBounds(188, 159, 250, 13);
		panel_1.add(lb_regextenkh);
		
		JLabel lb_regexsodienthoai = new JLabel("New label");
		lb_regexsodienthoai.setVisible(false);
		lb_regexsodienthoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_regexsodienthoai.setForeground(new Color(255, 0, 0));
		lb_regexsodienthoai.setBounds(188, 222, 250, 13);
		panel_1.add(lb_regexsodienthoai);
		
		JLabel lb_regexngaysinh = new JLabel("New label");
		lb_regexngaysinh.setVisible(false);
		lb_regexngaysinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_regexngaysinh.setForeground(new Color(255, 0, 0));
		lb_regexngaysinh.setBounds(188, 350, 250, 13);
		panel_1.add(lb_regexngaysinh);
		
		JLabel lb_regexemail = new JLabel("New label");
		lb_regexemail.setVisible(false);
		lb_regexemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_regexemail.setForeground(new Color(255, 0, 0));
		lb_regexemail.setBounds(188, 413, 250, 13);
		panel_1.add(lb_regexemail);
		
		JLabel lb_regexdiachi = new JLabel("New label");
		lb_regexdiachi.setVisible(false);
		lb_regexdiachi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb_regexdiachi.setForeground(new Color(255, 0, 0));
		lb_regexdiachi.setBounds(188, 476, 250, 13);
		panel_1.add(lb_regexdiachi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 255));
		panel_2.setBounds(1191, 87, 339, 47);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Tất cả")) {
		 		tableModel.setRowCount(0);
		 		try {
					loadData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		}
		 		else if(comboBox.getSelectedIndex()==1) {
		 			tableModel.setRowCount(0);
		 			try {
						lockhachhangnam();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 }
		 		else if(comboBox.getSelectedItem().equals("Nữ")) {
		 			tableModel.setRowCount(0);
		 			try {
						lockhachhangnu();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		 		}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Nam", "Nữ"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(105, 10, 224, 28);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Lọc :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 6, 85, 33);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		MyButton btn_xuatdanhsach = new MyButton(new Color(0, 102, 255), new Color(0, 102, 255), new Color(0, 153, 51));
		btn_xuatdanhsach.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/printing.png")));
		btn_xuatdanhsach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] choose = {"Excel", "PDF","Cancel"};

				int n = JOptionPane.showOptionDialog(null,
				    "Bạn muốn xuất file như thế nào ?",
				    "Chọn loại",
				    JOptionPane.DEFAULT_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    choose,
				    choose[0]);
				
				if(n==0) {
					exportExcel(table, new File(output));
					
				}
				else if(n==1) {
					exportPDF(table, tableModel.getRowCount());
					
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Xuất danh sách không thành công");
				}
				
			}
		});
		btn_xuatdanhsach.setText("Xuất danh sách");
		btn_xuatdanhsach.setForeground(Color.WHITE);
		btn_xuatdanhsach.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_xuatdanhsach.setBounds(936, 81, 245, 53);
		panel.add(btn_xuatdanhsach);
		
		MyButton btn_thongtinchiitet = new MyButton(new Color(0, 102, 255), new Color(0, 102, 255), new Color(0, 153, 51));
		btn_thongtinchiitet.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/resume.png")));
		btn_thongtinchiitet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ip_makhachhang.getText().equalsIgnoreCase("")) {
            		JOptionPane.showMessageDialog(null, "Chọn khách hàng muốn xem thông tin");
            	}
				else {
					new thongtinkhachhang(Integer.parseInt(ip_makhachhang.getText())).setVisible(true);
				}
				
			}
		});
		btn_thongtinchiitet.setText("Xem thông tin chi tiết");
		btn_thongtinchiitet.setForeground(Color.WHITE);
		btn_thongtinchiitet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_thongtinchiitet.setBounds(633, 81, 293, 53);
		panel.add(btn_thongtinchiitet);
		
		 lb_soluongkhach = new JLabel("");
		lb_soluongkhach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_soluongkhach.setBounds(465, 81, 186, 47);
		panel.add(lb_soluongkhach);
		capnhapsoluong(lb_soluongkhach);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(465, 138, 1065, 53);
		panel_3.setBackground(new Color(51, 153, 255));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Danh sách khách hàng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 1065, 53);
		panel_3.add(lblNewLabel_3);
	
		
		
		
		btn_Themkhachhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(btn_Themkhachhang.getText().equalsIgnoreCase("Thêm")) {
            		ip_tenkhachhang.setEditable(true);
        			ip_sodienthoai.setEditable(true);
        			ip_email.setEditable(true);
        			ip_diachi.setEditable(true);
        			cb_gioitinh.setEditable(true);
        			dateChooser.setEnabled(true);
        			cb_gioitinh.setEnabled(true);
        			btn_Themkhachhang.setText("Lưu");
            	}
            	else {
            		if(ip_tenkhachhang.getText().trim().equalsIgnoreCase("")||ip_diachi.getText().trim().equalsIgnoreCase("")||ip_email.getText().trim().equalsIgnoreCase("")||ip_sodienthoai.getText().trim().equalsIgnoreCase("")||dateChooser.getDate()==null) {
            			JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
            			btn_Themkhachhang.setText("Thêm");
            			ip_tenkhachhang.setEditable(false);
            			ip_sodienthoai.setEditable(false);
            			ip_email.setEditable(false);
            			ip_diachi.setEditable(false);
            			dateChooser.setEnabled(false);
            			cb_gioitinh.setEnabled(false);
            		}
            		else if(checkregex(ip_tenkhachhang.getText().trim(),ip_sodienthoai.getText().trim())==true) {
            			them();
            			capnhapsoluong(lb_soluongkhach);
            			btn_Themkhachhang.setText("Thêm");
            			ip_tenkhachhang.setEditable(false);
            			ip_sodienthoai.setEditable(false);
            			ip_email.setEditable(false);
            			ip_diachi.setEditable(false);
            			dateChooser.setEnabled(false);
            			cb_gioitinh.setEnabled(false);
            		}
            		else {
                		JOptionPane.showMessageDialog(null, "Thêm Thất bại");
                	}
            	}
            }
        });
		
		btn_xoakhachhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<Phong> phonglist=phong_DAO.getAllPhongkhachhang(ip_makhachhang.getText());
            	if(ip_makhachhang.getText().equalsIgnoreCase("")) {
            		JOptionPane.showMessageDialog(null, "Chọn khách hàng muốn xóa");
            	}
            	else if(phonglist.size()>0) {
            		JOptionPane.showMessageDialog(null, "Khách hàng đang sử dụng dịch vụ không thể xóa");
            	}
            	else {
                	xoa();
                	capnhapsoluong(lb_soluongkhach);
            	}

            }
        });
		
		btn_suakhachhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ArrayList<Phong> phonglist=phong_DAO.getAllPhongkhachhang(ip_makhachhang.getText());
            	if(ip_makhachhang.getText().equalsIgnoreCase("")) {
            		JOptionPane.showMessageDialog(null, "Chọn khách hàng muốn sửa");
            	}
            	else if(phonglist.size()>0) {
            		JOptionPane.showMessageDialog(null, "Khách hàng đang sử dụng dịch vụ không thể sửa");
            	}
            	else if(btn_suakhachhang.getText().equalsIgnoreCase("Sửa")) {
            		ip_tenkhachhang.setEditable(true);
        			ip_sodienthoai.setEditable(true);
        			ip_email.setEditable(true);
        			ip_diachi.setEditable(true);
        			cb_gioitinh.setEditable(true);
        			dateChooser.setEnabled(true);
        			cb_gioitinh.setEnabled(true);
        			btn_suakhachhang.setText("Lưu");
            	}
            	else {
            		if(ip_tenkhachhang.getText().trim().equalsIgnoreCase("")||ip_diachi.getText().trim().equalsIgnoreCase("")||ip_email.getText().trim().equalsIgnoreCase("")||ip_sodienthoai.getText().trim().equalsIgnoreCase("")||dateChooser.getDate()==null) {
            			JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin");
            			btn_suakhachhang.setText("Sửa");
            			ip_tenkhachhang.setEditable(false);
            			ip_sodienthoai.setEditable(false);
            			ip_email.setEditable(false);
            			ip_diachi.setEditable(false);
            			dateChooser.setEnabled(false);
            			cb_gioitinh.setEnabled(false);
            		}
            		else if(checkregex(ip_tenkhachhang.getText().trim(),ip_sodienthoai.getText().trim())==true) {
            			luu();
            			capnhapsoluong(lb_soluongkhach);
            			btn_suakhachhang.setText("Sửa");
            			ip_tenkhachhang.setEditable(false);
            			ip_sodienthoai.setEditable(false);
            			ip_email.setEditable(false);
            			ip_diachi.setEditable(false);
            			dateChooser.setEnabled(false);
            			cb_gioitinh.setEnabled(false);
            		}
            		else {
                		JOptionPane.showMessageDialog(null, "Sửa Thất bại");
                	}
            	}
            	
            	
            }
        });
		btn_timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tim();
            }

        });
	}

	

//Sự kiện tìm
		public void tim() {
			int maKhachHang = Integer.parseInt(ip_timkiemmakhachhang.getText());
			KhachHang kh1=kh_dao.getKhachHang(maKhachHang);
			if (kh1 == null) {
				while(this.tableModel.getRowCount()>0) {
					this.tableModel.removeRow(0);
				}
				JOptionPane.showMessageDialog(this, "Không tồn tại mã khách hàng cần tìm");
			} else {
				while(this.tableModel.getRowCount()>0) {
					this.tableModel.removeRow(0);
				}
				Object [] row= {kh1.getMaKH(),kh1.getTenKH(),kh1.getGioiTinh(), kh1.getNgaySinh(),kh1.getPhone(), kh1.getEmail(),kh1.getDiaChi()};
				tableModel.addRow(row);
			}
			clearTextField();
		}
	
	//Su kien Them
		public boolean them()  {

			
			KhachHang kh=new KhachHang();
	        kh.setTenKH(ip_tenkhachhang.getText());
	        kh.setGioiTinh(cb_gioitinh.getSelectedItem().toString());
	        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
	        String date	= dcn.format(dateChooser.getDate());
	        kh.setNgaySinh(dateChooser.getDate());
	        kh.setEmail(ip_email.getText());
	        kh.setPhone(ip_sodienthoai.getText());	
	        kh.setDiaChi(ip_diachi.getText());
	        kh_dao.addKhachHang(kh);   
	        tableModel.setRowCount(0);
	        addtable();
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			clearTextField();
			return true;
		}
	
		public void addtable() {
			ArrayList<KhachHang> kh=kh_dao.getAllKhachHang();
			for (KhachHang khachhang : kh) {
				Object [] row= {khachhang.getMaKH(),khachhang.getTenKH(), khachhang.getGioiTinh(), khachhang.getNgaySinh(),khachhang.getPhone(), khachhang.getEmail(),khachhang.getDiaChi()};
				tableModel.addRow(row);
			}
		}

			//Sự kiện xóa
			public boolean xoa() {
				if (this.table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(this, "Ban phải chọn dòng cần xoá");
					return false;
				}
				int row = this.table.getSelectedRow();
				String maKhachHang = this.tableModel.getValueAt(row, 0).toString();
				if (JOptionPane.showConfirmDialog(this, "Bạn xác nhận xoá khách hàng đã chọn", "Confirm",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					KhachHang_DAO khachhang = new KhachHang_DAO();
					try {
						if (khachhang.xoaKhachHang(maKhachHang)) {
							loadData();
							JOptionPane.showMessageDialog(this, "Xoá khách hàng thành công");
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
	
	
	//Sự kiện lưu(cap nhat)
		public boolean luu() {
			int maKhachHang = Integer.parseInt(ip_makhachhang.getText());
			String ten = this.ip_tenkhachhang.getText().trim();
			String sdt = this.ip_sodienthoai.getText().trim();
			String email = this.ip_email.getText().trim();
			String diaChi = this.ip_diachi.getText().trim();
			java.util.Date ngaySinh = this.dateChooser.getDate();
			String gioiTinh = this.cb_gioitinh.getSelectedItem().toString();

			KhachHang khachHang = new KhachHang(maKhachHang, ten, gioiTinh, ngaySinh, sdt, email, diaChi);
			try {
				this.kh_dao.capNhatKhachHang(khachHang);
				loadData();
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			clearTextField();
			return true;
		}
			
	
		public void clearTextField(){
	        ip_makhachhang.setText("");
	        ip_tenkhachhang.setText("");
	        cb_gioitinh.getSelectedItem();
	        dateChooser.setDate(null);
	        ip_sodienthoai.setText("");
	        ip_email.setText("");
			ip_diachi.setText("");
	        ip_tenkhachhang.requestFocus();
	        
	    }

	public void loadData() throws SQLException {
		while (this.tableModel.getRowCount() > 0) {
			this.tableModel.removeRow(0);
		}
		this.kh_dao = new KhachHang_DAO();
		List<KhachHang> dsKhachHang = this.kh_dao.getAllKhachHang();
		for (KhachHang khachhang : dsKhachHang) {
			int maKhachHang = khachhang.getMaKH();
			String ten = khachhang.getTenKH();
			String gioiTinh = khachhang.getGioiTinh().toString();
			String ngaySinh = khachhang.getNgaySinh().toString();
			String sdt = khachhang.getPhone();
			String email = khachhang.getEmail();
			String diaChi = khachhang.getDiaChi();
			tableModel.addRow(new Object[] { maKhachHang, ten, gioiTinh, ngaySinh, sdt,email, diaChi});
		}
	}
	public void capnhapsoluong(JLabel lbsoluong) {
		int x=tableModel.getRowCount();
		lbsoluong.setText("Số lượng khách: "+x);
	}
	public void exportExcel(JTable jTable, File file) {
		
		try {
			TableModel extableModel=jTable.getModel();
			FileWriter fileWriter=new FileWriter(file);
			
			for(int i = 0; i < extableModel.getColumnCount(); i++){
				fileWriter.write(extableModel.getColumnName(i) + "\t");
		      }
			fileWriter.write("\n");
			for(int i=0; i < extableModel.getRowCount(); i++) {
		        for(int j=0; j < extableModel.getColumnCount(); j++) {
		        	fileWriter.write(extableModel.getValueAt(i,j).toString()+"\t");
		        }
		        fileWriter.write("\n");
		      }
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void exportPDF(JTable jTable,int count) {
	    MessageFormat header=new MessageFormat("DANH SÁCH KHÁCH HÀNG");
	    MessageFormat footer=new MessageFormat("Tổng số khách hàng:  "+count);
	    try {
			jTable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	public void lockhachhangnam() throws SQLException {
		while (this.tableModel.getRowCount() > 0) {
			this.tableModel.removeRow(0);
		}
		this.kh_dao = new KhachHang_DAO();
		List<KhachHang> dsKhachHang = this.kh_dao.getAllKhachHang();
		for (KhachHang khachhang : dsKhachHang) {
			if(khachhang.getGioiTinh().toString().equals("Nam")) {
				int maKhachHang = khachhang.getMaKH();
				String ten = khachhang.getTenKH();
				String gioiTinh = khachhang.getGioiTinh().toString();
				String ngaySinh = khachhang.getNgaySinh().toString();
				String sdt = khachhang.getPhone();
				String email = khachhang.getEmail();
				String diaChi = khachhang.getDiaChi();
				tableModel.addRow(new Object[] { maKhachHang, ten, gioiTinh, ngaySinh, sdt,email, diaChi});
			}
			
		}
	}
	public void lockhachhangnu() throws SQLException {
		while (this.tableModel.getRowCount() > 0) {
			this.tableModel.removeRow(0);
		}
		this.kh_dao = new KhachHang_DAO();
		List<KhachHang> dsKhachHang = this.kh_dao.getAllKhachHang();
		for (KhachHang khachhang : dsKhachHang) {
			if(khachhang.getGioiTinh().toString().equals("Nữ")) {
				int maKhachHang = khachhang.getMaKH();
				String ten = khachhang.getTenKH();
				String gioiTinh = khachhang.getGioiTinh().toString();
				String ngaySinh = khachhang.getNgaySinh().toString();
				String sdt = khachhang.getPhone();
				String email = khachhang.getEmail();
				String diaChi = khachhang.getDiaChi();
				tableModel.addRow(new Object[] { maKhachHang, ten, gioiTinh, ngaySinh, sdt,email, diaChi});
			}
			
		}
	}
	public boolean checkregex(String ten,String sodienthoai) {
		boolean flag=true;
		 if(!(ten.matches("^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*"))) {
			JOptionPane.showMessageDialog(null, "Các ký tự đầu tiên phải in hoa, các ký tự đi theo sau in thường");
			flag=false;
		}
		
		else if(!(sodienthoai.matches("^[0]{1}[973]{1}\\d{8}$"))) {
			JOptionPane.showMessageDialog(null,"Sđt bao gồm 10 số và bắt đầu bằng 09 - 07 - 03");
			flag=false;
		}
		
		return flag;
		
	}
}
