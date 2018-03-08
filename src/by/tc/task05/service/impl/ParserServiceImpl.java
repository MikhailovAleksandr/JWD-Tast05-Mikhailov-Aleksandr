package by.tc.task05.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.tc.task05.dao.DAOFactory;
import by.tc.task05.dao.ParserDAO;
import by.tc.task05.entity.Book;
import by.tc.task05.service.ParserService;

public class ParserServiceImpl implements ParserService {
	
	private String parserName;
	
	private int numberOfBooks;
	
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	public void setParserName(String parserName) {
		this.parserName = parserName;
	}
	
	public List<Book> getBooksData(int numberOfPage) throws IOException, ParserConfigurationException, SAXException{

		ParserDAO parserDAO = daoFactory.getParser(parserName);
		
		List<Book> library = parserDAO.getBooksData();
		
		List<Book> libraryPart = new ArrayList<Book>();
		
		for(int i = 0; i < 5;i++) {
			libraryPart.add(library.get(numberOfPage-1));
			if(numberOfPage + i == library.size()) {
				break;
			}
		}
		
		numberOfBooks = library.size();
		
		return libraryPart;
	}
	
	public int getNumberOfBooks() {
		return numberOfBooks;
	}

}
