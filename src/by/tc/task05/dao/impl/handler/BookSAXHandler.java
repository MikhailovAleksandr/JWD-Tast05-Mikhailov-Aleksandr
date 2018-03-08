package by.tc.task05.dao.impl.handler;

import java.util.List;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.tc.task05.entity.Book;
import by.tc.task05.entity.BookTagName;

public class BookSAXHandler extends DefaultHandler {

	private Book book;
	private List<Book> bookList = new ArrayList<Book>();
	private StringBuilder text;
	
	public List<Book> getBookList(){
		return bookList;
	}
	
	public void startDocument() throws SAXException{
	}
	
	public void endDocument() throws SAXException{
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		text = new StringBuilder();
		if(qName.equals("book")) {
			book = new Book();
			book.setId((String.valueOf(attributes.getValue("id"))));
		}
	}
	
	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException{
		BookTagName tagName = BookTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch(tagName) {
		case AUTHOR: 
			book.setAuthor(text.toString()); 
			break;
		case TITLE: 
			book.setTitle(text.toString()); 
			break;
		case GENRE: 
			book.setGenre(text.toString()); 
			break;
		case PRICE: 
			book.setPrice(Double.parseDouble(text.toString())); 
			break;
		case BOOK: 
			bookList.add(book); 
			book = null; 
			break;
		}
	}
	
	
	
}
