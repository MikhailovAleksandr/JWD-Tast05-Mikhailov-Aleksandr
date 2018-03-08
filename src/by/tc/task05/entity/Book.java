package by.tc.task05.entity;

public class Book {
	
	private String id;

	private String author;
	
	private String title;
	
	private String genre;
	
	private double price;
	
	public Book() {}
	
	public Book(String id, String author, String title, String genre, double price) {
		
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.price = price;
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(null == obj) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Book book = (Book) obj;
		
		if(null == id) {
			if(id != book.id)
			return false;
		}else {
			if(!id.equals(book.id)) {
				return false;
			}
		}
		
		if(null == author) {
			if(author != book.author)
			return false;
		}else {
			if(!author.equals(book.author)) {
				return false;
			}
		}
		
		if(null == title) {
			if(title != book.title)
			return false;
		}else {
			if(!title.equals(book.title)) {
				return false;
			}
		}
		
		if(null == genre) {
			if(genre != book.genre)
			return false;
		}else {
			if(!genre.equals(book.genre)) {
				return false;
			}
		}
		
		if(price != book.price) {
			return false;
		}
		return true;
	}
	
	public int hashcode() {
		
		final int PRIME = 31;
		int result = 1;
		result = ((((result * PRIME + id.hashCode())*PRIME + author.hashCode())*PRIME + title.hashCode())*PRIME + genre.hashCode())*PRIME + (int)price; 
		return result;
	}
	
}
