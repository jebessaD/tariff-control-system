package com.imala.imala.report;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReportController {
    
    @Autowired
    private final ReportService reportService;

    @PostMapping("/placeOrder")
    public Report placeOrder(@RequestBody ReportConfig reportConfig){

        return reportService.placeOrder(reportConfig);
    }

    @GetMapping("/findAllOrder")
    public List<Report> findAllOrders(){

        return reportService.findAllOrders(); 
    }



}
