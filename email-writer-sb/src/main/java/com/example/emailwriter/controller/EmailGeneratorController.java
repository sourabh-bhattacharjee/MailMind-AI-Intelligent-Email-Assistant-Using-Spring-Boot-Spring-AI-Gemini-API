package com.example.emailwriter.controller;

import com.example.emailwriter.dto.EmailRequest;
import com.example.emailwriter.service.EmailGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmailGeneratorController {

    private final EmailGeneratorService emailGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){

        String response = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }
}
