package com.Rb.Controller;

import com.Rb.Dto.LoginDto;
import com.Rb.Dto.UserDto;
import com.Rb.Repository.UserRepository;
import com.Rb.Service.UserService;
import com.Rb.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/u1")
public class UserController {

    public final UserService userService;
    public final UserRepository userRepository;


    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
        if (userDto != null) {
            var user = User.builder()
                    .name(userDto.getName())
                    .email(userDto.getEmail())
                    .pass(userDto.getPass())
                    .build();
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST + "Duplicate Data is not Accepted");
        }
    }

    @GetMapping("/get/By/Email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto);
        User userEmm = userService.findByEmail(loginDto.getEmail());
        if (userEmm != null && userEmm.getPass().equals(loginDto.getPass())) {
            return new ResponseEntity<>(userEmm, HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST + "Enter valid Credential");
    }

    @DeleteMapping("/delete/User/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/User")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        User user = userService.updateUser(userDto);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST + " Something Went Wrong");
    }
@GetMapping("/get/all/user")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
}

