package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import Model.*;
import View.*;

public class Main {
	
	
	public static void main(String[] args) throws FileNotFoundException, DocumentException
	{
		//Models
		Book b =new Book();
		User u = new User();
		
		//Views
		AdminView adminpanel=new AdminView();
		UserView userpanel=new UserView();
		Display panel=new Display();
		LogIn logpanel = new LogIn();
		
		//Controll
		AdminControl adminC = new AdminControl(adminpanel, b, u, panel);
		UserControl userC=new UserControl(userpanel,b,u,panel);
		LogInControl loginC = new LogInControl(adminpanel,userpanel,u, logpanel);
		
		
		logpanel.getFrame().setVisible(true);
		
		
	}
}
