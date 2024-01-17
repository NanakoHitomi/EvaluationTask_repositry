package model.bean;

import java.io.Serializable;
import java.sql.Date;

public class BookBean implements Serializable {
	
	private String janCd;
	private String isbnCd;
	private String bookNm;
	private String bookKana;
	private int price;
	private Date issueDate;
	private Date createDate;
	private Date updateDate;
	
	public BookBean() {
		
	}

	public BookBean(String janCd, String isbnCd, String bookNm, String bookKana, int price, Date issueDate,
			Date createDate, Date updateDate) {
		super();
		this.janCd = janCd;
		this.isbnCd = isbnCd;
		this.bookNm = bookNm;
		this.bookKana = bookKana;
		this.price = price;
		this.issueDate = issueDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public String getJanCd() {
		return janCd;
	}

	public void setJanCd(String janCd) {
		this.janCd = janCd;
	}

	public String getIsbnCd() {
		return isbnCd;
	}

	public void setIsbnCd(String isbnCd) {
		this.isbnCd = isbnCd;
	}

	public String getBookNm() {
		return bookNm;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	public String getBookKana() {
		return bookKana;
	}

	public void setBookKana(String bookKana) {
		this.bookKana = bookKana;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	

}
