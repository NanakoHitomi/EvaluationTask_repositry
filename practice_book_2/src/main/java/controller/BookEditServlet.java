package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.BookBean;
import model.dao.BookDAO;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookBean book = new BookBean();
		BookDAO bDao = new BookDAO();
		
		String janCd = request.getParameter("janCd");
		
		try {
			
			book = bDao.detailBook(janCd);
			request.setAttribute("book", book); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		String view = "/WEB-INF/views/book-edit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//パラメータ取得
		String janCd = request.getParameter("janCd");
		String isbnCd = request.getParameter("isbnCd");
		String bookNm = request.getParameter("bookNm");
		String bookKana = request.getParameter("bookKana");
		int price = Integer.parseInt(request.getParameter("price"));
//		Date issueDate = request.getParameter("issueDate");
		
		//データベース更新
		try {
			BookDAO bDao = new BookDAO();
			int bookUpdated = bDao.bookUpdate(janCd, isbnCd, bookNm, bookKana, price);
			
			request.getSession().setAttribute("bUp", bookUpdated);
			
			if (bookUpdated > 0) {
				
				String forward = "/ListServlet?janCd = " + janCd;
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
				dispatcher.forward(request, response);
				
				System.out.println("成功");
			} else {
				System.out.println("失敗");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
