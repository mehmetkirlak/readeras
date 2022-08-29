package com.narval.readeras.dto.userdto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationRequest {
    private Long id;
    private String username;
    private String password;
    private String full_name;
    private String address;
    private int phone;
}
