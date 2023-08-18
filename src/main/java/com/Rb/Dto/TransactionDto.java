package com.Rb.Dto;

import com.Rb.model.Car;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TransactionDto {
    private Integer id;
    private Integer user_id;
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
