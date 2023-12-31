package com.app.EfficientSS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.EfficientSS.beans.EstimatePrice;

public interface EstimatePriceDao extends JpaRepository<EstimatePrice,Integer> {

	
	@Query(value = "SELECT latitude, longitude FROM Cities WHERE city_name = ?", nativeQuery = true)
    List<Object[]> findValues(String city);
    
    @Query(value="select * from estimate_price WHERE t_id = ?",nativeQuery = true)
	Optional<EstimatePrice> findByTransporterId(long t_id);

}
