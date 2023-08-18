package com.Rb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity
@AllArgsConstructor
public class Transaction {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user_name;
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





