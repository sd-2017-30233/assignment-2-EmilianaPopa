package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.User;
import View.AdminView;
import View.Display;
import View.LogIn;
import View.UserView;

public class LogInControl {
	private UserView userpanel;
	private User u;
	private AdminView adminpanel;
	private LogIn log;
	
	public LogInControl(AdminView a, UserView up, User u, LogIn log)
	{
		this.userpanel=up;
		this.adminpanel=a;
		this.u=u;
		this.log=log;
		
		log.logIn(new login());
			
	}
	
	class login implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(u.login(log.getUsernameLog()))
			{
				adminpanel.getFrame().setVisible(true);
				log.getFrame().setVisible(false);
			}
			else{
				userpanel.getFrame().setVisible(true);
				log.getFrame().setVisible(false);
			
		}
		}
	}
	
}
