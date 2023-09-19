package UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Dao.HoaDon_DAO;
import Entity.HoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Chitietthongkehoadon_ui extends JPanel {
	private JTable table;
	private JTextField ip_timkiem;
	private DefaultTableModel tableModel;
	private HoaDon_DAO hd_dao=new HoaDon_DAO();
	private JComboBox cb_timkiem;
	private JLabel lb_tiendichvu;
	private JLabel lb_tienphong;
private JLabel lb_tongtien;
private String output="C:\\Users\\admin\\Desktop\\danhsachhoadon.xls";

	/**
	 * Create the panel.
	 */
	public Chitietthongkehoadon_ui() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1534,710);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 1514, 595);
		add(scrollPane);
		cb_timkiem = new JComboBox();
		cb_timkiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		cb_timkiem.setBackground(new Color(255, 255, 255));
		cb_timkiem.setModel(new DefaultComboBoxModel(new String[] {"Tháng", "Năm", "Ngày trong tháng"}));
		cb_timkiem.setBounds(882, 10, 240, 46);
		add(cb_timkiem);
		
		String [] headers = "MaHD;Makh;Maphong;Ngaydat;Tiendichvu;Tienphong;Manv".split(";");
		tableModel=new DefaultTableModel(headers,0);
		table = new JTable(tableModel);
		table.getTableHeader().setBackground(new Color(102, 255, 255));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		
		JButton btn_timkiem = new JButton("Tìm kiếm");
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb_timkiem.getSelectedIndex()==0) {
					if(!isNumeric(ip_timkiem.getText())||ip_timkiem.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Chỉ được nhập số và không được để trống");
					}
					else if(hd_dao.getmahoadontheothang(Integer.parseInt(ip_timkiem.getText())).size()<1) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy");
					}
					else {
						tableModel.setRowCount(0);
						addtabletheothang(Integer.parseInt(ip_timkiem.getText()));
						
					}
					
				 }
		 		else if(cb_timkiem.getSelectedIndex()==1) {
						if(!isNumeric(ip_timkiem.getText())||ip_timkiem.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Chỉ được nhập số và không được để trống");
						}
						else if(hd_dao.getmahoadontheonam(Integer.parseInt(ip_timkiem.getText())).size()<1) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy");
						}
						else {
							tableModel.setRowCount(0);
				 			addtabletheonam(Integer.parseInt(ip_timkiem.getText()));
				 			
						}
		 		
		 		}
		 		else if(cb_timkiem.getSelectedIndex()==2) {
		 			java.util.Date date= new Date();
		 			Calendar cal = Calendar.getInstance();
		 			cal.setTime(date);
		 			int month = cal.get(Calendar.MONTH);
		 			int year = cal.get(Calendar.YEAR);
						if(!isNumeric(ip_timkiem.getText())||ip_timkiem.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Chỉ được nhập số và không được để trống");
						}
						else if(hd_dao.getmahoadonhomnay(Integer.parseInt(ip_timkiem.getText()),month+1, year).size()<1) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy");
						}
						else {
							tableModel.setRowCount(0);
				 			addtabletrongngay(Integer.parseInt(ip_timkiem.getText()),month+1, year);
				 			
						}	
		 		}
				}
		});
		btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_timkiem.setBackground(new Color(255, 255, 255));
		btn_timkiem.setBounds(1379, 10, 145, 46);
		add(btn_timkiem);
		
		ip_timkiem = new JTextField();
		ip_timkiem.setBounds(1133, 10, 234, 46);
		add(ip_timkiem);
		ip_timkiem.setColumns(10);
		
		 lb_tiendichvu = new JLabel("New label");
		lb_tiendichvu.setForeground(new Color(255, 0, 0));
		lb_tiendichvu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_tiendichvu.setBounds(10, 671, 367, 29);
		add(lb_tiendichvu);
		
		 lb_tienphong = new JLabel("New label");
		lb_tienphong.setForeground(new Color(255, 0, 0));
		lb_tienphong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_tienphong.setBounds(387, 671, 519, 29);
		add(lb_tienphong);
		
		 lb_tongtien = new JLabel("New label");
		lb_tongtien.setForeground(new Color(255, 0, 0));
		lb_tongtien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_tongtien.setBounds(916, 671, 431, 29);
		add(lb_tongtien);
		
		JButton btn_xuathoadon = new JButton("");
		btn_xuathoadon.addActionListener(new ActionListener() {
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
		btn_xuathoadon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/printing.png")));
		btn_xuathoadon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_xuathoadon.setBackground(new Color(0, 255, 64));
		btn_xuathoadon.setBounds(1357, 671, 81, 29);
		add(btn_xuathoadon);
		
		JLabel lblNewLabel_4 = new JLabel("Chi tiết hóa đơn ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_4.setBounds(10, 10, 519, 46);
		add(lblNewLabel_4);
		
		 
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm theo :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(727, 10, 145, 46);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/refresh-page-option.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				addtable();
			}
		});
		btnNewButton.setBounds(1448, 671, 56, 29);
		add(btnNewButton);
		addtable();
	}
	public void addtable() {
		NumberFormat formatter = new DecimalFormat("#0.0"); 
		double x=0;
		double y=0;

		ArrayList<HoaDon> hd=hd_dao.getAllHoaDon();
		for (HoaDon hoadon : hd) {
			Object [] row= {hoadon.getMaHD(),hoadon.getMaKH(),hoadon.getMaPhong(),hoadon.getNgayDat(),hoadon.getTongTienDV(),hoadon.getTongTienPhong(),hoadon.getMaNV()};
			tableModel.addRow(row);
			x+=hoadon.getTongTienDV();
			y+=hoadon.getTongTienPhong();
	
		}
		tongtien(formatter.format(x), formatter.format(y), formatter.format(x+y));
	}
	public void addtabletheothang(int thang) {
		NumberFormat formatter = new DecimalFormat("#0.0"); 
		double x=0;
		double y=0;
		double z=0;
		ArrayList<HoaDon> hd=hd_dao.getmahoadontheothang(thang);
		for (HoaDon hoadon : hd) {
			Object [] row= {hoadon.getMaHD(),hoadon.getMaKH(),hoadon.getMaPhong(),hoadon.getNgayDat(),hoadon.getTongTienDV(),hoadon.getTongTienPhong(),hoadon.getMaNV()};
			tableModel.addRow(row);
			x+=hoadon.getTongTienDV();
			y+=hoadon.getTongTienPhong();	
		}
		tongtien(formatter.format(x), formatter.format(y), formatter.format(x+y));
	}
	public void addtabletheonam(int nam) {
		NumberFormat formatter = new DecimalFormat("#0.0"); 
		double x=0;
		double y=0;
		ArrayList<HoaDon> hd=hd_dao.getmahoadontheonam(nam);
		for (HoaDon hoadon : hd) {
			Object [] row= {hoadon.getMaHD(),hoadon.getMaKH(),hoadon.getMaPhong(),hoadon.getNgayDat(),hoadon.getTongTienDV(),hoadon.getTongTienPhong(),hoadon.getMaNV()};
			tableModel.addRow(row);
			x+=hoadon.getTongTienDV();
			y+=hoadon.getTongTienPhong();
		}
		tongtien(formatter.format(x), formatter.format(y), formatter.format(x+y));
	}
	public void addtabletrongngay(int thang,int nam,int ngay) {
		NumberFormat formatter = new DecimalFormat("#0.0"); 
		double x=0;
		double y=0;
		ArrayList<HoaDon> hd=hd_dao.getmahoadonhomnay( thang, nam, ngay);
		for (HoaDon hoadon : hd) {
			Object [] row= {hoadon.getMaHD(),hoadon.getMaKH(),hoadon.getMaPhong(),hoadon.getNgayDat(),hoadon.getTongTienDV(),hoadon.getTongTienPhong(),hoadon.getMaNV()};
			tableModel.addRow(row);
			x+=hoadon.getTongTienDV();
			y+=hoadon.getTongTienPhong();
				
		}
		tongtien(formatter.format(x), formatter.format(y), formatter.format(x+y));
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	public void tongtien(String tiendv,String tienphong,String tongtien) {
		lb_tiendichvu.setText("Tổng Tiền Dịch Vụ:  "+tiendv+"  VND");
		lb_tienphong.setText("Tổng Tiền Phòng:  "+tienphong+"  VND");
		lb_tongtien.setText("Tổng doanh thu :  "+tongtien+"  VND");
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
private void exportPDF(JTable jTable,int doanhthu) {
    MessageFormat header=new MessageFormat("DANH SÁCH HÓA ĐƠN");
    MessageFormat footer=new MessageFormat("Tổng Hóa đơn:   "+doanhthu);
    try {
		jTable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
	} catch (PrinterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
