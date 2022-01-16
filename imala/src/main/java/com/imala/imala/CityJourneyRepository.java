package com.imala.imala;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityJourneyRepository extends JpaRepository<CityJourney,Long> {
    List<CityJourney> findByOrderByDepartureAsc();
    
    @Query(value = "select * from table Imala I where I.departure = :departure and I.destination = :destination ")
    CityJourney searchTariff(@Param("departure") String departure,@Param("destination") String destination);
    
}
