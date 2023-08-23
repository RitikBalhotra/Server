package com.Rb.ServiceImpl;

import com.Rb.Repository.RejectRepository;
import com.Rb.Service.RejectService;
import com.Rb.model.Accept;
import com.Rb.model.Reject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RejectServiceImpl implements RejectService {

    public final RejectRepository rejectRepository;

    @Override
    public Reject Save(Reject reject) {
        return rejectRepository.save(reject);
    }

    @Override
    public List getAll() {
        List<Reject> rejectList = rejectRepository.findAll();
        List list=new ArrayList<>();
        for (Reject reject : rejectList) {
            var reject1 = Reject.builder()
                    .reject_Id(reject.getReject_Id())
                    .user_email(reject.getUser_email())
                    .user_name(reject.getUser_name())
                    .user_dob(reject.getUser_dob())
                    .status(reject.getStatus().toUpperCase())
                    .id(reject.getId())
                    .car_id(reject.getCar_id())
                    .car_name(reject.getCar_name())
                    .car_model(reject.getCar_model())
                    .car_price(reject.getCar_price())
                    .user_address(reject.getUser_address())
                    .car_colour(reject.getCar_colour())
                    .user_pan(reject.getUser_pan())
                    .build();
            list.add(reject1);
        }
        return list;
    }
}
