package View;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class LogIn {

	private JFrame frame;
	private JPasswordField password;
	private JTextField username;
	private JButton btnLogIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
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
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		password = new JPasswordField();
		password.setBounds(187, 134, 116, 22);
		frame.getContentPane().add(password);
		
		username = new JTextField();
		username.setBounds(187, 86, 116, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		 btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(140, 194, 97, 25);
		frame.getContentPane().add(btnLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(56, 89, 76, 19);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(56, 137, 76, 19);
		frame.getContentPane().add(lblPassword);
	}
	
	public String getUsernameLog()
	{
		return this.username.getText();
	}
	
	public String getPasswordLog()
	{
		return this.password.getText();
	}
	
	public void logIn(ActionListener metoda)
	{
		btnLogIn.addActionListener(metoda);
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
}
