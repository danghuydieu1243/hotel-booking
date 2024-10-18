package com.hotel_booking.dto.response;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import com.hotel_booking.entity.Role;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
//    String username;
//    String firstName;
//    String lastName;
//    LocalDate dob;
//    Set<RoleResponse> roles;

    String name;
    String phone;
    String email;
    Date createdAt;

    Set<RoleResponse> roles;
}