package com.imala.imala.report;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.imala.imala.description.Description;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "report")
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    
    @Column(
        name = "pallet_code",
        nullable = false
    //     columnDefinition = "TEXT"
    )
    private String palletCode;

    
    @Column(
        name = "report_count",
        nullable = false
    //     columnDefinition = "TEXT"
    )
    private int reportCount;


    @OneToMany(targetEntity = Description.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
    private List<Description> descriptions;



}
