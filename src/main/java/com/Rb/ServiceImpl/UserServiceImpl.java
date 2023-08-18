package com.Rb.ServiceImpl;

import com.Rb.Dto.UserDto;
import com.Rb.Repository.UserRepository;
import com.Rb.Service.UserService;
import com.Rb.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public List getAllUsers() {
        List<User> userList = userRepository.findAll();
        List list=new ArrayList<>();
        for (User user1 : userList) {
            var user= User.builder()
                    .id(user1.getId())
                    .name(user1.getName())
                    .email(user1.getEmail())
                    .pass(user1.getPass())
                    .build();
            list.add(user);
        }
        return list;
    }

//    @Override
//    public User findByPass(String pass) {
//        User user = userRepository.findByPass(pass);
//        if (user != null) {
//            return user;
//        }
//        return null;
//    }

    @Override
    public String deleteUser(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return "User Delete Successfully";
        }
        return "Something went wrong";
    }

    @Override
    public User updateUser(UserDto userDto) {
        User user1 = userRepository.findByEmail(userDto.getEmail());
        if (user1 != null) {
            user1.setName(userDto.getName());
            user1.setPass(userDto.getPass());

            return userRepository.save(user1);
        }
        return null;
    }


}
