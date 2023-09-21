package com.srija.springgithubactionsdemo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {
    @NotBlank
    String username;
    @NotBlank
    String password;
    @NotBlank
    String email;
    int age;
    String gender;
    String occupation;
}
