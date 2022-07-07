package com.example.managernews.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class CredentialDto {
    public String accessToken;
    public String refreshToken;
}
