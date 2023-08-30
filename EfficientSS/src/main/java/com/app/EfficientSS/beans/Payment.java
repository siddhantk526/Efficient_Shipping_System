package com.app.EfficientSS.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private int transaction_id;
	@Column(name="account_number",nullable=false)
	private String account_number;
	@Column(name="bank_balance")
	private long bank_balance;
	@Column(name="cust_payment")
	private long cust_payment;
	@Column(name="t_payment")
	private long t_payment;
	@Column(name="cust_name")
	private String cust_name;
	@Column(name="t_name")
	private String t_name;
	@Column(name="payment_status")
	private String payment_status;
	
	@Column(name="paymentId")
	private String paymentId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"}) // Exclude Hibernate proxy
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_Id", referencedColumnName = "item_Id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"}) // Exclude Hibernate proxy
    private Item_Details item_detail;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "t_id", referencedColumnName = "t_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"}) // Exclude Hibernate proxy
    private Transporter transporter;

	

	public Payment() {
		
	}

	



	public Payment(int transaction_id, String account_number, long bank_balance, long cust_payment, long t_payment,
			String cust_name, String t_name, String payment_status, String paymentId, Customer customer,
			Item_Details item_detail, Transporter transporter) {
		super();
		this.transaction_id = transaction_id;
		this.account_number = account_number;
		this.bank_balance = bank_balance;
		this.cust_payment = cust_payment;
		this.t_payment = t_payment;
		this.cust_name = cust_name;
		this.t_name = t_name;
		this.payment_status = payment_status;
		this.paymentId = paymentId;
		this.customer = customer;
		this.item_detail = item_detail;
		this.transporter = transporter;
	}





	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public long getBank_balance() {
		return bank_balance;
	}

	public void setBank_balance(long bank_balance) {
		this.bank_balance = bank_balance;
	}

	

	public long getT_payment() {
		return t_payment;
	}

	public void setT_payment(long t_payment) {
		this.t_payment = t_payment;
	}

	

	public long getCust_payment() {
		return cust_payment;
	}

	public void setCust_payment(long cust_payment) {
		this.cust_payment = cust_payment;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
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

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}
	
	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
