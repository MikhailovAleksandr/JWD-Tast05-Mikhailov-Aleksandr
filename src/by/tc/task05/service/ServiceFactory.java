package by.tc.task05.service;

import by.tc.task05.service.impl.ParserServiceImpl;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public ParserService getService() {
		return new ParserServiceImpl();
	}

}
