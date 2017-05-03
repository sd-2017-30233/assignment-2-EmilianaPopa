package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView {

	private JFrame frame;
	private JTextField userbook;
	private JTextField qbook;
	private JButton btnSearch;
	private JButton btnSell ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView window = new UserView();
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
	public UserView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 359, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userbook = new JTextField();
		userbook.setBounds(135, 41, 116, 22);
		frame.getContentPane().add(userbook);
		userbook.setColumns(10);
		
		JLabel lblBook = new JLabel("Book");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBook.setBounds(43, 40, 80, 22);
		frame.getContentPane().add(lblBook);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(26, 157, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSell.setBounds(148, 157, 116, 25);
		frame.getContentPane().add(btnSell);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(43, 99, 80, 22);
		frame.getContentPane().add(lblQuantity);
		
		qbook = new JTextField();
		qbook.setBounds(135, 100, 116, 22);
		frame.getContentPane().add(qbook);
		qbook.setColumns(10);
	}
	
	public String getQBookTextField()
	{
		return this.qbook.getText();
	}
	
	public String getUserBookTextField()
	{
		return this.userbook.getText();
	}
	
	public void sellBooks(ActionListener metoda)
	{
		btnSell.addActionListener(metoda); 
	}
	
	public void searchBooks(ActionListener metoda)
	{
		btnSearch.addActionListener(metoda); 
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
}
