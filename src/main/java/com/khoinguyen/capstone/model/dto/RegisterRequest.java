package com.khoinguyen.capstone.model.dto;

import com.khoinguyen.capstone.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {
    String firstname;
    String lastname;
    String email;
    String password;
    Set<Role> roles;
}
