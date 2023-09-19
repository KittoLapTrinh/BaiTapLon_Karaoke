package UI;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Dao.Phong_DAO;
import Entity.Phong;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Timestamp;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Phong_Ban_UI extends JPanel {
	private JPanel panel_3;
	
	private Phong_DAO phong_dao=new Phong_DAO();
	private ImageIcon url=new ImageIcon(getClass().getClassLoader().getResource("image/singing.png"));
	private PlaceholderTextField searchText;
	private JComboBox comboBox;
	private String gioden;
	int ct=0, sd=0, bt=0;

	/**
	 * Create the panel.
	 */
	public Phong_Ban_UI( JLabel ip_maphong, JLabel ip_tenphong,JComboBox cb_loaiPhong) {
		
		setBounds(0,0,947,696);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 947, 52);
		add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("Lọc :");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(724, 10, 56, 32);
		panel.add(lblNewLabel_4);
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Phòng Thường", "Phòng VIP", "Còn trống", "Đang sử dụng", "Bảo trì"}));
		
		comboBox.setBounds(790, 10, 147, 32);
		panel.add(comboBox);
		searchText = new PlaceholderTextField();
		searchText.setFont(new Font("Tahoma", Font.PLAIN, 19));
		searchText.setBounds(10, 10, 451, 32);
		panel.add(searchText);
		searchText.setPlaceholder("Nhập Mã Phòng");
		searchText.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 947, 611);
		add(scrollPane);
		 panel_3 = new JPanel();
		 panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(new WrapLayout());
		scrollPane.setViewportView(panel_3);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 663, 947, 33);
		add(panel_1);
		panel_1.setLayout(null);
		JLabel lblNewLabel = new JLabel("Đang sử dụng :");
		lblNewLabel.setBounds(0, 0, 127, 33);
		panel_1.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setBounds(137, 0, 24, 33);
		panel_1.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Trống :");
		lblNewLabel_2.setBounds(171, 0, 91, 33);
		panel_1.add(lblNewLabel_2);
		JLabel lblNewLabel_1_1 = new JLabel("1");
		lblNewLabel_1_1.setBounds(272, 0, 24, 33);
		panel_1.add(lblNewLabel_1_1);
		JLabel lblSPhngang = new JLabel("Bảo trì :");
		lblSPhngang.setBounds(306, 0, 127, 33);
		panel_1.add(lblSPhngang);
		JLabel lblNewLabel_1_2 = new JLabel("1");
		lblNewLabel_1_2.setBounds(443, 0, 14, 33);
		panel_1.add(lblNewLabel_1_2);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 0));
		panel_2.setBounds(523, 10, 14, 13);
		panel_1.add(panel_2);
		JLabel lblNewLabel_3 = new JLabel("\u0110ang s\u1EED d\u1EE5ng");
		lblNewLabel_3.setBounds(547, 0, 101, 33);
		panel_1.add(lblNewLabel_3);
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 255, 0));
		panel_2_1.setBounds(658, 10, 14, 13);
		panel_1.add(panel_2_1);
		JLabel lblNewLabel_3_1 = new JLabel("C\u00F2n tr\u1ED1ng");
		lblNewLabel_3_1.setBounds(682, 0, 91, 33);
		panel_1.add(lblNewLabel_3_1);
		JLabel lblNewLabel_3_1_1 = new JLabel("\u0110ang b\u1EA3o tr\u00EC");
		lblNewLabel_3_1_1.setBounds(787, 0, 80, 33);
		panel_1.add(lblNewLabel_3_1_1);
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(255, 255, 0));
		panel_2_1_1.setBounds(763, 10, 14, 13);
		panel_1.add(panel_2_1_1);
		JButton btn_refresh = new JButton("");
		btn_refresh.setBackground(new Color(255, 255, 255));
		btn_refresh.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/refresh-page-option.png")));
		
		btn_refresh.setBounds(894, 0, 43, 33);
		panel_1.add(btn_refresh);

		addPhong(ip_maphong, ip_tenphong, cb_loaiPhong);
		
		soLuongPhong();
		lblNewLabel_1_1.setText(ct+"");
		lblNewLabel_1_2.setText(bt+"");
		lblNewLabel_1.setText(sd+"");
		
		
		Action action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(!searchText.getText().equalsIgnoreCase("")&&checkregexphong()==true) {
		    		panel_3.removeAll();
			    	getphongtheoma(searchText.getText(),ip_maphong, ip_tenphong, cb_loaiPhong);
					panel_3.repaint();
					panel_3.revalidate();
					soLuongPhong();
		    	}
		    	else {
		    		JOptionPane.showMessageDialog(null, "Khong duoc de trong hoac co ky tu chu cai hoac ky tu dac biet");
		    	}
		    }
		};
