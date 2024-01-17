package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BookDAO;


@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		BookDAO bDao = new BookDAO();
		
		try {
			request.setAttribute("bookList", bDao.getAllBookList());
			
			String view = "/WEB-INF/views/list.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	BookDAO bDao = new BookDAO();
	
	try {
		request.setAttribute("bookList", bDao.getAllBookList());
		
		String view = "/WEB-INF/views/list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

}
