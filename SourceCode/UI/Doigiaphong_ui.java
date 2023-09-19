package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Dao.Phong_DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Doigiaphong_ui extends JFrame {

	private JPanel contentPane;
	private JTextField ip_giamoi;
	private Phong_DAO phong_DAO=new Phong_DAO();
	private JButton btn_doigiaphong;


	public Doigiaphong_ui(String maphong) {
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 400, 360 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds ( ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u1ED5i gi\u00E1 ph\u00F2ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 400, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phòng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(10, 52, 120, 27);
		contentPane.add(lblNewLabel_1);
		
		 btn_doigiaphong = new JButton("\u0110\u1ED5i");
		 btn_doigiaphong.setBackground(new Color(0, 255, 128));
		
		btn_doigiaphong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_doigiaphong.setBounds(10, 275, 156, 60);
		contentPane.add(btn_doigiaphong);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.setBackground(new Color(255, 128, 128));
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_thoat.setBounds(240, 275, 150, 60);
		contentPane.add(btn_thoat);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên phòng :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(10, 89, 120, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lb_maphong = new JLabel(maphong);
		lb_maphong.setForeground(new Color(255, 0, 0));
		lb_maphong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lb_maphong.setBounds(139, 52, 251, 27);
		contentPane.add(lb_maphong);
		
		JLabel lb_tenphong = new JLabel(phong_DAO.getPhong(maphong).getTenPhong());
		lb_tenphong.setForeground(new Color(255, 0, 0));
		lb_tenphong.setFont(new Font("Tahoma", Font.BOLD, 17));
		lb_tenphong.setBounds(139, 89, 120, 27);
		contentPane.add(lb_tenphong);
		
		JLabel lblNewLabel_3 = new JLabel("Giá cũ :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(10, 171, 120, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lb_giacu = new JLabel(phong_DAO.getPhong(maphong).getGiagio()+"");
		lb_giacu.setForeground(new Color(255, 0, 0));
		lb_giacu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lb_giacu.setBounds(139, 171, 251, 35);
		contentPane.add(lb_giacu);
		
		JLabel lblNewLabel_3_1 = new JLabel("Giá mới :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(10, 216, 120, 35);
		contentPane.add(lblNewLabel_3_1);
		
		ip_giamoi = new JTextField();
		ip_giamoi.setBounds(139, 216, 251, 42);
		contentPane.add(ip_giamoi);
		ip_giamoi.setColumns(10);
		
		JLabel lblNewLabel_3_2 = new JLabel("Loại phòng :");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_2.setBounds(10, 126, 120, 35);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lb_giacu_1 = new JLabel(phong_DAO.getPhong(maphong).getLoaiPhong());
		lb_giacu_1.setForeground(Color.RED);
		lb_giacu_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lb_giacu_1.setBounds(139, 126, 251, 35);
		contentPane.add(lb_giacu_1);
		
		
		
		btn_doigiaphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ip_giamoi.getText().trim().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Không được để trống !");
				}
				else if(checkregexphong()==true) {
					
					try {
						phong_DAO.updategiagio(maphong, Integer.parseInt(ip_giamoi.getText()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Đổi thành công !");
				}
				else {
					JOptionPane.showMessageDialog(null, "Khong duoc nhap chu cai hoac ky tu dac biet");
					
				}
			}
		});
		
	}
	 public boolean checkregexphong() {
			String regex = "\\d+";
			String vaule=ip_giamoi.getText();
			if(!vaule.matches(regex)) {
				 return false;
			}
			else {
				return true;
			}
		}
	
}
