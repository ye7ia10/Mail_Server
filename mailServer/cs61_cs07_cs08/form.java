package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class form {

	private JFrame frame;
	private JTextField mail;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					form window = new form();
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
	public form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 450, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true); // remove borders.
		frame.setLocationRelativeTo(null); // center the window.
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));

		panel.setBounds(0, 0, 450, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(30, 15, 139, 26);
		panel.add(lblNewLabel);

		JLabel lblclose = new JLabel("X");
		lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblclose.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblclose.setForeground(new Color(255, 255, 255));
		lblclose.setBounds(420, 22, 20, 14);
		panel.add(lblclose);

		JLabel labelmin = new JLabel("-");
		labelmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED); // minimize frame.
			}
		});
		labelmin.setFont(new Font("Tahoma", Font.BOLD, 25));
		labelmin.setForeground(new Color(255, 255, 255));
		labelmin.setBounds(390, 22, 20, 14);
		panel.add(labelmin);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 55, 450, 287);
		frame.getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("E-mail : ");
		lblNewLabel_1.setBounds(34, 62, 87, 22);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(245, 245, 245));

		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(34, 107, 87, 22);
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));

		mail = new JTextField();
		mail.setBounds(131, 62, 241, 22);
		mail.setFont(new Font("Tahoma", Font.BOLD, 14));
		mail.setForeground(new Color(255, 255, 255));
		mail.setBackground(new Color(128, 128, 128));
		mail.setColumns(10);

		pass = new JPasswordField();
		pass.setBounds(131, 107, 241, 22);
		pass.setFont(new Font("Tahoma", Font.BOLD, 14));
		pass.setForeground(new Color(255, 255, 255));
		pass.setBackground(new Color(128, 128, 128));

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MailServer m = new MailServer();
				String u = mail.getText();
				@SuppressWarnings("deprecation")
				String p = pass.getText();
				if (m.signin(u, p)) {
					newj frame = new newj();
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Email or Password doesn't match");
				}
			}
		});
		btnNewButton.setBounds(208, 152, 89, 37);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 153, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblsign = new JLabel("Click here to create a new account !");
		lblsign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				info x = new info();
				x.setVisible(true);
			}
		});
		lblsign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblsign.setBounds(151, 208, 233, 14);
		lblsign.setForeground(new Color(255, 255, 255));
		lblsign.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1);
		panel_1.add(lblNewLabel_2);
		panel_1.add(mail);
		panel_1.add(pass);
		panel_1.add(btnNewButton);
		panel_1.add(lblsign);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { panel, panel_1 }));
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

	public void setLocate(Object object) {
		frame.setLocationRelativeTo(null);
		// TODO Auto-generated method stub

	}

	public void pack() {
		// TODO Auto-generated method stub
		frame.pack();

	}

	public void setClose() {
		// TODO Auto-generated method stub
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
