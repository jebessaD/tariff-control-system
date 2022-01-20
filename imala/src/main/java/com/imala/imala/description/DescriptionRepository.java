package com.imala.imala.description;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.LEAST;
import org.springframework.data.jpa.repository.Query;



public interface DescriptionRepository extends CrudRepository<Description, Long> {
    
    @Query(value="SELECT COUNT(d.code) FROM description d WHERE d.code = :code" ,nativeQuery = true)
    int countReport( @Param("code") String code);

    List<Description> findByCode(String code);
}
