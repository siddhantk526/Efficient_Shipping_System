package com.app.EfficientSS.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Auction_Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="A_item_id")
	private int A_item_id;
	@Column(name="a_item_details")
	private String a_item_details;
	
	@Column(name="highest_bid_price",nullable=false)
	private int highest_bid_price;
	@Column(name="a_start_datetime",nullable=false)
	private String A_start_datetime;
	@Column(name="a_end_datetime",nullable=false)
	private String A_end_datetime;
	@Column(name="a_item_Comments")
	private String A_item_Comments;
	@Column(name="a_item_status")
	private String a_item_status;
	@Column(name="timer")
	private String Timer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id",referencedColumnName="cust_id")
	private Customer customer;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="item_Id",referencedColumnName="item_Id")
	private Item_Details item_detail;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="auction_item")
	    private List<Bidder> bidder;


	public Auction_Item() {
		
	}



	public Auction_Item(int a_item_id, String a_item_details, int highest_bid_price, String a_start_datetime,
			String a_end_datetime, String a_item_Comments, String a_item_status, String timer, Customer customer,
			Item_Details item_detail, List<Bidder> bidder) {
		super();
		A_item_id = a_item_id;
		this.a_item_details = a_item_details;
		this.highest_bid_price = highest_bid_price;
		A_start_datetime = a_start_datetime;
		A_end_datetime = a_end_datetime;
		A_item_Comments = a_item_Comments;
		this.a_item_status = a_item_status;
		Timer = timer;
		this.customer = customer;
		this.item_detail = item_detail;
		this.bidder = bidder;
	}



	public int getA_item_id() {
		return A_item_id;
	}

	public void setA_item_id(int a_item_id) {
		A_item_id = a_item_id;
	}

	public String getA_item_details() {
		return a_item_details;
	}



	public int getHighest_bid_price() {
		return highest_bid_price;
	}

	public void setHighest_bid_price(int highest_bid_price) {
		this.highest_bid_price = highest_bid_price;
	}

	public String getA_start_datetime() {
		return A_start_datetime;
	}

	public void setA_start_datetime(String a_start_datetime) {
		A_start_datetime = a_start_datetime;
	}

	public String getA_end_datetime() {
		return A_end_datetime;
	}

	public void setA_end_datetime(String a_end_datetime) {
		A_end_datetime = a_end_datetime;
	}

	public String getA_item_Comments() {
		return A_item_Comments;
	}

	public void setA_item_Comments(String a_item_Comments) {
		A_item_Comments = a_item_Comments;
	}

	public String getA_item_status() {
		return a_item_status;
	}

	

	@Override
	public String toString() {
		return "Auction_Item [A_item_id=" + A_item_id + ", a_item_details=" + a_item_details + ", highest_bid_price="
				+ highest_bid_price + ", A_start_datetime=" + A_start_datetime + ", A_end_datetime=" + A_end_datetime
				+ ", A_item_Comments=" + A_item_Comments + ", a_item_status=" + a_item_status + ", Timer=" + Timer
				+ ", customer=" + customer + ", item_detail=" + item_detail + ", bidder=" + bidder + "]";
	}



	public void setA_item_details(String a_item_details) {
		this.a_item_details = a_item_details;
	}



	public void setA_item_status(String a_item_status) {
		this.a_item_status = a_item_status;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item_Details getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(Item_Details item_detail) {
		this.item_detail = item_detail;
	}

	public List<Bidder> getBidder() {
		return bidder;
	}

	public void setBidder(List<Bidder> bidder) {
		this.bidder = bidder;
	}

	public String getTimer() {
		return Timer;
	}

	public void setTimer(String timer) {
		Timer = timer;
	}

	
}
