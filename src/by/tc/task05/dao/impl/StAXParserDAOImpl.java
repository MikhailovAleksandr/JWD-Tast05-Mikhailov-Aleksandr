package by.tc.task05.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.tc.task05.dao.ParserDAO;
import by.tc.task05.dao.impl.handler.BookStAXHandler;
import by.tc.task05.entity.Book;

public class StAXParserDAOImpl implements ParserDAO {
	
	public List<Book> getBooksData() throws FileNotFoundException{
		
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		List<Book> library = new ArrayList<Book>();
		try {
			InputStream input = new FileInputStream("resources/books.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			BookStAXHandler handler = new BookStAXHandler();
			library = handler.process(reader);
		} catch(XMLStreamException e){
			
		}
		return library;
	}

}
