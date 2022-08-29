package com.narval.readeras.services;

import com.narval.readeras.dto.userdto.*;
import com.narval.readeras.model.User;
import com.narval.readeras.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOConverter userDTOConverter;


    public UserService(UserRepository userRepository, UserDTOConverter userDTOConverter) {
        this.userRepository = userRepository;
        this.userDTOConverter = userDTOConverter;
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList =userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user:userList){
            userDTOList.add(userDTOConverter.convert(user));
        }
        return userDTOList;
    }

    public UserDTO getUserById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(userDTOConverter::convert).orElse(new UserDTO());
    }

    public UserDTO createUser(UserCreationRequest userCreationRequest){
        User user = new User();
        user.setId(userCreationRequest.getId());
        user.setUsername(userCreationRequest.getUsername());
        user.setPassword(userCreationRequest.getPassword());
        user.setFull_name(userCreationRequest.getFull_name());
        user.setAddress(userCreationRequest.getAddress());
        user.setPhone(userCreationRequest.getPhone());

        userRepository.save(user);

        return userDTOConverter.convert(user);

    }

    public UserDTO updateUser(Long id, UserUpdationRequest userUpdationRequest){
        Optional<User> userOptional = userRepository.findById(id);

        userOptional.ifPresent(user -> {
            user.setUsername(userUpdationRequest.getUsername());
            user.setPassword(userUpdationRequest.getPassword());
            user.setFull_name(userUpdationRequest.getFull_name());
            user.setAddress(userUpdationRequest.getAddress());
            user.setPhone(userUpdationRequest.getPhone());

            userRepository.save(user);
        });

        return userOptional.map(userDTOConverter::convert).orElse(new UserDTO());
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    // TODO: 8/29/2022 userlara özel find by id yaz long to int dönüştürme olmaması için
}
