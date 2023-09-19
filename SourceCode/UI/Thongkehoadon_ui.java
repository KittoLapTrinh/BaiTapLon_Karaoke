package UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Dao.HoaDon_DAO;
import Entity.HoaDon;
import Entity.NhanVien;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Thongkehoadon_ui extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private HoaDon_DAO hd_dao=new HoaDon_DAO();
	private String output="C:\\Users\\admin\\Desktop\\danhsachhoadon.xls";
	/**
	 * Create the panel.
	 */
	public Thongkehoadon_ui() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1534,710);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 0, 754, 58);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hóa đơn");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 754, 58);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(764, 0, 760, 58);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Doanh thu");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 772, 58);
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 742, 570);
		add(scrollPane);
		
		String [] headers = "MaHD;Makh;Maphong;Ngaydat;Tiendichvu;Tienphong;Manv".split(";");
		tableModel=new DefaultTableModel(headers,0);
		table = new JTable(tableModel);
		table.getTableHeader().setBackground(new Color(102, 255, 255));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 128));
		panel_2.setBounds(764, 68, 760, 213);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/groceries.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 59, 224, 144);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng doanh thu dịch vụ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(10, 10, 224, 39);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(244, 10, 5, 193);
		panel_2.add(panel_4);
		
		int tongdv=0;
		double tonggiohat=0;
		ArrayList<HoaDon> hd=hd_dao.getAllHoaDon();
		for(int i=0;i<hd_dao.getAllHoaDon().size();i++) {
			tongdv+=hd.get(i).getTongTienDV();
			tonggiohat+=hd.get(i).getTongTienPhong();
		}
		
		JLabel lb_doanhthudv = new JLabel(tongdv+"  VND");
		lb_doanhthudv.setForeground(new Color(255, 0, 0));
		lb_doanhthudv.setHorizontalAlignment(SwingConstants.CENTER);
		lb_doanhthudv.setFont(new Font("Tahoma", Font.BOLD, 30));
		lb_doanhthudv.setBounds(259, 10, 491, 193);
		panel_2.add(lb_doanhthudv);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 255, 128));
		panel_2_1.setBounds(764, 291, 760, 213);
		add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/chronometer.png")));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(10, 59, 224, 144);
		panel_2_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tổng doanh thu giờ hát");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(10, 10, 224, 39);
		panel_2_1.add(lblNewLabel_2_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.BLACK);
		panel_4_1.setBounds(244, 10, 5, 193);
		panel_2_1.add(panel_4_1);
		
		JLabel lb_doanhthugiohat = new JLabel((int)tonggiohat+"  VND");
		lb_doanhthugiohat.setForeground(new Color(255, 0, 0));
		lb_doanhthugiohat.setHorizontalAlignment(SwingConstants.CENTER);
		lb_doanhthugiohat.setFont(new Font("Tahoma", Font.BOLD, 30));
		lb_doanhthugiohat.setBounds(259, 10, 491, 193);
		panel_2_1.add(lb_doanhthugiohat);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(0, 255, 255));
		panel_2_2.setBounds(764, 514, 760, 186);
		add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/action.png")));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(10, 59, 224, 117);
		panel_2_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tổng doanh thu hóa đơn");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(10, 10, 224, 39);
		panel_2_2.add(lblNewLabel_2_2);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(Color.BLACK);
		panel_4_2.setBounds(244, 10, 5, 166);
		panel_2_2.add(panel_4_2);
		
		NumberFormat formatter = new DecimalFormat("#0.0"); 
		JLabel lb_tongdoanhthu = new JLabel(formatter.format(tonggiohat+tongdv)+"VND");
		lb_tongdoanhthu.setForeground(new Color(255, 0, 0));
		lb_tongdoanhthu.setHorizontalAlignment(SwingConstants.CENTER);
		lb_tongdoanhthu.setFont(new Font("Tahoma", Font.BOLD, 30));
		lb_tongdoanhthu.setBounds(259, 10, 491, 166);
		panel_2_2.add(lb_tongdoanhthu);
		
		JButton btnNewButton = new JButton("Xuất danh sách");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/printing.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(216, 649, 249, 51);
		add(btnNewButton);
		addtable();
	}
	public void addtable() {
		ArrayList<HoaDon> hd=hd_dao.getAllHoaDon();
		for (HoaDon hoadon : hd) {
			Object [] row= {hoadon.getMaHD(),hoadon.getMaKH(),hoadon.getMaPhong(),hoadon.getNgayDat(),hoadon.getTongTienDV(),hoadon.getTongTienPhong(),hoadon.getMaNV()};
			tableModel.addRow(row);
		}
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
    MessageFormat footer=new MessageFormat("Tổng Hoadon:   "+doanhthu);
    try {
		jTable.print(JTable.PrintMode.FIT_WIDTH,header,footer);
	} catch (PrinterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
