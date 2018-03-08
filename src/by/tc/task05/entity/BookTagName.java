package by.tc.task05.entity;

public enum BookTagName {
	ID, AUTHOR, TITLE, GENRE, PRICE, BOOK;
	
	public static BookTagName getElementTagName(String element) {
		switch(element) {
		case "book": return BOOK;
		case "author": return AUTHOR;
		case "title": return TITLE;
		case "genre": return GENRE;
		case "price": return PRICE;
		default: throw new EnumConstantNotPresentException(BookTagName.class,element);
		}
	}
	
}
