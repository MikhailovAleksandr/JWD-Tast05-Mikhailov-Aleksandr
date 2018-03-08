package by.tc.task05.dao;

import by.tc.task05.dao.impl.DOMParserDAOImpl;
import by.tc.task05.dao.impl.SAXParserDAOImpl;
import by.tc.task05.dao.impl.StAXParserDAOImpl;

public class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public ParserDAO getParser(String name) {
		
		switch(name.toUpperCase()) {
		case "DOM": return new DOMParserDAOImpl();
		case "STAX":return new SAXParserDAOImpl();
		case "SAX":return new StAXParserDAOImpl();
		default: return null;
		}
	}

}
