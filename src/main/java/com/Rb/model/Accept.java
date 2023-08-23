package com.Rb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Accept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accept_Id;
    private Integer id;
    private String user_name;
    private String status;
    private String user_email;
    private String user_dob;
    private String user_address;
    private String user_pan;
    private String car_id;
    private String car_name;
    private String car_model;
    private String car_price;
    private String car_colour;

}
