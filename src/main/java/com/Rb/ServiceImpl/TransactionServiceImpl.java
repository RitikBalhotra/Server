package com.Rb.ServiceImpl;

import com.Rb.Repository.TransactionRepository;
import com.Rb.Service.TransactionService;
import com.Rb.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    public final TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        System.out.println("Data Saved");
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(int id){
        Optional<Transaction> transactionOptional=transactionRepository.findById(id);
        if(transactionOptional.isPresent()) {
            return transactionOptional.get();
        }
        else{
            return null;
        }
    }

    @Override
    public String deleteTransaction(int id) {
        Transaction transaction=getTransactionById(id);
        if(transaction!=null){
            transactionRepository.delete(transaction);
            return "Transaction Deleted Successfully";
        }
        return "Something went wrong";
    }

    @Override
    public List getAllTransactions() {
        List<Transaction> listT=transactionRepository.findAll();
        List list=new ArrayList<>();
        for (Transaction trr:listT) {
            var transaction=Transaction.builder()
                    .id(trr.getId())
                    .user_name(trr.getUser_name())
                    .user_email(trr.getUser_email())
                    .user_pan(trr.getUser_pan())
                    .user_dob(trr.getUser_dob())
                    .user_address(trr.getUser_address())
                    .car_id(trr.getCar_id())
                    .car_name(trr.getCar_name())
                    .car_price(trr.getCar_price())
                    .car_model(trr.getCar_model())
                    .car_colour(trr.getCar_colour())
                    .build();
            list.add(transaction);
        }
        return list;

    }


}
