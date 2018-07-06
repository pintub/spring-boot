package com.p2.jpa.basics.jpabasics.service;

import com.p2.jpa.basics.jpabasics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
