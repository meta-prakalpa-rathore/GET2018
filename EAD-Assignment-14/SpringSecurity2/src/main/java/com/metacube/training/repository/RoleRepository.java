package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Role;
import com.metacube.training.model.User;

@Repository
public interface RoleRepository<R> extends JpaRepository<Role, Integer> {

    public Role findByUsername(User username);
}
