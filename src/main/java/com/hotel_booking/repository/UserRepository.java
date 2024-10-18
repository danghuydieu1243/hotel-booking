package com.hotel_booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel_booking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
//    boolean existsByUsername(String username);
//
//    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}