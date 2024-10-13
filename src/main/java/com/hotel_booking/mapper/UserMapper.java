package com.hotel_booking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.hotel_booking.dto.request.UserCreationRequest;
import com.hotel_booking.dto.request.UserUpdateRequest;
import com.hotel_booking.dto.response.UserResponse;
import com.hotel_booking.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}