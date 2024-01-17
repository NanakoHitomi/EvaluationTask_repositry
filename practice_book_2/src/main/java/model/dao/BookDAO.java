package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.bean.BookBean;

public class BookDAO {
	
	//本の全情報取得（一覧）
	public List<BookBean> getAllBookList() throws SQLException, ClassNotFoundException {
		List<BookBean> list = new ArrayList<BookBean>();
		String sql = "SELECT * FROM BOOK";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
//				BookBean book = new BookBean();
//				book.setJanCd(res.getString("JAN_CD"));
//				book.setIsbnCd(res.getString("ISBN_CD"));
//				book.setBookNm(res.getString("BOOK_NM"));
//				book.setBookKana(res.getString("BOOK_KANA"));
//				book.setPrice(res.getInt("PRICE"));
//				book.setIssueDate(res.getDate("ISSUE_DATE"));
//				book.setCreateDate(res.getTimestamp("CREATE_DATETIME"));
//				book.setUpdateDate(res.getTimestamp(0));
				String JAN_CD = res.getString("JAN_CD");
				String ISBN_CD = res.getString("ISBN_CD");
				String BOOK_NM = res.getString("BOOK_NM");
				String BOOK_KANA = res.getString("BOOK_KANA");
				int PRICE = res.getInt("PRICE");
				Date ISSUE_DATE = res.getDate("ISSUE_DATE");
				Date CREATE_DATETIME = res.getDate("CREATE_DATETIME");
				Date UPDATE_DATETIME = res.getDate("UPDATE_DATETIME");
				
				list.add(new BookBean(JAN_CD, ISBN_CD, BOOK_NM, BOOK_KANA, PRICE, ISSUE_DATE, CREATE_DATETIME, UPDATE_DATETIME));
				
			}
		}
		return list;
	}
	
	//編集内容表示用
//	public List<BookBean> getBookDetail(String janCd) throws ClassNotFoundException, SQLException {
//		List<BookBean> bookList = new ArrayList<BookBean>();
//		String sql = "SELECT * FROM BOOK WHERE JAN_CD = ?";
//		
//		try (Connection conn = DBConnection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setString(1, janCd);
//			ResultSet res = pstmt.executeQuery();
//			while(res.next()) {
//				String JAN_CD = res.getString("JAN_CD");
//				String ISBN_CD = res.getString("ISBN_CD");
//				String BOOK_NM = res.getString("BOOK_NM");
//				String BOOK_KANA = res.getString("BOOK_KANA");
//				int PRICE = res.getInt("PRICE");
//				Date ISSUE_DATE = res.getDate("ISSUE_DATE");
//				Date CREATE_DATETIME = res.getDate("CREATE_DATETIME");
//				Date UPDATE_DATETIME = res.getDate("UPDATE_DATETIME");
//				
//				BookBean bookLists = new BookBean(JAN_CD, ISBN_CD, BOOK_NM, BOOK_KANA, PRICE, ISSUE_DATE, CREATE_DATETIME, UPDATE_DATETIME);
//				
//				bookLists.setJanCd(JAN_CD);
//				bookLists.setIsbnCd(ISBN_CD);
//				bookLists.setBookNm(BOOK_NM);
//				bookLists.setBookKana(BOOK_KANA);
//				bookLists.setPrice(PRICE);
//				bookLists.setIssueDate(ISSUE_DATE);
//				bookLists.setCreateDate(CREATE_DATETIME);
//				bookLists.setUpdateDate(UPDATE_DATETIME);
//				
//				bookList.add(bookLists);
//				
//			}
//		}
//		return bookList;
//	}
	
	//書籍新規追加
	public int newBook(String janCd, String isbnCd, String bookNm, String bookKana, int price) throws ClassNotFoundException, SQLException {
		int processingNum = 0;
		String sql = "INSERT INTO BOOK (JAN_CD, ISBN_CD, BOOK_NM, BOOK_KANA, PRICE) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, janCd);
			pstmt.setString(2, isbnCd);
			pstmt.setString(3, bookNm);
			pstmt.setString(4, bookKana);
			pstmt.setInt(5, price);
//			pstmt.setDate(6, issueDate);
			processingNum = pstmt.executeUpdate();
		}
		return processingNum;
	}
	
	//削除
	public int deleteBook (String janCd) throws ClassNotFoundException, SQLException {
		int processingNum = 0;
		String sql = "DELETE FROM BOOK WHERE JAN_CD = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, janCd);
			pstmt.executeUpdate();
			processingNum = pstmt.executeUpdate();
		}
		return processingNum;
	}
	
//書籍詳細表示
	public BookBean detailBook(String janCd) throws ClassNotFoundException, SQLException {
		
		BookBean book = new BookBean();
		String sql = "SELECT * FROM BOOK WHERE JAN_CD = ? ";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, janCd);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				book.setJanCd(res.getString("JAN_CD"));
				book.setIsbnCd(res.getString("ISBN_CD"));
				book.setBookNm(res.getString("BOOK_NM"));
				book.setBookKana(res.getString("BOOK_KANA"));
				book.setPrice(res.getInt("PRICE"));
				book.setIssueDate(res.getDate("ISSUE_DATE"));
			}	
		}
		return book;
	}
	
	//書籍編集
	public int bookUpdate (String janCd, String isbnCd, String bookNm, String bookKana, int price) throws ClassNotFoundException, SQLException {
		int processingNum = 0;
		String sql = "UPDATE BOOK SET ISBN_CD = ?, BOOK_NM = ?, BOOK_KANA = ?, PRICE = ? WHERE  JAN_CD = ?";
		try ( Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, isbnCd);
			pstmt.setString(2, bookNm);
			pstmt.setString(3, bookKana);
			pstmt.setInt(4, price);
			pstmt.setString(5, janCd);
			
			processingNum = pstmt.executeUpdate();
		}
		return processingNum;
	}
	
}
