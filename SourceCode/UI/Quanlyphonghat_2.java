package UI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.toedter.calendar.JDateChooser;

import Dao.Chitiethoadondv_dao;
import Dao.DatPhong_DAO;
import Dao.HoaDon_DAO;
import Dao.Hoadondv_dao;
import Dao.KhachHang_DAO;
import Dao.NhanVien_Dao;
import Dao.PhieuIn_DAO;
import Dao.Phong_DAO;
import Dao.dichvuphong_dao;
import Entity.Chitiethoadondv;
import Entity.DatPhong;
import Entity.E_inhoadon;
import Entity.HoaDon;
import Entity.Hoadondv;
import Entity.NhanVien;
import Entity.Phong;
import Entity.dichvuphong;
import button.MyButton;
import UI.Themkhachhang;

import javax.swing.JToggleButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quanlyphonghat_2 extends JPanel {
	private JTextField ip_tendv;
	private JTextField ip_dongia;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField ip_makh;
	private JTextField ip_tenkh;
	private JTextField ip_giagio;
	private JTextField ip_giohat;
	private JTextField ip_thanhtien;
	private JPanel pn_datphong ;
	private JPanel pn_phong;
	private JLabel lb_maphong;
	private JLabel lb_tenphong;
	JComboBox cb_loaiphong;
	private JPanel pn_thucdon;
	private JButton btn_adddv;
	private JTextField ip_madv;
	private Timer timer;
	private JPanel pn_danhsachphong;
	private MyButton btn_tinhgio;
	private MyButton btn_ketthuc;
	private JLabel lb_chonkhachkhang;
	private JSpinner ip_soluong;
	private JLabel lb_giovao;
	private PhieuIn_DAO phieuIn_DAO;
	private NhanVien_Dao nv_dao=new NhanVien_Dao();
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private DatPhong_DAO dp_dao=new DatPhong_DAO();
	private Phong_DAO phong_dao=new Phong_DAO();
	private dichvuphong_dao dvp=new dichvuphong_dao();
	private Hoadondv_dao hddv_dao=new Hoadondv_dao();
	private Chitiethoadondv_dao cthddv=new Chitiethoadondv_dao();
	private ArrayList<E_inhoadon> listhoadon;
	private ArrayList<Chitiethoadondv> listdv;
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	private ImageIcon url=new ImageIcon(getClass().getClassLoader().getResource("image/singing.png"));
	private JButton btn_baotri;
	

	/**
	 * Create the panel.
	 */
	public Quanlyphonghat_2(int manv,String nameUser) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1534,756);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 557, 736);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.textHighlight);
		panel_3.setBounds(0, 0, 557, 95);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lb_tenphong = new JLabel("T\u00EAn ph\u00F2ng");
		lb_tenphong.setFont(new Font("Dialog", Font.BOLD, 20));
		lb_tenphong.setForeground(new Color(255, 255, 255));
		lb_tenphong.setBounds(115, 10, 169, 28);
		panel_3.add(lb_tenphong);
		
		btn_tinhgio = new MyButton(new Color(204, 255, 255),new Color(51, 153, 255),new Color(51, 51, 255));
		btn_tinhgio.setText("Tính giờ");
		btn_tinhgio.setRadius(15);
		btn_tinhgio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/play2.png")));
		btn_tinhgio.setForeground(new Color(0, 0, 0));
		btn_tinhgio.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_tinhgio.setBounds(10, 48, 132, 38);
		panel_3.add(btn_tinhgio);
		
		 btn_ketthuc = new  MyButton(new Color(204, 255, 255),new Color(51, 153, 255),new Color(51, 51, 255));
		 btn_ketthuc.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/stop-button.png")));
		btn_ketthuc.setText("Kết Thúc");
		btn_ketthuc.setRadius(15);
		btn_ketthuc.setForeground(new Color(0, 0, 0));
		btn_ketthuc.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_ketthuc.setBounds(152, 48, 132, 38);
		panel_3.add(btn_ketthuc);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u1EDD v\u00E0o");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(294, 48, 84, 38);
		panel_3.add(lblNewLabel_1);
		
		lb_giovao = new JLabel("");
		lb_giovao.setFont(new Font("Dialog", Font.BOLD, 12));
		lb_giovao.setForeground(new Color(255, 255, 255));
		lb_giovao.setBounds(390, 48, 157, 38);
		panel_3.add(lb_giovao);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lo\u1EA1i Ph\u00F2ng");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(294, 10, 84, 28);
		panel_3.add(lblNewLabel_1_1);
		
		 cb_loaiphong = new JComboBox();
		 cb_loaiphong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb_loaiphong.setBackground(new Color(255, 255, 255));
		cb_loaiphong.setModel(new DefaultComboBoxModel(new String[] {"Th\u01B0\u1EDDng", "Vip"}));
		cb_loaiphong.setBounds(390, 10, 157, 28);
		panel_3.add(cb_loaiphong);
		
		 lb_maphong = new JLabel("Mã");
		lb_maphong.setForeground(new Color(255, 255, 255));
		lb_maphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_maphong.setBounds(10, 10, 62, 28);
		panel_3.add(lb_maphong);
		
		JLabel lblNewLabel_9 = new JLabel("/");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(82, 10, 27, 28);
		panel_3.add(lblNewLabel_9);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(0, 96, 557, 640);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(0, 0, 557, 64);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		ip_tendv = new JTextField();
		ip_tendv.setEditable(false);
		ip_tendv.setBounds(80, 32, 178, 30);
		panel_5.add(ip_tendv);
		ip_tendv.setColumns(10);
		
		ip_dongia = new JTextField();
		ip_dongia.setEditable(false);
		ip_dongia.setBounds(268, 32, 117, 30);
		panel_5.add(ip_dongia);
		ip_dongia.setColumns(10);
		
		
	    JSpinner spinner = new JSpinner(); 
		ip_soluong = new JSpinner();
		ip_soluong.setBounds(395, 32, 60, 30);
		panel_5.add(ip_soluong);
		
		 btn_adddv = new JButton("");
		 btn_adddv.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/adddv.png")));
		 btn_adddv.setBackground(new Color(0, 255, 64));
		 
		btn_adddv.setBounds(486, 0, 71, 30);
		panel_5.add(btn_adddv);
		
		JButton btn_deletedv = new JButton("");
		btn_deletedv.setForeground(new Color(255, 255, 255));
		btn_deletedv.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/cancel.png")));
		btn_deletedv.setBackground(new Color(255, 0, 0));
		btn_deletedv.setBounds(486, 32, 71, 30);
		panel_5.add(btn_deletedv);
		
		JLabel lblNewLabel_3 = new JLabel("M\u1EB7t h\u00E0ng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(80, 0, 178, 28);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(268, 0, 117, 28);
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(395, 0, 60, 30);
		panel_5.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("M\u00E3");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(10, 0, 60, 30);
		panel_5.add(lblNewLabel_5_1);
		
		ip_madv = new JTextField();
		ip_madv.setEditable(false);
		ip_madv.setBounds(10, 32, 60, 30);
		panel_5.add(ip_madv);
		ip_madv.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(0, 63, 557, 251);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		String [] headers = "STT; Mã hàng; Tên mặt hàng; Đơn giá; Số lượng".split(";");
		tableModel=new DefaultTableModel(headers,0);
		table = new JTable(tableModel);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setBackground(new Color(102, 204, 255));
		scrollPane.setViewportView(table);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		table.getTableHeader().setBackground(new Color(102, 204, 255));
		scrollPane.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(102, 204, 255));
		panel_6.setBounds(0, 321, 557, 318);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("M\u00C3 KH");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(221, 10, 101, 38);
		panel_6.add(lblNewLabel_7);
		
		ip_makh = new JTextField();
		ip_makh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ip_makh.setEditable(false);
		ip_makh.setBounds(332, 10, 177, 38);
		panel_6.add(ip_makh);
		ip_makh.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("T\u00CAN KH");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7_1.setBounds(221, 70, 101, 38);
		panel_6.add(lblNewLabel_7_1);
		
		ip_tenkh = new JTextField();
		ip_tenkh.setEditable(false);
		ip_tenkh.setColumns(10);
		ip_tenkh.setBounds(332, 70, 215, 38);
		panel_6.add(ip_tenkh);
		
		JLabel lblNewLabel_7_4 = new JLabel("GI\u00C1 GI\u1EDC");
		lblNewLabel_7_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7_4.setBounds(221, 130, 101, 38);
		panel_6.add(lblNewLabel_7_4);
		
		ip_giagio = new JTextField();
		ip_giagio.setEditable(false);
		ip_giagio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ip_giagio.setColumns(10);
		ip_giagio.setText("0");
		ip_giagio.setBounds(332, 130, 215, 38);
		panel_6.add(ip_giagio);
		
		JLabel lblNewLabel_7_2 = new JLabel("THỜI GIAN");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7_2.setBounds(221, 190, 101, 38);
		panel_6.add(lblNewLabel_7_2);
		
		ip_giohat = new JTextField();
		ip_giohat.setEditable(false);
		ip_giohat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ip_giohat.setColumns(10);
		ip_giohat.setBounds(332, 190, 215, 38);
		panel_6.add(ip_giohat);
		
		JLabel lblNewLabel_7_3 = new JLabel("Tiền phòng");
		lblNewLabel_7_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7_3.setBounds(221, 270, 101, 38);
		panel_6.add(lblNewLabel_7_3);
		
		ip_thanhtien = new JTextField();
		ip_thanhtien.setEditable(false);
		ip_thanhtien.setForeground(new Color(255, 0, 0));
		ip_thanhtien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ip_thanhtien.setColumns(10);
		ip_thanhtien.setBounds(332, 270, 153, 38);
		panel_6.add(ip_thanhtien);
		
		JButton btn_thutien = new JButton("Thu ti\u1EC1n");
		btn_thutien.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/invoice.png")));
		btn_thutien.setBackground(new Color(0, 255, 64));
		
		btn_thutien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(phong_dao.getPhong(lb_maphong.getText().trim()).getTrangThai().equalsIgnoreCase("Còn trống")) {
					JOptionPane.showMessageDialog(null, "Phòng chưa được đặt");
				}
				else if(phong_dao.getPhong(lb_maphong.getText().trim()).getTrangThai().equalsIgnoreCase("Bảo trì")) {
					JOptionPane.showMessageDialog(null, "Phòng đang bảo trì");
				}
				
			else if(ip_giohat.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng kết thúc tính giờ phòng");
				}
			else if(Integer.parseInt(ip_giohat.getText())<=0) {
				JOptionPane.showMessageDialog(null, "Phòng sử dụng chưa đủ 1 phút ");
				
				
			}
				else {
					listhoadon=new ArrayList<E_inhoadon>();
				double tiendichvu=0;
				NumberFormat formatter = new DecimalFormat("#0.0"); 
				
				for(int i=0;i<tableModel.getRowCount();i++) {
					tiendichvu+=Double.parseDouble(tableModel.getValueAt(i, 3).toString())* Integer.parseInt(tableModel.getValueAt(i, 4).toString());
					E_inhoadon hoadon=new E_inhoadon(tableModel.getValueAt(i, 2).toString(),Double.parseDouble(tableModel.getValueAt(i, 3).toString()) , Integer.parseInt(tableModel.getValueAt(i, 4).toString()),tiendichvu);
				listhoadon.add(hoadon);
				}
				 phieuIn_DAO=new PhieuIn_DAO();
				new PhieuThutien(phong_dao.getPhong(lb_maphong.getText()),listhoadon, tiendichvu, Double.parseDouble(ip_thanhtien.getText()),Integer.parseInt(ip_giohat.getText()),Double.parseDouble(ip_giagio.getText())/60,Integer.parseInt(ip_makh.getText()),manv).setVisible(true);
			}
			}
		});
		btn_thutien.setForeground(new Color(255, 255, 255));
		btn_thutien.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_thutien.setBounds(10, 10, 201, 38);
		panel_6.add(btn_thutien);
		
		 btn_baotri = new JButton("Bảo trì phòng");
		btn_baotri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isNumeric(lb_maphong.getText())&&phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Còn trống")) {
					try {
						phong_dao.updateTrangThaiPhong(lb_maphong.getText(), "Bảo trì");
						JOptionPane.showMessageDialog(null,"Phòng đã chuyển sang trạng thái bảo trì phòng");
						pn_datphong.removeAll();
				 		pn_datphong.add(new Phong_Ban_UI(lb_maphong, lb_tenphong, cb_loaiphong));
						pn_datphong.repaint();
						pn_datphong.revalidate();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				else if(isNumeric(lb_maphong.getText())&&phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Bảo trì")) {
					try {
						phong_dao.updateTrangThaiPhong(lb_maphong.getText(), "Còn trống");
						JOptionPane.showMessageDialog(null,"Phòng đã hủy bảo trì bảo trì phòng");
						pn_datphong.removeAll();
				 		pn_datphong.add(new Phong_Ban_UI(lb_maphong, lb_tenphong, cb_loaiphong));
						pn_datphong.repaint();
						pn_datphong.revalidate();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				else if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
		 			JOptionPane.showMessageDialog(null, "Phòng đang được sử dụng");
		 		}
				else {
					JOptionPane.showMessageDialog(null,"Chọn phòng muốn bảo trì phòng");
				}
				
			}
		});
		btn_baotri.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/repair.png")));
		btn_baotri.setBackground(new Color(255, 128, 0));
		btn_baotri.setForeground(new Color(255, 255, 255));
		btn_baotri.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_baotri.setBounds(10, 106, 201, 38);
		panel_6.add(btn_baotri);
		
		JButton btnNewButton_2_2 = new JButton("Đổi giá phòng");
		btnNewButton_2_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/exchange.png")));
		btnNewButton_2_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isNumeric(lb_maphong.getText())) {
					JFrame frame =new Doigiaphong_ui(lb_maphong.getText());
					frame.setVisible(true);
				}
				else if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
		 			JOptionPane.showMessageDialog(null, "Phòng đang được sử dụng");
		 		}
				else {
					JOptionPane.showMessageDialog(null,"Chọn phòng muốn thay đổi giá phòng");
				}
			}
		});
		btnNewButton_2_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_2.setBounds(10, 58, 201, 38);
		panel_6.add(btnNewButton_2_2);
		
		JButton btn_huyphong = new JButton("Hủy Phòng");
		btn_huyphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Bảo trì")) {
		 			JOptionPane.showMessageDialog(null, "Phòng đang được bảo trì");
		 		}
				else if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Còn trống")) {
		 			JOptionPane.showMessageDialog(null, "Phòng chưa được sử dụng");
		 		}
				else if(isNumeric(lb_maphong.getText())) {
					clear(phong_dao.getPhong(lb_maphong.getText()));
					JOptionPane.showMessageDialog(null,"Hủy phòng thành công");
				
					pn_datphong.removeAll();
			 		pn_datphong.add(new Phong_Ban_UI(lb_maphong, lb_tenphong, cb_loaiphong));
					pn_datphong.repaint();
					pn_datphong.revalidate();
				} 
				else {
					JOptionPane.showMessageDialog(null,"Chọn phòng muốn hủy");
				}
				
			}
		});
		btn_huyphong.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/remove.png")));
		btn_huyphong.setBackground(new Color(255, 128, 128));
		btn_huyphong.setForeground(new Color(255, 255, 255));
		btn_huyphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_huyphong.setBounds(10, 153, 201, 38);
		panel_6.add(btn_huyphong);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(10, 258, 537, 2);
		panel_6.add(panel_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(508, 10, 39, 38);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		 lb_chonkhachkhang = new JLabel("");
		 lb_chonkhachkhang.setBackground(new Color(255, 255, 255));
		 lb_chonkhachkhang.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(!isNumeric(lb_maphong.getText())) {
		 			JOptionPane.showMessageDialog(null,"Hãy chọn phòng muốn tính giờ");
		 		}
		 		else if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
		 			JOptionPane.showMessageDialog(null, "Phòng đã có người sử dụng");
		 		}
		 		else {
		 			JFrame kh_frame=new Themkhachhang(ip_makh,ip_tenkh);
			 		kh_frame.setVisible(true);
		 		}
		 		
		 	}
		 });
		 lb_chonkhachkhang.setHorizontalAlignment(SwingConstants.CENTER);
		 lb_chonkhachkhang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/people.png")));
		lb_chonkhachkhang.setBounds(0, 0, 39, 38);
		panel_7.add(lb_chonkhachkhang);
		
		JLabel lblNewLabel = new JLabel("VND");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(495, 270, 52, 38);
		panel_6.add(lblNewLabel);
		
		JButton btn_xoatrang = new JButton("Xóa trắng");
		btn_xoatrang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/archeology.png")));
		btn_xoatrang.setBackground(new Color(255, 128, 128));
		btn_xoatrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ip_giohat.setText("");
				ip_thanhtien.setText("");
			
				
			}
		});
		btn_xoatrang.setForeground(new Color(255, 255, 255));
		btn_xoatrang.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_xoatrang.setBounds(10, 202, 201, 38);
		panel_6.add(btn_xoatrang);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(577, 10, 947, 41);
		add(panel_1);
		panel_1.setLayout(null);
		
		 pn_phong = new JPanel();
		
		pn_phong.setBackground(SystemColor.textHighlight);
		pn_phong.setBounds(0, 0, 205, 41);
		panel_1.add(pn_phong);
		
		JLabel lblNewLabel_6 = new JLabel("Ph\u00F2ng / B\u00E0n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 26));
		pn_phong.add(lblNewLabel_6);
		
		 pn_thucdon = new JPanel();
		
		pn_thucdon.setBackground(Color.ORANGE);
		pn_thucdon.setBounds(205, 0, 205, 41);
		panel_1.add(pn_thucdon);
		
		JLabel lblNewLabel_6_1 = new JLabel("Th\u1EF1c \u0111\u01A1n");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		pn_thucdon.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_10 = new JLabel("QU\u1EA2N L\u00DD PH\u00D2NG");
		lblNewLabel_10.setBackground(SystemColor.window);
		lblNewLabel_10.setForeground(SystemColor.textHighlight);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(420, 0, 517, 41);
		panel_1.add(lblNewLabel_10);

		pn_danhsachphong=new Phong_Ban_UI(lb_maphong, lb_tenphong, cb_loaiphong);
		
		 pn_datphong = new JPanel();
		pn_datphong.setBounds(577, 50, 947, 696);
		add(pn_datphong);
		pn_datphong.setLayout(null);
		
		pn_datphong.add(pn_danhsachphong);
		
		 pn_phong.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		pn_datphong.removeAll();
			 		pn_datphong.add(pn_danhsachphong);
					pn_datphong.repaint();
					pn_datphong.revalidate();
			 		
			 	}
			 });
		 pn_thucdon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					pn_datphong.removeAll();
					pn_datphong.add(new Thucdon_UI(ip_madv,ip_tendv, ip_dongia));
					pn_datphong.repaint();
					pn_datphong.revalidate();
				}
			});

		 
		 btn_tinhgio.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		Phong phong=phong_dao.getPhong(lb_maphong.getText());
			 		if(phong.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
						JOptionPane.showMessageDialog(null, "Phòng đang sử dụng");
					} else if(phong.getTrangThai().equalsIgnoreCase("Bảo trì")) {
						JOptionPane.showMessageDialog(null, "Phòng đang bảo trì");
					} else {
						DatPhong dp = new DatPhong();
			 			tinhGio();
				 		dp.setMaPhong(Integer.parseInt(lb_maphong.getText()));
				 		dp.setMaNV(manv);
				 		dp_dao.addDatPhong(dp);
					}
			 	}
			 });
		 
		 btn_ketthuc.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {		 				
			 		if(!isNumeric(lb_maphong.getText())) {
			 			JOptionPane.showMessageDialog(null,"Hãy chọn phòng muốn tính giờ");
			 		}
			 		else if(lb_giovao.getText().equalsIgnoreCase("")) {
			 			JOptionPane.showMessageDialog(null,"Phòng chưa được đặt");
			 		}
			 		else if(phong_dao.getPhong(lb_maphong.getText()).getGiobatdau()!=null) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
						String giovao  = dateFormat.format(phong_dao.getPhong(lb_maphong.getText()).getGiobatdau());
						Timestamp time=new Timestamp(System.currentTimeMillis());
						String timenow=dateFormat.format(time);
						int gio=Integer.parseInt(demGio(giovao, timenow)[0]);
						int phut=Integer.parseInt(demGio(giovao, timenow)[1]);
						ip_giohat.setText(gio*60+phut+"");
						
					}
					else {
						ip_giohat.setText("");
					}
