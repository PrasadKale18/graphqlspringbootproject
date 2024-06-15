package com.graphql.graphqlwithspringbootproject.service.Impl;

import com.graphql.graphqlwithspringbootproject.model.User;
import com.graphql.graphqlwithspringbootproject.repository.UserRepository;
import com.graphql.graphqlwithspringbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllData(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getDataById(int userId){
        return userRepository.findById(userId);
    }


    @Override
    public String deleteData(int userId){
        userRepository.deleteById(userId);
        return "User Delete Siccessfully";
    }


    @Override
    public User updateData(int userId,User user){
        Optional<User> existUser = userRepository.findById(userId);
        if(existUser.isPresent()){
            User update = existUser.get();
            update.setName(user.getName());
            update.setEmail(user.getEmail());
            update.setPhone(user.getPhone());
            update.setPassword(user.getPassword());
            return userRepository.save(update);

        }else {
            return null;
        }
    }
}
