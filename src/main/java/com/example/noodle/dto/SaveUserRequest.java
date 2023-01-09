package com.example.noodle.dto;

import com.example.noodle.model.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaveUserRequest {
    private String email;
    private String password;
    private ERole role;
}
