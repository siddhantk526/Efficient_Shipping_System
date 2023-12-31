package com.app.EfficientSS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.EfficientSS.beans.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{

	@Query(value="SELECT * FROM Customer WHERE cust_email_id = ?",nativeQuery = true)
	Customer findByEmail(String cust_email_id);



	

}
