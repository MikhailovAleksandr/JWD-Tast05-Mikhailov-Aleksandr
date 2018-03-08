package by.tc.task05.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.tc.task05.dao.ParserDAO;
import by.tc.task05.entity.Book;

public class DOMParserDAOImpl implements ParserDAO {
	
	public List<Book> getBooksData() throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("main/resources/books.xml");
		
		Element root = document.getDocumentElement();
		
		List<Book> library = new ArrayList<Book>();
		
		NodeList bookNodes = root.getElementsByTagName("book");
		Book book = null;
		for(int i = 0; i < bookNodes.getLength(); i++) {
			book = new Book();
			Element bookElement = (Element) bookNodes.item(i);
			book.setId(String.valueOf(bookElement.getAttribute("id")));
			book.setAuthor(this.getSingleChild(bookElement, "author").getTextContent().trim());
			book.setTitle(this.getSingleChild(bookElement, "title").getTextContent().trim());
			book.setGenre(this.getSingleChild(bookElement, "genre").getTextContent().trim());
			book.setPrice(Double.parseDouble(this.getSingleChild(bookElement, "price").getTextContent().trim()));
			library.add(book);
		}
		return library;
	}
	
	private Element getSingleChild(Element element, String childName) {
		NodeList nList = element.getElementsByTagName(childName);
		Element child = (Element) nList.item(0);
		return child;
	}

}
