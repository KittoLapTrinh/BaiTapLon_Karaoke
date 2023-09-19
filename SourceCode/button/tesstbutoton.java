package button;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class tesstbutoton extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tesstbutoton frame = new tesstbutoton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tesstbutoton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MyButton btnNewButton = new MyButton(new Color(204, 255, 255),new Color(51, 153, 255),new Color(51, 51, 255));
//		btnNewButton.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\20054911\\DoAn_PTUD\\img\\add-user.png"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setRadius(50);
		btnNewButton.setBounds(94, 72, 193, 110);
		
		contentPane.add(btnNewButton);
	}

}
