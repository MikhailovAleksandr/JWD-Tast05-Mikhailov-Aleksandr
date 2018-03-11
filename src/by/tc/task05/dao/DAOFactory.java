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
		case "STAX":return new StAXParserDAOImpl();
		case "SAX":return new SAXParserDAOImpl();
		default: return null;
		}
	}

}
