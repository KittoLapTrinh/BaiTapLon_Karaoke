package UI;

import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Dao.Phong_DAO;
import Entity.Phong;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Timkiemphong extends JPanel {
	private JTextField lb_searchhong;
	private JPanel panel;
	private Phong_DAO phong_dao=new Phong_DAO();
	private JTextField ip_maphong;
//	private String url=getClass().getClassLoader().getResource("image/singing.png";
	private ImageIcon icon1=new ImageIcon(getClass().getClassLoader().getResource("image/singing.png"));
	private JComboBox cb_timkiem;
	private JButton btn_timkiem;
	private JComboBox cb_loc;
	private JLabel lb_maphong;
	private JLabel ip_tenphong;
	private JComboBox cb_loaiPhong;

	/**
	 * Create the panel.
	 */
	public Timkiemphong() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1534,756);
		setLayout(null);
		
		 cb_loc = new JComboBox();
		 cb_loc.setBackground(new Color(255, 255, 255));
		cb_loc.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Đang sử dụng", "Trống", "Bảo trì", "Phòng Vip", "Phòng thường"}));
		cb_loc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cb_loc.setBounds(1283, 10, 224, 29);
		add(cb_loc);
		
		JButton btn_refresh = new JButton("Refresh");
		btn_refresh.setBackground(new Color(255, 255, 255));
		btn_refresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
 		btn_refresh.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				panel.removeAll();
 				addPhong();
 				panel.repaint();
 				panel.revalidate();
 			}
 		});
		btn_refresh.setBounds(1427, 65, 85, 29);
		add(btn_refresh);
		
		JLabel lblLc = new JLabel("Lọc");
		lblLc.setHorizontalAlignment(SwingConstants.CENTER);
		lblLc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLc.setBounds(1133, 10, 140, 29);
		add(lblLc);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm theo :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 180, 29);
		add(lblNewLabel);
		
		 cb_timkiem = new JComboBox();
		 cb_timkiem.setBackground(new Color(255, 255, 255));
		cb_timkiem.setModel(new DefaultComboBoxModel(new String[] {"Mã phòng", "Tên Phòng"}));
		cb_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cb_timkiem.setBounds(200, 10, 224, 29);
		add(cb_timkiem);
		
		lb_searchhong = new JTextField();
		lb_searchhong.setColumns(10);
		lb_searchhong.setBounds(200, 49, 224, 35);
		add(lb_searchhong);
		
		 btn_timkiem = new JButton("Tìm kiếm");
		 btn_timkiem.setBackground(new Color(255, 255, 255));
		 btn_timkiem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/search (1).png")));
		btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_timkiem.setBounds(434, 49, 191, 35);
		add(btn_timkiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 1514, 642);
		add(scrollPane);
		
		 panel = new JPanel();
		 panel.setLayout(new WrapLayout());
		scrollPane.setViewportView(panel);
		
 		addPhong();
 		btn_timkiem.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
// 				  TODO Auto-generated method stub
 				panel.removeAll();
 				if(cb_timkiem.getSelectedIndex()==0) {
 		 			getphongtheoma(lb_searchhong.getText().toString());
 				 }
 		 		else if(cb_timkiem.getSelectedIndex()==1) {
 		 			addPhongtheoten(lb_searchhong.getText().trim());

 		 		}
 		 		
 				panel.repaint();
 				panel.revalidate();
 			}

			


 		});
 		
 		cb_loc.addActionListener(new ActionListener() {
 		 	public void actionPerformed(ActionEvent e) {
 		 		panel.removeAll();
 		 		if(cb_loc.getSelectedIndex()==0) {
 		 			addPhong();
 		 		}
 		 		else if(cb_loc.getSelectedIndex()==1) {
 		 			addPhongtrangthai(cb_loc.getSelectedItem().toString());
 				 }
 		 		else if(cb_loc.getSelectedIndex()==2) {
 		 			addPhongtrangthai("Còn Trống");
 		 			
 		 		}
 		 		else if(cb_loc.getSelectedIndex()==3) {
 		 			addPhongtrangthai(cb_loc.getSelectedItem().toString());
 		 			
 		 		}
 		 		else if(cb_loc.getSelectedIndex()==4) {
 		 			addPhongloaiphong("Vip");
 		 			
 		 		}
 		 		else if(cb_loc.getSelectedIndex()==5) {
 		 			addPhongloaiphong("Thường");
 		 			
 		 		}
 		 		panel.repaint();
 				panel.revalidate();
 		 	}
 		 });
 		
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
 	public int demgiaytroiqua(String gioden,String giodi)
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
 		
 		int second=(int) ((int)(diffHours*60*60)+(diffMinutes*60));
 		return second*1000;

 		} catch (Exception e) {
 			JOptionPane.showMessageDialog(null,"lỗi đếm giờ: "+e.toString());
 		return 0;
 		}
 	}
 	public void addPhong() { 
		ArrayList<Phong> phong=phong_dao.getAllPhong();
		
		for (Phong phong2 : phong) {
			if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
				itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.green);
				 panel.add(it);
	
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
				itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.RED);
				 panel.add(it);
				
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
				itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.yellow);
				 panel.add(it);
				
			}
		}
	}
 	public void addPhongtheoten(String name) { 
		ArrayList<Phong> phong=phong_dao.getAllPhongtheoten(name);
		if(phong.size()<=0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy !");
				return;
			}
		for (Phong phong2 : phong) {
			if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
				itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.green);
				 panel.add(it);
	
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
				itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.RED);
				 panel.add(it);
				
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
				itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.yellow);
				 panel.add(it);
				
			}
		}
	}
	
 	 public void getphongtheoma(String maphong) {
 		 Phong phong2 =phong_dao.getPhong(maphong);
 		 if(phong2==null) {
 				JOptionPane.showMessageDialog(null, "Không tìm thấy !");
 				return;
 			}
 		else if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
			itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.green);
			 panel.add(it);

		}
		else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
			itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.RED);
			 panel.add(it);
			
		}
		else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
			itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.yellow);
			 panel.add(it);
			
		}
 		
 	 }
 	 public void addPhongtrangthai(String trangthai) {
 		 
 			ArrayList<Phong> phong=phong_dao.getAllPhongtrangthai(trangthai);
 			
 			for (Phong phong2 : phong) {
 				if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
 					itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.green);
 					 panel.add(it);
 		
 				}
 				else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
 					itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.RED);
 					 panel.add(it);
 					
 				}
 				else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
 					itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.yellow);
 					 panel.add(it);
 					
 				}
 					}
 			
 			 
 		 }
 	 public void addPhongloaiphong(String loaiphong) {
 		 
 			ArrayList<Phong> phong=phong_dao.getAllPhongloaiphong(loaiphong);
 			
 			for (Phong phong2 : phong) {
 				if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
 					itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.green);
 					 panel.add(it);
 		
 				}
 				else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
 					itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.RED);
 					 panel.add(it);
 					
 				}
 				else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
 					itemtimkiemphong it=new itemtimkiemphong(phong2.getMaPhong(),Color.yellow);
 					 panel.add(it);
 					
 				}
 			}
 			 
 		 		 
 		 }
 	public void getPhongloaiphong(String loaiphong,JLabel lb_maphong, JLabel ip_tenphong,JComboBox cb_loaiPhong) {
		// TODO Auto-generated method stub
		
	}
}
