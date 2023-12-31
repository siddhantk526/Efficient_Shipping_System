package com.app.EfficientSS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.EfficientSS.beans.Admin;
import com.app.EfficientSS.beans.Item_Details;
import com.app.EfficientSS.service.CustomerService;
import com.app.EfficientSS.service.ItemService;
import com.app.EfficientSS.service.ItemServiceImpl;

@CrossOrigin(origins=("http://localhost:3000"))
@RestController
public class ItemController{

	@Autowired
	ItemService itemService;
	
	@Autowired
	CustomerService Cust_service;
	
	@PostMapping("customer/itemdetails")
	public ResponseEntity<HttpStatus> itemRegistration(@RequestBody Item_Details itemdetail,@RequestParam int cust_id) {

	  	return itemService.saveitem(itemdetail,cust_id);
	  	
 }
	
	@GetMapping("customer/itemdetails/{cust_id}")
	public ResponseEntity<List<Item_Details>> getAllItemsForCustomer(@PathVariable int cust_id)
	{
	
		List<Item_Details> itemlist=itemService.getAllItemsForCustomer(cust_id);
		if(itemlist!=null)
			return  new ResponseEntity<>(itemlist,HttpStatus.OK);
		else 
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/itemdetails/{cust_id}")
	public ResponseEntity<List<Item_Details>> itemDetail(@PathVariable("cust_id") int id) {				//CustomerId

		List<Item_Details> itemlist=itemService.getAllItem(id);
		if(itemlist!=null) {
			   return ResponseEntity.ok(itemlist);
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	}
}
