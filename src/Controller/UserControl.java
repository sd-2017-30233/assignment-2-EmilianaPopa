package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.AdminControl.addbook;
import Model.Book;
import Model.User;
import View.UserView;
import View.Display;

public class UserControl {
	private UserView userpanel;
	private Book b;
	private User u;
	private Display panel;
	
	public UserControl(UserView userpanel, Book b, User u,Display panel)
	{
		this.userpanel=userpanel;
		this.b=b;
		this.u=u;
		this.panel=panel;
		
		this.userpanel.sellBooks(new sellbooks());
		this.userpanel.searchBooks(new searchbook());
	}
	
	class sellbooks implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String t=userpanel.getUserBookTextField();
			int nr=Integer.parseInt(userpanel.getQBookTextField());
			b.sellBook(t, nr);
		}
	}
	
	class searchbook implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String book = userpanel.getUserBookTextField();
			Book b1=b.searchBook(book);
			String s;
			if(b1==null)
			{
				s="Nu exista cartea";		
			}
			else
			{
				s=b1.getID()+"   "+b1.getTitle()+"   "+b1.getAuthor()+"   "+b1.getGenre()+"   "+b1.getQuantity()+"   "+b1.getPrice();

			}
			panel.getFrame().setVisible(true);
			panel.getTextArea().setText(s);
		}
	}
}
