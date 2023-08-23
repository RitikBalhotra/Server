package com.Rb.Controller;

import com.Rb.Service.RejectService;
import com.Rb.model.Reject;
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
@RequestMapping("/api/r1")
public class RejectController {

    public final RejectService rejectService;

    @GetMapping("/get/all/rejects")
    public ResponseEntity<?> getAllReject()
    {
        return new ResponseEntity<>(rejectService.getAll(), HttpStatus.OK);
    }
}
