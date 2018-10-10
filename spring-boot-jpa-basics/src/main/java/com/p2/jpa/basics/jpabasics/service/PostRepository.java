package com.p2.jpa.basics.jpabasics.service;

import com.p2.jpa.basics.jpabasics.entity.Post;
import com.p2.jpa.basics.jpabasics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {//Entity and Data Type of Primary Key
}
