package com.imala.imala;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CityJourneyRepository extends JpaRepository<CityJourney,Long> {
    List<CityJourney> findByOrderByDepartureAsc();
    List<CityJourney> findByOrderByDestinationAsc();
    
}
