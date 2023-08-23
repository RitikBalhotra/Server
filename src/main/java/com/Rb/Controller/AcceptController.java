package com.Rb.Controller;

import com.Rb.Service.AcceptService;
import com.Rb.Service.RejectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/a1")
public class AcceptController {


    public final AcceptService acceptService;

    @GetMapping("/get/all/accepts")
    public ResponseEntity<?> getAllAccept()
    {
        System.out.println(acceptService.getAll());
        return new ResponseEntity<>(acceptService.getAll(), HttpStatus.OK);
    }
}
