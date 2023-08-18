package com.Rb.Service;

import com.Rb.Dto.UserDto;
import com.Rb.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User findByEmail(String email);

    List getAllUsers();

    String deleteUser(int id);

    User getById(int id);

    User updateUser(UserDto userDto);
}
