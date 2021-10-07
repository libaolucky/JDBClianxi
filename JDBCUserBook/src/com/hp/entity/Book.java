package com.hp.entity;

public class Book {
	private Integer id;
	private String bname;
	private Double bprice;
	private String bauthor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Double getBprice() {
		return bprice;
	}
	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public Book(Integer id, String bname, Double bprice, String bauthor) {
		super();
		this.id = id;
		this.bname = bname;
		this.bprice = bprice;
		this.bauthor = bauthor;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Book [id=" + id + ", bname=" + bname + ", bprice=" + bprice
				+ ", bauthor=" + bauthor + "]";
	}
	public Book(String bname, Double bprice, String bauthor) {
		super();
		this.bname = bname;
		this.bprice = bprice;
		this.bauthor = bauthor;
	}
	
	
}
