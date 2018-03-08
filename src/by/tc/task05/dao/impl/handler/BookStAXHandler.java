package by.tc.task05.dao.impl.handler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.tc.task05.entity.Book;
import by.tc.task05.entity.BookTagName;

public class BookStAXHandler {

	public List<Book> process(XMLStreamReader reader) throws XMLStreamException{
		
		Book book = null;
		List<Book> library = new ArrayList<Book>();
		BookTagName elementName = null;
		while(reader.hasNext()) {
			int type = reader.next();
			switch(type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = BookTagName.getElementTagName(reader.getLocalName());
				switch(elementName) {
				case BOOK: 
					book = new Book(); 
					String id = String.valueOf(reader.getAttributeValue(null, "id"));
					book.setId(id);
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				
				if(text.isEmpty()) {
					break;
				}
				switch(elementName) {
				case AUTHOR: 
					book.setAuthor(text); 
					break;
				case TITLE: 
					book.setTitle(text); 
					break;
				case GENRE: 
					book.setGenre(text); 
					break;
				case PRICE: 
					book.setPrice(Double.parseDouble(text));
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = BookTagName.getElementTagName(reader.getLocalName());
				switch(elementName) {
				case BOOK: library.add(book);
				}
			}
		}
		return library;
	}
}
