package com.imala.imala.cityJourney;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityJourneyRepository extends JpaRepository<CityJourney, Long> {

    List<CityJourney> findByOrderByDepartureAsc();

    // List<CityJourney> findByOrderByDepartureAsc();
    List<CityJourney> findByOrderByDestinationAsc();

    @Query(value = "select * from city_journey I where I.departure = :departure and I.destination = :destination ", nativeQuery = true)
    CityJourney search(@Param("departure") String departure, @Param("destination") String destination);

    @Query(value = "SELECT DISTINCT departure FROM city_journey order by departure asc;", nativeQuery = true)
    List<String> findDistinctByOrderByDepartureAsc();

    @Query(value = "SELECT DISTINCT destination FROM city_journey order by destination asc;", nativeQuery = true)
    List<String> findDistinctByOrderByDestinationAsc();

}
