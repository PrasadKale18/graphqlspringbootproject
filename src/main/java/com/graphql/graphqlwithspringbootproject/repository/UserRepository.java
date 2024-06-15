package com.graphql.graphqlwithspringbootproject.repository;

import com.graphql.graphqlwithspringbootproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
