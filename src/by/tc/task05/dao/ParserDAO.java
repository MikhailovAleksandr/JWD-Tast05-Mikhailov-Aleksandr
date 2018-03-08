package by.tc.task05.dao;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.tc.task05.entity.Book;

public interface ParserDAO  {
	List<Book> getBooksData()throws ParserConfigurationException, SAXException, IOException;
}
