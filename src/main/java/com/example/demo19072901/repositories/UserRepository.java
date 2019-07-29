package com.example.demo19072901.repositories;

import com.example.demo19072901.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findByuserIdContains(String userId, Pageable pageable);
}
