package by.tc.task05.entity;

public enum BookTagName {
	ID, AUTHOR, TITLE, GENRE, PRICE, BOOK, CATALOG;
	
	public static BookTagName getElementTagName(String element) {
		switch(element) {
		case "book": return BOOK;
		case "author": return AUTHOR;
		case "title": return TITLE;
		case "genre": return GENRE;
		case "price": return PRICE;
		case "catalog": return CATALOG;
		default: throw new EnumConstantNotPresentException(BookTagName.class,element);
		}
	}
	
}
