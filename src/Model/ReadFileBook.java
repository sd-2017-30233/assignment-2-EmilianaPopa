package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadFileBook {
	
	ArrayList<Book> list = new ArrayList<Book>();
	
	public ReadFileBook(String fis)
	{
		parseFile(fis);
	}
	public void parseFile(String fis){
		try{
			File fxml =new File(fis);
			
			DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dbF.newDocumentBuilder();
			Document d = dB.parse(fxml);
			
			d.getDocumentElement().normalize();
			NodeList nL = d.getElementsByTagName("book");
			
			for(int i=0; i<nL.getLength();i++)
			{
				Node n = nL.item(i);
				Book b=null;
				
				if(n.getNodeType() == Node.ELEMENT_NODE)
				{
					Element el= (Element) n;
					
					String id = el.getAttribute("id");
					String titlu = el.getElementsByTagName("title").item(0).getTextContent();
					String autor = el.getElementsByTagName("author").item(0).getTextContent();
					String gen = el.getElementsByTagName("genre").item(0).getTextContent();
					String cant = el.getElementsByTagName("quantity").item(0).getTextContent();
					String pret = el.getElementsByTagName("price").item(0).getTextContent();
			
					
					b = new Book(id, titlu, autor, gen, Integer.parseInt(cant), Integer.parseInt(pret));
				}
				list.add(b);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<Book> getList()
	{
		return this.list;
		
	}
}
