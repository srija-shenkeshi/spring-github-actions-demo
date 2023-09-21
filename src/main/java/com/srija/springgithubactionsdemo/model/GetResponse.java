package com.srija.springgithubactionsdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetResponse {
    String userId;
    String username;
    String email;
    int age;
    String gender;
    String occupation;
}
