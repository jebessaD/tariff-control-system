package com.imala.imala.crosscountry;

import java.util.List;

// import com.imala.imala.crosscountry.SearchingAttribute.Type;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CrossRepository extends CrudRepository<CrossCountry, Long> {

    List<CrossCountry> findAll();

    @Query(value="SELECT * FROM cross_country c WHERE c.departure = :departure AND c.destination = :destination AND c.bus = :bus " ,nativeQuery = true)

    CrossCountry findTariff( @Param("departure") String departure,  @Param("destination") String destination,  @Param("bus") String bus);


    
}
