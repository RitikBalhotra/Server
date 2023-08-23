package com.Rb.Controller;


import com.Rb.Dto.StatusDto;
import com.Rb.Dto.TransactionDto;

import com.Rb.Repository.TransactionRepository;
import com.Rb.Service.AcceptService;
import com.Rb.Service.CarService;
import com.Rb.Service.RejectService;
import com.Rb.Service.TransactionService;
import com.Rb.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/t1")
public class TransactionController {

    public final TransactionService transactionService;
    public final TransactionRepository transactionRepository;
    public final CarService carService;
    public final AcceptService acceptService;
    public final RejectService rejectService;

    @PostMapping("/buy/now")
    public ResponseEntity<?> buyNow(@RequestBody TransactionDto transactionDto) {

        System.out.println(transactionDto);

        if (transactionDto != null) {
            var transaction = Transaction.builder()
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
            return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST + "Something went wrong");
        }
    }

    @GetMapping("/getAll/transaction")
    public ResponseEntity<?> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/transaction/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable("id") int id) {
        return new ResponseEntity<>(transactionService.deleteTransaction(id), HttpStatus.OK);
    }

    @PostMapping("/transaction/status")
    public ResponseEntity<?> transactionStatus(@RequestBody StatusDto statusDto) {
        System.out.println(statusDto);
        Transaction transaction = transactionService.getTransactionById(statusDto.getId());
        if (statusDto.getStatus().equalsIgnoreCase("Accept") ) {
            var accept = Accept.builder()
                    .user_email(transaction.getUser_email())
                    .user_name(transaction.getUser_name())
                    .user_dob(transaction.getUser_dob())
                    .status(statusDto.getStatus().toUpperCase())
                    .id(transaction.getId())
                    .car_id(transaction.getCar_id())
                    .car_name(transaction.getCar_name())
                    .car_model(transaction.getCar_model())
                    .car_price(transaction.getCar_price())
                    .user_address(transaction.getUser_address())
                    .car_colour(transaction.getCar_colour())
                    .user_pan(transaction.getUser_pan())
                    .build();

            return new ResponseEntity<>(acceptService.Save(accept), HttpStatus.OK);
        } else if (statusDto.getStatus().equalsIgnoreCase("Reject")) {
            var reject = Reject.builder()
                    .user_email(transaction.getUser_email())
                    .user_name(transaction.getUser_name())
                    .user_dob(transaction.getUser_dob())
                    .status(statusDto.getStatus().toUpperCase())
                    .id(transaction.getId())
                    .car_id(transaction.getCar_id())
                    .car_name(transaction.getCar_name())
                    .car_model(transaction.getCar_model())
                    .car_price(transaction.getCar_price())
                    .user_address(transaction.getUser_address())
                    .car_colour(transaction.getCar_colour())
                    .user_pan(transaction.getUser_pan())
                    .build();

            return new ResponseEntity<>(rejectService.Save(reject), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

    }
}
