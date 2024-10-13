package com.hotel_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel_booking.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}