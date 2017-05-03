package Model;

import java.util.ArrayList;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteFileUsers {
	public void scriereFis(String fis, ArrayList<User> u){
		try{
			
			System.out.println(" Aici ");
			DocumentBuilderFactory dF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dF.newDocumentBuilder();
			Document d = dB.newDocument();
			Element el = d.createElement("users");
			d.appendChild(el);
			
			for(int i=0; i<u.size(); i++){
				
				//lista de elemente
				Element e = d.createElement("user");
				el.appendChild(e);
				
				//seteaza atributele in lista de elemente
				Attr atr = d.createAttribute("id");
				atr.setValue(u.get(i).getID());
				e.setAttributeNode(atr);
				
				Element nume = d.createElement("username");
				nume.appendChild(d.createTextNode(u.get(i).getUsername()));
				e.appendChild(nume);
				
				Element pw = d.createElement("password");
				pw.appendChild(d.createTextNode(u.get(i).getPassword()));
				e.appendChild(pw);
				
				Element ad = d.createElement("ad");
				ad.appendChild(d.createTextNode(Boolean.toString(u.get(i).getAdmin())));
				e.appendChild(ad);
				
				//scrie in fis xml
				TransformerFactory tF = TransformerFactory.newInstance();
				Transformer t = tF.newTransformer();
				DOMSource s = new DOMSource(d);
				StreamResult res = new StreamResult(new File(fis));
			
				t.transform(s, res);
				System.out.println("Scriere Users");
			}
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}
}
