package eg.edu.alexu.csd.datastructure.mailServer.cs61_cs07_cs08;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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

public class info {

	private JFrame frame;
	private JTextField email;
	private JPasswordField password;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					info window = new info();
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
	public info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 426);
		frame.setUndecorated(true); // remove borders.
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 153, 0));
		panel.setBounds(0, 0, 450, 56);
		frame.getContentPane().add(panel);

		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRegister.setBounds(30, 15, 139, 26);
		panel.add(lblRegister);

		JLabel label_1 = new JLabel("X");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(false);

			}
		});
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		label_1.setBounds(420, 22, 20, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("-");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBounds(390, 22, 20, 14);
		panel.add(label_2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 55, 450, 371);
		frame.getContentPane().add(panel_1);

		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setForeground(new Color(245, 245, 245));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(34, 121, 87, 22);
		panel_1.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(220, 220, 220));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(34, 161, 87, 22);
		panel_1.add(lblPassword);

		email = new JTextField();
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.BOLD, 14));
		email.setColumns(10);
		email.setBackground(Color.GRAY);
		email.setBounds(148, 122, 241, 22);
		panel_1.add(email);

		password = new JPasswordField();
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBackground(Color.GRAY);
		password.setBounds(148, 162, 241, 22);
		panel_1.add(password);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Details a = new Details();
				a.name = email.getText();
				a.pass = password.getText();
				MailServer B = new MailServer();
				if (B.signup(a)) {
					JOptionPane.showMessageDialog(null, "Your mail is made");
				} else {
					JOptionPane.showMessageDialog(null, "Your mail is exist");

				}
				frame.setVisible(false);
			}
		});
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCreate.setBackground(new Color(51, 153, 204));
		btnCreate.setBounds(226, 238, 89, 37);
		panel_1.add(btnCreate);

		JLabel lblClickHereTo = new JLabel("Click here to login!");
		lblClickHereTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				form frm = new form();
				frm.setVisible(true);
				frame.setVisible(false);

			}
		});
		lblClickHereTo.setForeground(Color.WHITE);
		lblClickHereTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickHereTo.setBounds(217, 286, 233, 22);
		panel_1.add(lblClickHereTo);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(148, 30, 241, 22);
		panel_1.add(textField_1);

		JLabel lblFirstNane = new JLabel("First name:");
		lblFirstNane.setForeground(new Color(245, 245, 245));
		lblFirstNane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstNane.setBounds(34, 29, 104, 22);
		panel_1.add(lblFirstNane);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(148, 76, 241, 22);
		panel_1.add(textField_2);

		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setForeground(new Color(245, 245, 245));
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(34, 75, 87, 22);
		panel_1.add(lblLastName);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.GRAY);
		textField_3.setBounds(148, 205, 241, 22);
		panel_1.add(textField_3);

		JLabel lblRepass = new JLabel("Re-pass:");
		lblRepass.setForeground(new Color(245, 245, 245));
		lblRepass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRepass.setBounds(34, 204, 87, 22);
		panel_1.add(lblRepass);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);

	}
}
