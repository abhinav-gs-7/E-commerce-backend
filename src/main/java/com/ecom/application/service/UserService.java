package com.ecom.application.service;

import com.ecom.application.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> UserList=new ArrayList<>();
    private Long Nextid=1L;
    public List<User> GetAllUsers(){
        return UserList;
    }
    public void addUsers(User user){
        user.setId(Nextid++);
        UserList.add(user);

    }
    public Optional<User> getUserById(Long id){
       return UserList.stream().filter(user -> user.getId().equals(id)).findAny();
    }
    public void updateUser(User existingUser, User updatedUser) {
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());



    }
}
