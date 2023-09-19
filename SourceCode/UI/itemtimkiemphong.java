package UI;

import java.awt.Dimension;

import javax.swing.JPanel;

import Dao.Phong_DAO;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class itemtimkiemphong extends JPanel {
	
	private Phong_DAO phong_dao=new Phong_DAO();

	/**
	 * Create the panel.
	 */
	public itemtimkiemphong(int maphong,Color bgtrangthai) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showaboutphong(maphong);
			}

			
		});
		setPreferredSize(new Dimension(247, 132));
		setLayout(null);
		setBackground(bgtrangthai);
		JLabel lblNewLabel = new JLabel("Tên phòng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(86, 60, 95, 26);
		add(lblNewLabel);
		
		JLabel lb_icon = new JLabel("");
		lb_icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/singing.png")));
		lb_icon.setBounds(10, 13, 70, 73);
		add(lb_icon);
		
		JLabel lblMPhng = new JLabel("Mã phòng ");
		lblMPhng.setForeground(Color.WHITE);
		lblMPhng.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMPhng.setBounds(90, 13, 95, 26);
		add(lblMPhng);
		
		JLabel lb_maphong = new JLabel(maphong+"");
		lb_maphong.setForeground(Color.WHITE);
		lb_maphong.setFont(new Font("Dialog", Font.BOLD, 16));
		lb_maphong.setBounds(191, 10, 35, 26);
		add(lb_maphong);
		
		JLabel lb_name = new JLabel(phong_dao.getPhong(maphong+"").getTenPhong());
		lb_name.setForeground(Color.WHITE);
		lb_name.setFont(new Font("Dialog", Font.BOLD, 16));
		lb_name.setBounds(191, 60, 54, 26);
		add(lb_name);
		
		JLabel lblNewLabel_1 = new JLabel("Lo\u1EA1i");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 96, 95, 26);
		add(lblNewLabel_1);
		
		JLabel lb_loaiphong = new JLabel(phong_dao.getPhong(maphong+"").getLoaiPhong());
		lb_loaiphong.setForeground(new Color(255, 255, 255));
		lb_loaiphong.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_loaiphong.setBounds(115, 96, 95, 26);
		add(lb_loaiphong);
	}

	protected void showaboutphong(int maphong) {
		// TODO Auto-generated method stub
		JFrame thongtinphong=new ThongTinPhong(maphong);
		thongtinphong.setVisible(true);
	}
}
