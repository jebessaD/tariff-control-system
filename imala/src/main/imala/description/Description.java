package com.imala.imala.description;

// import java.sql.Time;
// import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
// import javax.persistence.Table;

import com.imala.imala.Security.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "description")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotBlank
    private String code;

    @NotBlank
    @Column(name = "place", nullable = false)
    private String place;

    @NotBlank
    @Column(name = "message", nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
