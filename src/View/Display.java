package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Display {

	private JFrame frame;
	private JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
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
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 13, 652, 400);
		frame.getContentPane().add(textArea);
	}
	
	public JTextArea getTextArea()
	{
		return textArea;
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
}
