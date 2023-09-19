package UI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import Dao.DichVu_DAO;
import Entity.DichVu;
import Entity.Dichvudadat;
import java.awt.event.ActionListener;

public class Thucdon_UI extends JPanel {
	private JPanel panel_1 ;
	private ImageIcon icon1=new ImageIcon(getClass().getClassLoader().getResource("image/bibimbap.png"));
	private ImageIcon icon2=new ImageIcon(getClass().getClassLoader().getResource("image/drink.png"));
	private DichVu_DAO dichvu_dao=new DichVu_DAO();
	private ArrayList<Dichvudadat> listdv_dd=new ArrayList<Dichvudadat>();
	private PlaceholderTextField searchText;

	/**
	 * Create the panel.
	 */
	public Thucdon_UI(JTextField ip_madichvu, JTextField ip_tendichvu, JTextField ip_dongia) {
		setBounds(0,0,947,696);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 947, 52);
		panel.setBackground(Color.ORANGE);
		add(panel);
		panel.setLayout(null);
		
		 searchText = new PlaceholderTextField();
		searchText.setPlaceholder("Nhập tên dịch vụ");
		searchText.setFont(new Font("Tahoma", Font.PLAIN, 19));
		searchText.setColumns(10);
		searchText.setBounds(10, 10, 589, 32);
		panel.add(searchText);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u1EA5t c\u1EA3", "\u0110\u1ED3 \u0103n", "Th\u1EE9c u\u1ED1ng", "Kh\u00E1c"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(790, 10, 147, 32);
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Nh\u00F3m h\u00E0ng :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(653, 10, 127, 32);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 947, 646);
		add(scrollPane);
		
		 panel_1 = new JPanel();
		 panel_1.setBackground(new Color(255, 255, 255));
		 panel_1.setLayout(new WrapLayout());
		scrollPane.setViewportView(panel_1);
		
		addDV(ip_madichvu,ip_tendichvu, ip_dongia);
		Action action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(!searchText.getText().equalsIgnoreCase("")) {
		    		panel_1.removeAll();
		    		addDVtheoten(ip_madichvu,ip_tendichvu, ip_dongia,searchText.getText());
			    	panel_1.repaint();
			    	panel_1.revalidate();
		    	}
		    	
				
		    }
		};
//		searchText.getDocument().addDocumentListener(new DocumentListener() {
//			
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				if(checkregex()==true) {
////					searchText.addActionListener( action );
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Khong duoc nhap chu cai hoac ky tu dac biet");
//					
//				}
//					
//				
//			}
//			
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				if(checkregex()==true) {
////					searchText.addActionListener( action );
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Khong duoc nhap chu cai hoac ky tu dac biet");
//					
//				}
//				
//			}
//		});
		searchText.addActionListener( action );
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0) {
					panel_1.removeAll();
					addDV(ip_madichvu,ip_tendichvu, ip_dongia);
			    	panel_1.repaint();
			    	panel_1.revalidate();
				}
				else if(comboBox.getSelectedIndex()==2) {
					panel_1.removeAll();
					addDVthucan(ip_madichvu,ip_tendichvu, ip_dongia);
			    	panel_1.repaint();
			    	panel_1.revalidate();
				}
				else if(comboBox.getSelectedIndex()==1) {
					panel_1.removeAll();
					addDVdouong(ip_madichvu,ip_tendichvu, ip_dongia);
			    	panel_1.repaint();
			    	panel_1.revalidate();
				}
			}
		});
		
		
		
	}

	private void addDV(JTextField ip_madichvu, JTextField ip_tendichvu, JTextField ip_dongia) {
		
		// TODO Auto-generated method stub
		List<DichVu> dichvu=dichvu_dao.getAllDV();
		for (DichVu dichVu2 : dichvu) {
			if(dichVu2.getMaLDV()==1) {
				panel_1.add(new Itemdichvu(icon2,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
			}
			else {
				panel_1.add(new Itemdichvu(icon1,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
			
			}
		}
	}
private void addDVtheoten(JTextField ip_madichvu, JTextField ip_tendichvu, JTextField ip_dongia,String ten) {
		
		// TODO Auto-generated method stub
		List<DichVu> dichvu=dichvu_dao.getAllDVtheoten(ten);
		if(dichvu.size()<=0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy !");
			return;
		}
		for (DichVu dichVu2 : dichvu) {
			if(dichVu2.getMaLDV()==1) {
				panel_1.add(new Itemdichvu(icon2,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
			}
			else {
				panel_1.add(new Itemdichvu(icon1,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
			
			}
		}
	}
		private void addDVtheoma(int madv,JTextField ip_madichvu, JTextField ip_tendichvu, JTextField ip_dongia) {
			
			// TODO Auto-generated method stub
			List<DichVu> dichvu=dichvu_dao.getAllDV();
			for (DichVu dichVu2 : dichvu) { 
				if(dichVu2.getMaDV()==madv) {
					if(dichVu2.getMaLDV()==1) {
						panel_1.add(new Itemdichvu(icon2,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
					}
					else {
						panel_1.add(new Itemdichvu(icon1,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
					}
				}
			}
	}

		
		private void addDVthucan(JTextField ip_madichvu, JTextField ip_tendichvu, JTextField ip_dongia) {
			
			// TODO Auto-generated method stub
			List<DichVu> dichvu=dichvu_dao.getAllDV();
			for (DichVu dichVu2 : dichvu) {
				if(dichVu2.getMaLDV()==1) {
					panel_1.add(new Itemdichvu(icon2,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
				}
			}
		}
		private void addDVdouong(JTextField ip_madichvu, JTextField ip_tendichvu, JTextField ip_dongia) {
			
			// TODO Auto-generated method stub
			List<DichVu> dichvu=dichvu_dao.getAllDV();
			for (DichVu dichVu2 : dichvu) {
				if(dichVu2.getMaLDV()==1) {
					panel_1.add(new Itemdichvu(icon1,dichVu2,ip_madichvu, ip_tendichvu, ip_dongia, dichVu2.getMaDV(), dichVu2.getTenDV(), dichVu2.getDonGia()));
				}

			}
		}
}
