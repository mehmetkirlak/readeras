package com.narval.readeras.dto.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdationRequest {
    private String username;
    private String password;
    private String full_name;
    private String address;
    private int phone;
}
