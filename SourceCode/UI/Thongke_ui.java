package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Thongke_ui extends JPanel {

	/**
	 * Create the panel.
	 */
	public Thongke_ui() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1534,756);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1534, 756);
		add(tabbedPane);
		
		Thongkehoadon_ui panel = new Thongkehoadon_ui();
		tabbedPane.addTab("   Thống kê hóa đơn   ", null, panel, null);
		panel.setLayout(null);
		
		Chitietthongkehoadon_ui panel_1 = new Chitietthongkehoadon_ui();
		tabbedPane.addTab("   Chi tiết hóa đơn   ", null, panel_1, null);
		tabbedPane.setFont( new Font( "Dialog", Font.BOLD, 24 ) );
	}
}
