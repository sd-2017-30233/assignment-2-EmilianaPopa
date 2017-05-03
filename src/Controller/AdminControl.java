package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import com.itextpdf.*;
import com.itextpdf.text.DocumentException;

import Model.*;
import View.AdminView;
import View.Display;

public class AdminControl {
	private AdminView adminpanel;
	private Book b;
	private User u;
	private Display panel;
	private ReportFactory reportFactory = new ReportFactory();
    private Report report1 = reportFactory.getReport("PDF");
    private Report report2 = reportFactory.getReport("CSV");

	public AdminControl (AdminView adminpanel, Book b, User u,Display panel) throws FileNotFoundException, DocumentException
	{
		this.adminpanel=adminpanel;
		this.b=b;
		this.u=u;
		this.panel=panel;
		
		this.adminpanel.addBooks(new addbook());
		this.adminpanel.updateBooks(new updatebook());
		this.adminpanel.listBooks(new viewbooks());
		this.adminpanel.deleteBooks(new deletebook());
		
		this.adminpanel.addUsers(new adduser());
		this.adminpanel.updateUsers(new updateuser());
		this.adminpanel.deleteUsers(new deleteuser());
		this.adminpanel.listUsers(new viewusers());
		
		this.adminpanel.reportCSV(new reportcsv());
		this.adminpanel.reportPDF(new reportpdf());
	}
	
	class addbook implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String title = adminpanel.getTitleTextField();
			String author=adminpanel.getAuthorTextField();
			String genre= adminpanel.getGenreTextField();
			int quantity = Integer.parseInt(adminpanel.getQuantityTextField());
			int price = Integer.parseInt(adminpanel.getPriceTextField());
			String id = adminpanel.getIdBookTextField();
			
			b.addBook(id, title, author, genre, quantity, price);
			
		}
	}
	
	class deletebook implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String title=adminpanel.getTitleTextField();
			
			b.deleteBook(title);
		}
	}
	
	class updatebook implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String title=adminpanel.getTitleTextField();
			int quantity = Integer.parseInt(adminpanel.getQuantityTextField());
			int price = Integer.parseInt(adminpanel.getPriceTextField());
			
			b.updateBook(title, price, quantity);
		}
	}
	
	class viewbooks implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String s="ID      Titlu      Autor       Gen      Cantitate       Pret"+"\n";
			ArrayList<String> list = b.listBooks();
			//frame1.setVisible(false);
			panel.getFrame().setVisible(true);
			for(int i = 0; i < list.size(); i++) {   
				s=s+list.get(i)+"    "+"\n";
				
			}
			panel.getTextArea().setText(s);
		}
	}
	
	class adduser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String id=adminpanel.getIdUserTextField();
			String username=adminpanel.getUsernameTextField();
			String password=adminpanel.getPasswordTextField();
			boolean isAdmin=Boolean.parseBoolean(adminpanel.getIsAdminTextField());
			
			u.addUser(id, username, password,isAdmin);
			
		}
	}
	
	class deleteuser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String username=adminpanel.getUsernameTextField();
			u.deleteUser(username);
			
		}
	}
	
	class updateuser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			String id=adminpanel.getIdUserTextField();
			String username=adminpanel.getUsernameTextField();
			String password=adminpanel.getPasswordTextField();
			boolean isAdmin=Boolean.parseBoolean(adminpanel.getIsAdminTextField());
			
			u.updateUser(id, username, password, isAdmin);
		}
	}
	
	class viewusers implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String s="ID      Username      Password       isAdmin "+"\n";
			ArrayList<String> list = u.listUsers();
			//frame1.setVisible(false);
			panel.getFrame().setVisible(true);
			for(int i = 0; i < list.size(); i++) {   
				s=s+list.get(i)+"    "+"\n";
				
			}
			panel.getTextArea().setText(s);
			
		}
	}
	
	class reportpdf implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ReadFileBook b =new ReadFileBook("Carti.xml");
			ArrayList<Book> list =b.getList();
			
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getQuantity()==0)
				{
					report1.generateReport(list.get(i).getTitle(), list.get(i).getAuthor());
				}
			}
			PDF.document.close();
			
		}
		
	}
	
	class reportcsv implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			ReadFileBook b =new ReadFileBook("Carti.xml");
			ArrayList<Book> list =b.getList();
			
			for(int i=0;i<list.size();i++)
			{
				if(list.get(i).getQuantity()==0)
				{
					report2.generateReport(list.get(i).getTitle(), list.get(i).getAuthor());
				}
			}
		}
		
	}
}
