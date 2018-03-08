package by.tc.task05.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import by.tc.task05.entity.Book;
import by.tc.task05.service.ParserService;
import by.tc.task05.service.ServiceFactory;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
        page = Integer.parseInt(request.getParameter("page"));
        
        ServiceFactory factory = ServiceFactory.getInstance();
        ParserService service = factory.getService();
        service.setParserName(request.getParameter("parserName"));
        
        List<Book> books = service.getBooksData(page);
        int numberOfBooks = service.getNumberOfBooks();
        int numberOfPages = (int) Math.ceil(numberOfBooks * 1.0 / recordsPerPage);
        request.setAttribute("bookList", books);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
		}catch (SAXException e) {
			e.getMessage();
		}catch (ParserConfigurationException e) {
			e.getMessage();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
