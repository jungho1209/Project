package com.example.project.domain.auth.domain.repository;

import com.example.project.domain.auth.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    List<User> findAllByOrderByIdDesc();
}
