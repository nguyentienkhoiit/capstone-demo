package com.khoinguyen.capstone.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/super-admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SuperAdminController {
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("super admin page");
    }
}
