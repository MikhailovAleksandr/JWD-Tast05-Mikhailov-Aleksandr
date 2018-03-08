package by.tc.task05.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.tc.task05.entity.Book;

public interface ParserService {
	
	void setParserName(String parserName);

	List<Book> getBooksData(int numberOfPage) throws IOException, ParserConfigurationException, SAXException;

	int getNumberOfBooks();
}
