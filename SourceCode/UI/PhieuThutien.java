package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Dao.HoaDon_DAO;
import Dao.Hoadondv_dao;
import Dao.KhachHang_DAO;
import Dao.NhanVien_Dao;
import Dao.Phong_DAO;
import Dao.dichvuphong_dao;
import Entity.E_inhoadon;
import Entity.HoaDon;
import Entity.PhieuIn;
import Entity.Phong;

import javax.swing.ImageIcon;

public class PhieuThutien extends JFrame {
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private JPanel contentPane;
	private JTextField ip_tenkhachhang;
	private JTextField ip_tongtientra;
	private JTextField ip_tienkhachtra;
	private JTextField ip_tientralaikhach;
	private JTextField ip_tongtienphong;
	private JTextField ip_tongtiendv;
	private KhachHang_DAO kh_dao=new KhachHang_DAO();
	private JLabel lb_check;
	private Phong_DAO phong_dao=new Phong_DAO();
	private dichvuphong_dao dvp=new dichvuphong_dao();
	private Hoadondv_dao hdHoadondv_dao=new Hoadondv_dao();
	private NhanVien_Dao nv_dao=new NhanVien_Dao();
	private HoaDon hd=new HoaDon();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PhieuThutien frame = new PhieuThutien();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
////
////	/**
////	 * Create the frame.
////	 */
	public PhieuThutien(Phong phieuIn,ArrayList<E_inhoadon> listhoadon,double tongtiendichvu,double tongtienhat,int giohat,double giaphong,int makh,int manv) {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 950, 138);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lb_thongtinphong = new JLabel(phieuIn.getMaPhong()+"-"+phieuIn.getTenPhong());
		lb_thongtinphong.setHorizontalAlignment(SwingConstants.LEFT);
		lb_thongtinphong.setForeground(new Color(255, 0, 0));
		lb_thongtinphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_thongtinphong.setBounds(73, 10, 159, 38);
		panel.add(lb_thongtinphong);
		
		JLabel lb_titel = new JLabel("Loại phòng :");
		lb_titel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_titel.setBounds(73, 74, 129, 38);
		panel.add(lb_titel);
		
		JLabel lb_mahoadon = new JLabel(phieuIn.getLoaiPhong()+"");
		lb_mahoadon.setForeground(new Color(255, 0, 0));
		lb_mahoadon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_mahoadon.setBounds(209, 74, 142, 38);
		panel.add(lb_mahoadon);
		
		JLabel lb_thongtinphong_1_1 = new JLabel("Gi\u1EDD V\u00E0o :");
		lb_thongtinphong_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_thongtinphong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1.setBounds(518, 10, 92, 38);
		panel.add(lb_thongtinphong_1_1);
		
		JLabel lb_giovao = new JLabel(phieuIn.getGiobatdau()+"");
		lb_giovao.setForeground(new Color(255, 0, 0));
		lb_giovao.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_giovao.setBounds(627, 10, 313, 38);
		panel.add(lb_giovao);
		
		JLabel lb_thongtinphong_1_1_1 = new JLabel("M\u00E3 KH   :");
		lb_thongtinphong_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_thongtinphong_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1.setBounds(518, 74, 92, 38);
		panel.add(lb_thongtinphong_1_1_1);
		
		JLabel lb_makh = new JLabel(makh+"");
		lb_makh.setForeground(new Color(255, 0, 0));
		lb_makh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_makh.setBounds(627, 74, 313, 38);
		panel.add(lb_makh);
		
