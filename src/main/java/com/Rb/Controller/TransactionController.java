package com.Rb.Controller;

import com.Rb.Dto.CarDto;
import com.Rb.Dto.TransactionDto;
import com.Rb.Dto.UserDto;
import com.Rb.Repository.TransactionRepository;
import com.Rb.Service.CarService;
import com.Rb.Service.TransactionService;
import com.Rb.model.Car;
import com.Rb.model.Transaction;
import com.Rb.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/t1")
public class TransactionController {

    public final TransactionService transactionService;
    public final TransactionRepository transactionRepository;
    public final CarService carService;
    @PostMapping("/buy/now")
    public ResponseEntity<?> buyNow(@RequestBody TransactionDto transactionDto ){

        System.out.println(transactionDto);
//       Car car=carService.getCarById(id);
        if(transactionDto!=null){
            var transaction=Transaction.builder()
                    .user_name(transactionDto.getUser_name())
                    .user_email(transactionDto.getUser_email())
                    .user_dob(transactionDto.getUser_dob())
                    .user_pan(transactionDto.getUser_pan())
                    .user_address(transactionDto.getUser_address())
                    .car_id(transactionDto.getCar_id())
                    .car_name(transactionDto.getCar_name())
                    .car_model(transactionDto.getCar_model())
                    .car_colour(transactionDto.getCar_colour())
                    .car_price(transactionDto.getCar_price())
                    .build();
           return new  ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.OK);
        }
        else{
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST+"Something went wrong");
        }
    }

    @GetMapping("/getAll/transaction")
    public ResponseEntity<?> getAllTransactions(){
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/transaction/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable("id") int id)
    {
        return new  ResponseEntity<>(transactionService.deleteTransaction(id), HttpStatus.OK);
    }
}
