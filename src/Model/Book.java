package Model;

import java.util.ArrayList;

public class Book {
	private String id;
	private String title;
	private String author;
	private String genre;
	private int quantity;
	private int price;
	
	public Book(){}
	public Book(String i,String t, String a, String g, int q, int p)
	{
		this.id=i;
		this.title=t;
		this.author=a;
		this.genre=g;
		this.quantity=q;
		this.price=p;
	}
	
	public Book(String i,String t, String a, int q, int p)
	{
		this.id=i;
		this.title=t;
		this.author=a;
		this.quantity=q;
		this.price=p;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public String getGenre()
	{
		return this.genre;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public void setQuantity(int q)
	{
		this.quantity=q;
	}
	
	public void setPrice(int p)
	{
		this.price=p;
	}
	
public void addBook(String i,String t, String a, String g, int q, int p){
	ReadFileBook b =new ReadFileBook("Carti.xml");
	ArrayList<Book> list =b.getList();
	boolean ok= true;
	for(int j=0;j<list.size();j++)
	{
		if(list.get(j).getTitle().equals(t))
		{
			ok=false;
			list.get(j).setQuantity(list.get(j).getQuantity()+q);
		}
	}
	
	if(ok==true)
		list.add(new Book(i,t,a,g,q,p));
	WriteFileBook b1 = new WriteFileBook();
	b1.scriereFis("Carti.xml", list);
	
	
}
	
	public void deleteBook(String title){
		ReadFileBook b =new ReadFileBook("Carti.xml");
		ArrayList<Book> list =b.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getTitle().equals(title))
			{
				list.remove(i);
			}
		}
		WriteFileBook b1 = new WriteFileBook();
		b1.scriereFis("Carti.xml", list);
	}
	
	public void updateBook(String title, int p, int q){
		ReadFileBook b =new ReadFileBook("Carti.xml");
		ArrayList<Book> list =b.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getTitle().equals(title))
			{
				list.get(i).setPrice(p);
				list.get(i).setQuantity(q);
			}
		}
		WriteFileBook b1 = new WriteFileBook();
		b1.scriereFis("Carti.xml", list);
	}
	
	public ArrayList<String> listBooks(){
		ReadFileBook b =new ReadFileBook("Carti.xml");
		ArrayList<Book> lista =b.getList();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<lista.size();i++)
		{
			list.add(lista.get(i).getID()+"   "+lista.get(i).getTitle()+"   "+lista.get(i).getAuthor()+"   "+lista.get(i).getGenre()+"   "+lista.get(i).getQuantity()+"   "+lista.get(i).getPrice());
		}
		return list;
	}
	
	public Book searchBook(String s)
	{
		ReadFileBook b =new ReadFileBook("Carti.xml");
		ArrayList<Book> list =b.getList();
		
		Book b1= null;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getAuthor().equals(s) ||list.get(i).getTitle().equals(s) ||list.get(i).getGenre().equals(s))	
			{
				b1=list.get(i);
			}
			 
		}
		return b1;
		
	}
	
	public void sellBook(String t, int nr)
	{
		ReadFileBook b =new ReadFileBook("Carti.xml");
		ReadFileSellings sl = new ReadFileSellings("Selling.xml");
		
		ArrayList<Book> list =b.getList();
		ArrayList<Book> l =sl.getList();
		
		for(int i=0;i<list.size();i++)
		{
			if((list.get(i).getTitle().equals(t))&& (list.get(i).getQuantity()>=nr))
			{
				
				int q = list.get(i).getQuantity();
				list.get(i).setQuantity(q-nr);
				Book bk = new Book(list.get(i).getID(),list.get(i).getTitle(),list.get(i).getAuthor(),nr,list.get(i).getPrice()*nr);
				l.add(bk);
			}
			else 
			{
				System.out.println("Nu exista cartea sau nu mai este in stoc.");
			}
		}
		WriteFileSellings s=new WriteFileSellings();
		WriteFileBook b1 = new WriteFileBook();
		b1.scriereFis("Carti.xml", list);
		s.scriereFis("Selling.xml",l);
	}
}
