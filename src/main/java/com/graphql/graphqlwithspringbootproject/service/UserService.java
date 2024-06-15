package com.graphql.graphqlwithspringbootproject.service;

import com.graphql.graphqlwithspringbootproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);


    List<User> getAllData();

    Optional<User> getDataById(int userId);

    String deleteData(int userId);

    User updateData(int userId,User user);
}
