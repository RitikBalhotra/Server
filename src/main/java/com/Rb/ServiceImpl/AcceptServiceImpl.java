package com.Rb.ServiceImpl;

import com.Rb.Repository.AcceptRepository;
import com.Rb.Service.AcceptService;
import com.Rb.model.Accept;
import com.Rb.model.Reject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcceptServiceImpl implements AcceptService {

    private final AcceptRepository acceptRepository;


    @Override
    public Accept Save(Accept accept){
        return acceptRepository.save(accept);
    }

    @Override
    public List getAll() {
        List<Accept> acceptList = acceptRepository.findAll();
        List list=new ArrayList<>();
        for (Accept accept : acceptList) {
            var accept1 = Accept.builder()
                    .accept_Id(accept.getAccept_Id())
                    .user_email(accept.getUser_email())
                    .user_name(accept.getUser_name())
                    .user_dob(accept.getUser_dob())
                    .status(accept.getStatus().toUpperCase())
                    .id(accept.getId())
                    .car_id(accept.getCar_id())
                    .car_name(accept.getCar_name())
                    .car_model(accept.getCar_model())
                    .car_price(accept.getCar_price())
                    .user_address(accept.getUser_address())
                    .car_colour(accept.getCar_colour())
                    .user_pan(accept.getUser_pan())
                    .build();
            list.add(accept1);
        }
        return list;
    }


}
