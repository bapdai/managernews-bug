package com.example.managernews.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
public class LoginDto {
    private String username;
    private String password;
}
