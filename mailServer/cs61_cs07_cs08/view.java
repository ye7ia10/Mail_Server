package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class view {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					view window = new view();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true); // remove borders.
		frame.setLocationRelativeTo(null); // center the window.
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		panel.setBounds(0, 0, 450, 34);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblYmail = new JLabel("Y-Mail :)");
		lblYmail.setForeground(new Color(255, 255, 255));
		lblYmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYmail.setBounds(10, 6, 83, 25);
		panel.add(lblYmail);

		JLabel lblX = new JLabel("X");
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblX.setOpaque(true);
				lblX.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setBackground(Color.black);
				lblX.setOpaque(false);
			}
		});
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX.setBounds(418, 11, 22, 14);
		panel.add(lblX);

		JLabel label = new JLabel("-");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED); // minimize frame.
			}
		});
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(386, 10, 22, 14);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 32, 99, 268);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("    Compose");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setOpaque(true);
				lblNewLabel.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(Color.black);
				lblNewLabel.setOpaque(false);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 11, 99, 32);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("    Inbox");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_1.setOpaque(true);
				lblNewLabel_1.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBackground(Color.black);
				lblNewLabel_1.setOpaque(false);
			}
		});
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(0, 77, 99, 32);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("    Sent Mails");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_2.setOpaque(true);
				lblNewLabel_2.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBackground(Color.black);
				lblNewLabel_2.setOpaque(false);
			}
		});
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 138, 99, 32);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("    Drafts");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel_3.setOpaque(true);
				lblNewLabel_3.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setBackground(Color.black);
				lblNewLabel_3.setOpaque(false);
			}
		});
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(0, 195, 99, 32);
		panel_1.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(98, 32, 352, 268);
		frame.getContentPane().add(panel_2);
	}
}