searchText.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(checkregexphong()==true) {
//					searchText.addActionListener( action );
				}
				else {
					JOptionPane.showMessageDialog(null, "Khong duoc nhap chu cai hoac ky tu dac biet");

					
				}
					
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				if(checkregexphong()==true) {
//					searchText.addActionListener( action );
				}
				else {
					JOptionPane.showMessageDialog(null, "Khong duoc nhap chu cai hoac ky tu dac biet");

					
				}
				
			}
		});
		searchText.addActionListener( action );
		

		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				addPhong(ip_maphong, ip_tenphong, cb_loaiPhong);
				panel_3.repaint();
				panel_3.revalidate();
				ct=0;
				bt=0;
				sd=0;
				soLuongPhong();
				lblNewLabel_1_1.setText(ct+"");
				lblNewLabel_1_2.setText(bt+"");
				lblNewLabel_1.setText(sd+"");
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				locPhong(ip_maphong, ip_tenphong, cb_loaiPhong);
				panel_3.repaint();
				panel_3.revalidate();
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
		long diffsecond = diff / (1000) % 64;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		String[] x= {diffHours+"",diffMinutes+"",diffsecond+""};

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
	
	//Sự kiện thêm phòng
	public void addPhong(JLabel ip_maphong, JLabel ip_tenphong,JComboBox cb_loaiPhong) { 
		ArrayList<Phong> phong=phong_dao.getAllPhong();
		Timestamp time=new Timestamp(System.currentTimeMillis());
		SimpleDateFormat dt = new SimpleDateFormat("HH:mm"); 
		String timenow=dt.format(time);
		
		for (Phong phong2 : phong) {
			
			if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
				if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
					
					itemphongvip it=new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false);
					panel_3.add(it);
				}
				else {
					itemphong it=new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false);
					panel_3.add(it);
				}
	
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
				if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
					panel_3.add( new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua(dt.format(phong2.getGiobatdau()),timenow),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
				}
				else {
					panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua(dt.format(phong2.getGiobatdau()),timenow),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
				}
				
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
				if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
					panel_3.add(new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
				}
				else {
					panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
				}
				
			}
		}
	}
	
	//Sự kiện đếm số lượng phòng
	public void soLuongPhong() { 
		
		ArrayList<Phong> phong=phong_dao.getAllPhong();
		
		for (Phong phong2 : phong) {
			if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
				ct++;
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
				sd++;
			}
			else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
				bt++;
			}
		}
	}
	
	//Sự kiện lọc phòng
	public void locPhong(JLabel ip_maphong, JLabel ip_tenphong,JComboBox cb_loaiPhong) { 
		
		ArrayList<Phong> phong=phong_dao.getAllPhong();
		if(comboBox.getSelectedItem().equals("Còn trống")) {
			for (Phong phong2 : phong) {
				if(phong2.getTrangThai().equalsIgnoreCase("Còn trống")) {
					if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
						itemphongvip it=new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false);
						panel_3.add(it);
					}
					else {
						itemphong it=new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false);
						panel_3.add(it);
					}
				}
			}
		}
		else if(comboBox.getSelectedItem().equals("Đang sử dụng")) {
			for (Phong phong2 : phong) {
				if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
					if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
						panel_3.add( new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua("20:30","22:20"),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
					}
					else {
						panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua("20:30","22:20"),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
					}
					
				}
			}
		}
		else if(comboBox.getSelectedItem().equals("Bảo trì")) {
			for (Phong phong2 : phong) {
				if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
					if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
						panel_3.add(new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
					}
					else {
						panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
					}
				}
			}
		}
		else if(comboBox.getSelectedItem().equals("Phòng VIP")) {
			for (Phong phong2 : phong) {
				if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
					if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
						panel_3.add(new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false));
					}
					else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
						panel_3.add(new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua("20:30","22:20"),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
						}
					else {
						panel_3.add(new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
					}
				}
			}
		}
		else if(comboBox.getSelectedItem().equals("Phòng Thường")) {
			for (Phong phong2 : phong) {
				if(phong2.getLoaiPhong().equalsIgnoreCase("Thường")) {
					if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
						itemphong it=new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false);
						panel_3.add(it);
					}
					else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
						panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua("20:30","22:20"),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
						}
					else {
						panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
						}
				}
			}
		}
		else if(comboBox.getSelectedItem().equals("Tất cả")){
			addPhong(ip_maphong, ip_tenphong, cb_loaiPhong);
		}
	}
	 public void getphongtheoma(String maphong,JLabel ip_maphong, JLabel ip_tenphong,JComboBox cb_loaiPhong) {
		 Timestamp time=new Timestamp(System.currentTimeMillis());
			SimpleDateFormat dt = new SimpleDateFormat("HH:mm"); 
			String timenow=dt.format(time);
 		 Phong phong2 =phong_dao.getPhong(maphong);
 		 if(phong2==null) {
 				JOptionPane.showMessageDialog(null, "Không tìm thấy !");
 				return;
 			}
 		else if(phong2.getTrangThai().equalsIgnoreCase("Còn Trống")) {
			if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
				
				itemphongvip it=new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false);
				panel_3.add(it);
			}
			else {
				itemphong it=new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.green,0,0,0,0,false);
				panel_3.add(it);
			}

		}
		else if(phong2.getTrangThai().equalsIgnoreCase("Đang sử dụng")) {
			if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
				panel_3.add( new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua(dt.format(phong2.getGiobatdau()),timenow),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
			}
			else {
				panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.red,demgiaytroiqua(dt.format(phong2.getGiobatdau()),timenow),Integer.parseInt(demGio("20:30","22:20")[0]),Integer.parseInt(demGio("20:30","22:20")[1]),10,true));
			}
			
		}
		else if(phong2.getTrangThai().equalsIgnoreCase("Bảo trì")) {
			if(phong2.getLoaiPhong().equalsIgnoreCase("VIP")) {
				panel_3.add(new itemphongvip(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
			}
			else {
				panel_3.add(new itemphong(url,phong2,ip_maphong,ip_tenphong,cb_loaiPhong,phong2.getTenPhong(),Color.yellow,0,0,0,0,false));
			}
			
		}
 		
 	 }
	 public boolean checkregexphong() {
			String regex = "\\d+";
			String vaule=searchText.getText();
			if(!vaule.matches(regex)) {
				 return false;
			}
			else {
				return true;
			}
		}
}
