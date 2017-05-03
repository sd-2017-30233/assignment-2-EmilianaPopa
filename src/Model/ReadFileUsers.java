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

public class ReadFileUsers {
	
	ArrayList<User> list = new ArrayList<User>();
	
	public ReadFileUsers(String fis)
	{
		parseFile(fis);
	}
	
	public ReadFileUsers(){}
	public void parseFile(String fis){
		try{
			File fxml =new File(fis);
			
			DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dbF.newDocumentBuilder();
			Document d = dB.parse(fxml);
			
			d.getDocumentElement().normalize();
			NodeList nL = d.getElementsByTagName("user");
			
			for(int i=0; i<nL.getLength();i++)
			{
				Node n = nL.item(i);
				User u=null;
				
				if(n.getNodeType() == Node.ELEMENT_NODE)
				{
					Element el= (Element) n;
					
					String id = el.getAttribute("id");
					String username = el.getElementsByTagName("username").item(0).getTextContent();
					String password = el.getElementsByTagName("password").item(0).getTextContent();
					String admin = el.getElementsByTagName("ad").item(0).getTextContent();
					
					
					u = new User(id, username, password,Boolean.parseBoolean(admin));
				}
				list.add(u);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<User> getList()
	{
		return this.list;
	}
}