//					HoaDon hd=new HoaDon();
//					hd.setMaKH(Integer.parseInt(ip_makh.getText()));
//					hd.setMaPhong(Integer.parseInt(lb_maphong.getText()));
//					hd.setNgayDat(phong_dao.getPhong(lb_maphong.getText()).getGiobatdau());
// 				    hd.setTongTienPhong(Double.parseDouble(ip_thanhtien.getText()));
// 				   double x=0;
// 				   
// 					for(int i=0;i<tableModel.getRowCount();i++) {
// 						x+=Double.parseDouble(tableModel.getValueAt(i,3).toString())*Integer.parseInt(tableModel.getValueAt(i,4).toString());
// 					}
// 					hd.setTongTienDV(x);
//		 			hd.setMaNV(manv);
//		 			hd_dao.addHoaDon(hd);	
					
			 	}
			 });
		 
		 PropertyChangeListener l = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				ip_giohat.setText("");
				ip_thanhtien.setText("");

				tableModel.setRowCount(0);
				gettimephong(lb_maphong.getText());
				int x=phong_dao.getPhong(lb_maphong.getText()).getGiagio();
				ip_giagio.setText(x+"");
				if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
					ip_makh.setText(phong_dao.getPhong(lb_maphong.getText()).getMakh()+"");
					ip_tenkh.setText(kh_dao.getKhachHang(phong_dao.getPhong(lb_maphong.getText()).getMakh()).getTenKH()+"");
					adddichvuphong(Integer.parseInt(lb_maphong.getText()));
					
				}
				else {
					ip_makh.setText("");
					ip_tenkh.setText("");
				}
				if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
					btn_baotri.setEnabled(false);
				}
				else if(phong_dao.getPhong(lb_maphong.getText()).getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
					btn_baotri.setText("Hủy bảo trì");
					btn_baotri.setEnabled(true);
					
				}
				else {
					btn_baotri.setText("Bảo trì phòng");
					btn_baotri.setEnabled(true);
					
				}

				
			}
		 };
		 lb_maphong.addPropertyChangeListener("text",l);
		 
		 
		 
		 
		 btn_adddv.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(ip_madv.getText().equalsIgnoreCase("")||ip_dongia.getText().equalsIgnoreCase("")) {
					 JOptionPane.showMessageDialog(null, "Chọn dịch vụ muốn thêm");
				 }
				 else if((int)ip_soluong.getValue()<1) {
					JOptionPane.showMessageDialog(null, "Số lượng phải nhiều hơn 0");
				 } 
				 
				 else if((int)ip_soluong.getValue()>20) {
					 JOptionPane.showMessageDialog(null, "Số lượng quá nhiều");
				 }
				 
				 else {
					 	int maHang = Integer.parseInt(ip_madv.getText());
				 		String ten = ip_tendv.getText();
				 		double donGia = Double.parseDouble(ip_dongia.getText());
				 		int soLuong = (Integer)ip_soluong.getValue();
				 		int rowcount=table.getRowCount();
				 		Object [] row= {rowcount++, maHang, ten, donGia, soLuong};
						tableModel.addRow(row);
						ip_madv.setText("");
						ip_tendv.setText("");
						ip_dongia.setText("");
						ip_soluong.setValue(1);
				 }
			 	}
			 });
		 btn_deletedv.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		xoa();
			 	}
			 });
		 
		 
		 
		 ip_giohat.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				int giagiohat=Integer.parseInt(ip_giagio.getText());
				int thoigianhat=Integer.parseInt(ip_giohat.getText());
