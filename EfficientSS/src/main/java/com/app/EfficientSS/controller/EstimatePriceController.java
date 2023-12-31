package com.app.EfficientSS.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.EfficientSS.beans.EstimatePrice;
import com.app.EfficientSS.beans.Price;
import com.app.EfficientSS.service.EstimatePriceService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class EstimatePriceController {

	@Autowired
	private EstimatePriceService es;
	
	
	@GetMapping("transporter/estimatedprice/{t_id}/{item_Id}")
	public ResponseEntity<Price> yes(@PathVariable String t_id, @PathVariable String item_Id) {
		 Price price=null;
		try {
			long tranid=Long.parseLong(t_id);
		    String str= URLEncoder.encode(item_Id, "UTF-8");
		    int itemid=Integer.parseInt(item_Id);
		    price =es.findprice(tranid, itemid);
		    System.out.println(price);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(price!=null) {
			   return ResponseEntity.ok(price);
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	}

//	  @PostMapping("/transporter/estimatedprice/{Rate_}")
//	public void setEsPriceForTrans(@RequestBody long t_id,@PathVariable String Rate_)
//	{
//		  Double rate = Double.parseDouble(Rate_);
//		es.setprice(t_id,rate);
//	}
	  
	  @PostMapping("transporter/estimatedprice/{charge_per_kg}")
		public ResponseEntity<String> EstimatedPrice(@RequestBody EstimatePrice estimatedPrice,@RequestParam long t_id,@PathVariable double charge_per_kg){
		
		  	es.setEstimatedPrice(estimatedPrice,t_id,charge_per_kg);
		return ResponseEntity.ok("added");
				
		}
}