		JLabel lblNewLabel_2 = new JLabel("PHI\u1EBEU THU");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 148, 930, 46);
		getContentPane().add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 204, 950, 424);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lb_thongtinphong_1_1_1_1 = new JLabel("T\u00EAn KH  :");
		lb_thongtinphong_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lb_thongtinphong_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1_1.setBounds(65, 10, 189, 38);
		panel_1.add(lb_thongtinphong_1_1_1_1);
		
		JLabel lb_thongtinphong_1_1_1_1_1 = new JLabel("T\u1ED5ng ti\u1EC1n ph\u1EA3i tr\u1EA3   :");
		lb_thongtinphong_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lb_thongtinphong_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1_1_1.setBounds(65, 193, 189, 38);
		panel_1.add(lb_thongtinphong_1_1_1_1_1);
		
		JLabel lb_thongtinphong_1_1_1_1_2 = new JLabel("Ti\u1EC1n kh\u00E1ch tr\u1EA3   :");
		lb_thongtinphong_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lb_thongtinphong_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1_1_2.setBounds(65, 248, 189, 38);
		panel_1.add(lb_thongtinphong_1_1_1_1_2);
		
		JLabel lb_thongtinphong_1_1_1_1_3 = new JLabel("Ti\u1EC1n tr\u1EA3 l\u1EA1i kh\u00E1ch :");
		lb_thongtinphong_1_1_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lb_thongtinphong_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1_1_3.setBounds(65, 313, 189, 38);
		panel_1.add(lb_thongtinphong_1_1_1_1_3);
		
		ip_tenkhachhang = new JTextField();
		ip_tenkhachhang.setText(kh_dao.getKhachHang(makh).getTenKH());
		ip_tenkhachhang.setEditable(false);
		ip_tenkhachhang.setBounds(276, 10, 604, 38);
		panel_1.add(ip_tenkhachhang);
		ip_tenkhachhang.setColumns(10);
		
		ip_tongtientra = new JTextField();
		ip_tongtientra.setEditable(false);
		ip_tongtientra.setHorizontalAlignment(SwingConstants.RIGHT);
		ip_tongtientra.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		ip_tongtientra.setForeground(new Color(255, 0, 0));
		ip_tongtientra.setColumns(10);
		ip_tongtientra.setBounds(276, 193, 604, 38);
		panel_1.add(ip_tongtientra);
		
		ip_tienkhachtra = new JTextField();
		ip_tienkhachtra.setHorizontalAlignment(SwingConstants.RIGHT);
		ip_tienkhachtra.setFont(new Font("Tahoma", Font.BOLD, 20));
		ip_tienkhachtra.setForeground(new Color(0, 0, 255));
		ip_tienkhachtra.setColumns(10);
		ip_tienkhachtra.setBounds(276, 249, 604, 38);
		panel_1.add(ip_tienkhachtra);
		
		ip_tientralaikhach = new JTextField();
		ip_tientralaikhach.setEditable(false);
		ip_tientralaikhach.setHorizontalAlignment(SwingConstants.RIGHT);
		ip_tientralaikhach.setFont(new Font("Tahoma", Font.BOLD, 20));
		ip_tientralaikhach.setForeground(new Color(0, 0, 255));
		ip_tientralaikhach.setColumns(10);
		ip_tientralaikhach.setBounds(276, 314, 604, 38);
		panel_1.add(ip_tientralaikhach);
		
		JLabel lb_thongtinphong_1_1_1_1_1_1 = new JLabel("Th\u00E0nh Ti\u1EC1n :");
		lb_thongtinphong_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_thongtinphong_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1_1_1_1.setBounds(558, 376, 143, 38);
		panel_1.add(lb_thongtinphong_1_1_1_1_1_1);
		
		JLabel lb_thanhtien = new JLabel("");
		lb_thanhtien.setForeground(new Color(255, 0, 0));
		lb_thanhtien.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_thanhtien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_thanhtien.setBounds(711, 376, 169, 38);
		panel_1.add(lb_thanhtien);
		
		JLabel lb_thongtinphong_1_1_1_1_1_2 = new JLabel("T\u1ED5ng ti\u1EC1n ph\u00F2ng  :");
		lb_thongtinphong_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lb_thongtinphong_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1_1_1_2.setBounds(65, 68, 189, 38);
		panel_1.add(lb_thongtinphong_1_1_1_1_1_2);
		
		JLabel lb_thongtinphong_1_1_1_1_1_3 = new JLabel("T\u1ED5ng ti\u1EC1n d\u1ECBch v\u1EE5   :");
		lb_thongtinphong_1_1_1_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lb_thongtinphong_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtinphong_1_1_1_1_1_3.setBounds(65, 134, 189, 38);
		panel_1.add(lb_thongtinphong_1_1_1_1_1_3);
		
		ip_tongtienphong = new JTextField();
		ip_tongtienphong.setText(tongtienhat+"");
		ip_tongtienphong.setHorizontalAlignment(SwingConstants.RIGHT);
		ip_tongtienphong.setForeground(Color.BLUE);
		ip_tongtienphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		ip_tongtienphong.setEditable(false);
		ip_tongtienphong.setColumns(10);
		ip_tongtienphong.setBounds(276, 68, 604, 38);
		panel_1.add(ip_tongtienphong);
		
		ip_tongtiendv = new JTextField();
		ip_tongtiendv.setText(tongtiendichvu+"");
		ip_tongtiendv.setHorizontalAlignment(SwingConstants.RIGHT);
		ip_tongtiendv.setForeground(Color.BLUE);
		ip_tongtiendv.setFont(new Font("Tahoma", Font.BOLD, 20));
		ip_tongtiendv.setEditable(false);
		ip_tongtiendv.setColumns(10);
		ip_tongtiendv.setBounds(276, 135, 604, 38);
		panel_1.add(ip_tongtiendv);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(10, 623, 930, 67);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_thoat = new JButton("Tho\u00E1t");
		btn_thoat.setBackground(new Color(255, 255, 255));
		btn_thoat.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/logout.png")));
		btn_thoat.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_thoat.setBounds(758, 13, 162, 54);
		panel_2.add(btn_thoat);
		
		JButton btn_xoatrang = new JButton("X\u00F3a tr\u1EAFng");
		btn_xoatrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoatrang();
			}
		});
		btn_xoatrang.setBackground(new Color(255, 255, 255));
		btn_xoatrang.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/return.png")));
		btn_xoatrang.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btn_xoatrang.setBounds(565, 13, 162, 54);
		panel_2.add(btn_xoatrang);
		
		JButton btn_luu = new JButton("L\u01B0u phi\u1EBFu");
		btn_luu.setBackground(new Color(255, 255, 255));
		btn_luu.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/floppydisk.png")));
		
		btn_luu.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btn_luu.setBounds(361, 13, 174, 54);
		panel_2.add(btn_luu);
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 950, 700 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds ( ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		
		
		
		 ip_tienkhachtra.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				if(checkregex()) {
					ip_tientralaikhach.setText(String.valueOf(tinhtienthua()));
				}
				else {
					ip_tientralaikhach.setText(0+"");
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(checkregex()) {
					ip_tientralaikhach.setText(String.valueOf(tinhtienthua()));
				}
				else {
					ip_tientralaikhach.setText(0+"");
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				if(checkregex()) {
					ip_tientralaikhach.setText(String.valueOf(tinhtienthua()));
				}
				else {
					ip_tientralaikhach.setText(0+"");
				}
				
			}
		});
		
		 ip_tongtientra.setText(Double.parseDouble(ip_tongtienphong.getText())+Double.parseDouble(ip_tongtiendv.getText())+"");	
		 lb_thanhtien.setText(Double.parseDouble(ip_tongtienphong.getText())+Double.parseDouble(ip_tongtiendv.getText())+"");
		 
		 JLabel lblNewLabel = new JLabel("VND");
		 lblNewLabel.setForeground(new Color(255, 0, 0));
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblNewLabel.setBounds(890, 376, 50, 38);
		 panel_1.add(lblNewLabel);
		 
		  lb_check = new JLabel("");
		 lb_check.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lb_check.setForeground(new Color(255, 0, 0));
		 lb_check.setBounds(627, 285, 254, 32);
		 lb_check.setVisible(false);
		 panel_1.add(lb_check);
		 
		 
		
		 btn_luu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ip_tienkhachtra.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Nhập số tiền khách trả");
					}
					else {	
			 			Printer_ver2(phieuIn,String.valueOf(phieuIn.getMaPhong()),nv_dao.getNhanVien(manv).getTenNV(), listhoadon,giohat,giaphong,makh,manv);
			 			
			 			
					}
					
				}
			});
		 
	}
	
	public void xoatrang() {
		ip_tienkhachtra.setText("");
		ip_tientralaikhach.setText("");
	}
	public double tinhtienthua() {
		if(ip_tienkhachtra.getText().trim().equalsIgnoreCase("")) {
			return Double.parseDouble("0")-Double.parseDouble(ip_tongtientra.getText());
		}
		return Double.parseDouble(ip_tienkhachtra.getText())-Double.parseDouble(ip_tongtientra.getText());
		
	}
	public void Printer_ver2(Phong phieuIn,String maphong,String namenv,ArrayList<E_inhoadon> listhoadon,int sogiohat,double giaphong,int makh,int manv) {
		PrinterJob printerJob=PrinterJob.getPrinterJob();
		printerJob.setJobName("Print Record");
		printerJob.setPrintable(new Printable() {
			
			@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
				NumberFormat formatter = new DecimalFormat("#0.0"); 
				
				 
				hd.setMaKH(makh);
				hd.setMaPhong(phieuIn.getMaPhong());
				hd.setNgayDat(phong_dao.getPhong(phieuIn.getMaPhong()+"").getGiobatdau());
				    hd.setTongTienPhong(Double.parseDouble(ip_tongtienphong.getText()));
					hd.setTongTienDV(Double.parseDouble(ip_tongtiendv.getText()));
	 			hd.setMaNV(manv);
	 			hd_dao.addHoaDon(hd);
	 			hd_dao.deletehoadonnull();
	 			
	 			
	 			for(int i=0;i<dvp.getdichvu(phieuIn.getMaPhong()).size();i++) {
	 				try {
						dvp.deletedichvuphong1(hdHoadondv_dao.gethddichvu(phieuIn.getMaPhong()).getMaHDDV());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	 				try {
						dvp.deletedichvuphong2(phieuIn.getMaPhong()+"");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	 				}
				
	 			try {
					phong_dao.cleardatphong(phieuIn.getMaPhong()+"");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 
//			      ImageIcon icon=new ImageIcon("C:UsersccsDocumentsNetBeansProjectsvideo TestPOSInvoicesrcposinvoicemylogo.jpg"); 
			      int result = NO_SUCH_PAGE;    
			        if (pageIndex == 0) {                    
			        
			            Graphics2D g2d = (Graphics2D) graphics;                    
			            double width = pageFormat.getImageableWidth();                               
			            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 



			          //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
			        
			        try{
			            int y=20;
			            int yShift = 10;
			            int headerRectHeight=15;
			           // int headerRectHeighta=40;
			            
			            String timeStamp = new SimpleDateFormat("yyyy//MM//dd HH:mm:ss").format(Calendar.getInstance().getTime());
			             String line="-----------------------";
			             
			            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
			            g2d.drawString("        "+"HÓA ĐƠN"+"        ",25,y);y+=yShift;
			            g2d.drawString(line+line,12,y);y+=yShift;
			            g2d.drawString("            "+timeStamp+"            ",12,y);y+=yShift;
			            g2d.drawString("                     "+"NO"+hd_dao.getmahoadon().getMaHD()+"                     ",12,y);y+=yShift;
			            g2d.drawString(""+"69 Trần Duy Hưng, Trung Hoà, Cầu Giấy, Hà Nội"+"",12,y);y+=yShift;
			            g2d.drawString("          www.facebook.com/0123456789 ",12,y);y+=yShift;
			            g2d.drawString("                  0348968518                 ",12,y);y+=yShift;
			            g2d.drawString("---------------------------------------------",12,y);y+=headerRectHeight;

			            g2d.drawString(" Item Name                  Price   ",10,y);y+=yShift;
			            g2d.drawString("---------------------------------------------",10,y);y+=headerRectHeight;
			            
			            g2d.drawString(" "+"Gio su dung phong hat"+"                            ",10,y);y+=yShift;
			            
			            
			            g2d.drawString("      "+sogiohat+"Phút"+" * "+formatter.format(giaphong),10,y);
			            
			            g2d.drawString(formatter.format(sogiohat*giaphong)+"",160,y);y+=yShift;
			            
			            
			            for(int i=0;i<listhoadon.size(); i++)
			            {
			            g2d.drawString(" "+listhoadon.get(i).getTendv()+"                            ",10,y);y+=yShift;
			            g2d.drawString("      "+listhoadon.get(i).getSoluong()+" * "+listhoadon.get(i).getDongia(),10,y);
			            g2d.drawString(listhoadon.get(i).getTongtien()+"",160,y);y+=yShift;
			            }
			          
			            g2d.drawString("---------------------------------------------",10,y);y+=yShift;
			            double x=0;
			            for(int i=0;i<listhoadon.size(); i++) {
			            	x+=listhoadon.get(i).getTongtien();
			            }
			            
			            
			            g2d.drawString(" Total amount:               "+formatter.format(x+sogiohat*giaphong)+"   ",10,y);y+=yShift;
			            g2d.drawString("---------------------------------------------",10,y);y+=yShift;
			            g2d.drawString(" Cash      :                 "+ip_tienkhachtra.getText()+"   ",10,y);y+=yShift;
			            g2d.drawString("---------------------------------------------",10,y);y+=yShift;
			            g2d.drawString(" Balance   :                 "+ip_tientralaikhach.getText()+"   ",10,y);y+=yShift;
			  
			            g2d.drawString("*********************************************",10,y);y+=yShift;
			            g2d.drawString("       THANK YOU COME AGAIN            ",10,y);y+=yShift;
			            g2d.drawString("*********************************************",10,y);y+=yShift;
			            g2d.drawString("       BILL MAKE BY:"+namenv+"          ",10,y);y+=yShift;
			            g2d.drawString("     CONTACT: KaraokeNice@gmail.com       ",10,y);y+=yShift;       
			           
			            try {
							phong_dao.updateTrangThaiPhong(maphong, "Còn Trống");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    }
			    catch(Exception e){
			    e.printStackTrace();
			    }

			              result = PAGE_EXISTS;    
			          }    
			          return result;   
			}
		});
		boolean returningresult=printerJob.printDialog();
		if(returningresult) {
			try {
				
				printerJob.print();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Lỗi","Không thể in dược hóa đơn",JOptionPane.WARNING_MESSAGE);
			}
		}
		}
	public boolean checkregex() {
		String regex = "\\d+";
		String vaule=ip_tienkhachtra.getText();
		if(!vaule.matches(regex)) {
			 lb_check.setText("Không được phép nhập chữ");
			 lb_check.setVisible(true);
			 return false;
		}
		else {
			lb_check.setVisible(false);
			return true;
		}
	}
}
