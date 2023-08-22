package com.app.EfficientSS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.EfficientSS.beans.Transporter;
import com.app.EfficientSS.dao.TransporterDao;

@Service
public class TransporterServiceImpl implements TransporterService {

		@Autowired
	    private TransporterDao Transporterdao;
	    
	    public void createTransporter(Transporter transporter) {
	    	transporter.setT_blacklist("clear");
	    	transporter.setT_verification("Pending");
	     Transporterdao.save(transporter);
	    }
	    
	
	    
	    public List<Transporter> getAllTransporters() {
	        return Transporterdao.findAll();
	    }
	    

		public void updateTransporter(Long id, Transporter transporter) {
	        Transporter existingTransporter = getTransporterById(id);
	     
	        existingTransporter.setT_verification("Done");

	        Transporterdao.save(existingTransporter);
	    }
	    
	    public void deleteTransporter(Long id) {
	        Transporter transporter = getTransporterById(id);
	        Transporterdao.delete(transporter);
	    }

		public Transporter validateTransporter(Transporter trans) {
			
			String email=trans.getT_email_id();
			Transporter t=Transporterdao.findByEmailId(email);
			if(t.getT_blacklist().equalsIgnoreCase("clear"))
			return t;
			else return null;
		}

		@Override
		public void updateBlaclist(Long t_id, Transporter transporter) {
	        Transporter existingTransporter = getTransporterById(t_id);
	        if(existingTransporter.getT_blacklist().equalsIgnoreCase("clear"))
	        {
	        	existingTransporter.setT_blacklist("block");
	        }
	        else if(existingTransporter.getT_blacklist().equalsIgnoreCase("block"))
	  	        {
	  	        	existingTransporter.setT_blacklist("clear");
	  	        }
	        Transporterdao.save(existingTransporter);
	        }

		@Override
		public Transporter getTransporterById(long t_id) {
 	Optional<Transporter> oldTransporter = Transporterdao.findById(t_id);
			
			if(oldTransporter.isPresent())
			{
				Transporter newTransporter=oldTransporter.get();
				return newTransporter;
			}
			else
				return null;
		}

	
			
		}
