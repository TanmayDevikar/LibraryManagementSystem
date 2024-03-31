package com.LMS.model;

public class Book {
	private String bookID;
	private String title;
	private int edition;
	private String publishedDate;
	private String author;
	private String catogery;
	private int noOfCopies;
	private String memberId;
	
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCatogery() {
		return catogery;
	}
	public void setCatogery(String catogery) {
		this.catogery = catogery;
	}
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", edition=" + edition + ", publishedDate="
				+ publishedDate + ", author=" + author + ", catogery=" + catogery + ", noOfCopies=" + noOfCopies + "]";
	}
	
	
	
}
