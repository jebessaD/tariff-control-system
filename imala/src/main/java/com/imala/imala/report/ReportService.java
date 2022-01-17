package com.imala.imala.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReportService {

    @Autowired
    private final ReportRepository reportRepository;


    // @PostMapping("/placeOrder")
    public Report placeOrder(@RequestBody ReportConfig reportConfig){

        return reportRepository.save(reportConfig.getReport());
    }

    // @GetMapping("/findAllOrder")
    public List<Report> findAllOrders(){

        return reportRepository.findAll(); 
    }

    
    
}
