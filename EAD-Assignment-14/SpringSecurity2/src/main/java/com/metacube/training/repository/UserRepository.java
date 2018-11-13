package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.User;

@Repository
public interface UserRepository<U> extends JpaRepository<User, String> {

}
