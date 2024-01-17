package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BookDAO;

@WebServlet("/newbook")
public class NewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/new-book.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String janCd = request.getParameter("janCd");
		String isbnCd = request.getParameter("isbnCd");
		String bookNm = request.getParameter("bookNm");
		String bookKana = request.getParameter("bookKana");
		int price = Integer.parseInt(request.getParameter("price"));
//		Date issueDate = request.getParameter("issueDate");
		
		BookDAO bDao = new BookDAO();
		
		try {
			int result = bDao.newBook(janCd, isbnCd, bookNm, bookKana, price);
			if(result == 1) {
				response.sendRedirect("ListServlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
