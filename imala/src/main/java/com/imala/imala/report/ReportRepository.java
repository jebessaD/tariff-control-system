package com.imala.imala.report;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Long> {

    List<Report> findAll();
    
}
