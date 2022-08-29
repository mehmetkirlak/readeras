package com.narval.readeras.dto.userdto;

import com.narval.readeras.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {
    public UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFull_name(user.getFull_name());
        userDTO.setAddress(user.getAddress());
        userDTO.setPhone(user.getPhone());

        return userDTO;
    }
}