//				NumberFormat formatter = new DecimalFormat("##.#");     
				
				ip_thanhtien.setText(""+(giagiohat/60)*thoigianhat);
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		 

		 
	}
	
	
	
	
	//Sự kiện xóa
	public boolean xoa() {
		if (this.table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Ban phải chọn dòng cần xoá");
			return false;
		}
		else {
			int row = table.getSelectedRow();
			tableModel.removeRow(row);
			JOptionPane.showMessageDialog(this, "Xoá mặt hàng thành công");
		}
		return false;
	}
	
	//Sự kiện tính giờ
		public boolean tinhGio() {
			if(lb_maphong.getText().equalsIgnoreCase("Mã")) {
				JOptionPane.showMessageDialog(this, "Cần chọn phòng hoặc khách hàng");
				return false;
	 		}
			else if(ip_makh.getText().trim().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Cần chọn phòng hoặc khách hàng");
				return false;
			}
			else {
				getTime();
		 		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 	    Date parsedDate;
				//						parsedDate = dateFormat.parse(System.currentTimeMillis());
										Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
								 		hddv_dao.addhoadondv(Integer.parseInt(lb_maphong.getText()),timestamp);
		 	    
		 		try {
		 			Timestamp time=new Timestamp(System.currentTimeMillis());
		 			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
		 			String timenow=dt.format(time);
					phong_dao.datPhong(lb_maphong.getText(),Integer.parseInt(ip_makh.getText()), "Đang sử dụng", timenow);
					pn_datphong.removeAll();
			 		pn_datphong.add(new Phong_Ban_UI(lb_maphong, lb_tenphong, cb_loaiphong));
					pn_datphong.repaint();
					pn_datphong.revalidate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 	
		 		
		 		for(int i=0;i<tableModel.getRowCount();i++) {
		 			Chitiethoadondv cthddv=new Chitiethoadondv(Integer.parseInt(tableModel.getValueAt(i, 1).toString()),hddv_dao.gethddichvu(Integer.parseInt(lb_maphong.getText())).getMaHDDV(),Integer.parseInt(tableModel.getValueAt(i, 4).toString()));
		 			Quanlyphonghat_2.this.cthddv.addchitiethoadondv(cthddv);
		 		}
		 		return true;
			}
		}
	
	//Sự kiện lấy giờ
	public void getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		lb_giovao.setText(dtf.format(now));
	}
	
	public void adddichvuphong(int maphong) {
		int i=1;
		ArrayList<dichvuphong> dv=(ArrayList<dichvuphong>)dvp.getdichvu(maphong);
		for (dichvuphong dvp : dv) {
			Object[] row= {i++,dvp.getMadv(),dvp.getTenDV(),dvp.getDongia(),dvp.getSoluong()};
			tableModel.addRow(row);
		}
	}
	public void gettimephong(String maphong) {
		Phong phong=phong_dao.getPhong(maphong);
		if(phong.getGiobatdau()!=null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String string  = dateFormat.format(phong.getGiobatdau());
			lb_giovao.setText(string);
			
		}
		else {
			lb_giovao.setText("");
			
		}
	}
	public String[] demGio(String gioden,String giodi)
	{
		String dateStart=gioden;
		String dateStop=giodi;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");

		Date d1 = null;
		Date d2 = null;

		try {
		d1 = format.parse(dateStart);
		d2 = format.parse(dateStop);

		long diff = d2.getTime() - d1.getTime();
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		String[] x= {diffHours+"",diffMinutes+""};

		return x;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"lỗi đếm giờ: "+e.toString());
		return null;
		}
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	public void clear(Phong phong) {
		for(int i=0;i<dvp.getdichvu(phong.getMaPhong()).size();i++) {
				try {
				dvp.deletedichvuphong1(hddv_dao.gethddichvu(phong.getMaPhong()).getMaHDDV());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				try {
				dvp.deletedichvuphong2(phong.getMaPhong()+"");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				}
		try {
			phong_dao.cleardatphong(phong.getMaPhong()+"");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			phong_dao.updateTrangThaiPhong(phong.getMaPhong()+"", "Còn Trống");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
