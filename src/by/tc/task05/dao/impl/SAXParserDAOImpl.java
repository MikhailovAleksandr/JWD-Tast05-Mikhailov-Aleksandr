package by.tc.task05.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import by.tc.task05.dao.impl.handler.BookSAXHandler;
import by.tc.task05.dao.ParserDAO;
import by.tc.task05.entity.Book;

public class SAXParserDAOImpl implements ParserDAO {
	
	public List<Book> getBooksData() throws ParserConfigurationException, SAXException, IOException{
		
		SAXParser saxParser = SAXParserFactory.newDefaultInstance().newSAXParser();
		XMLReader reader = saxParser.getXMLReader();
		BookSAXHandler handler = new BookSAXHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("resources/books/xml"));
		
		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://xml.org/sax/features/namespace", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", true);
		
		List<Book> bookData = handler.getBookList();
		return bookData;
	}

}
