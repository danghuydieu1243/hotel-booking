package com.hotel_booking.mapper;

import org.mapstruct.Mapper;

import com.hotel_booking.dto.request.RoleRequest;
import com.hotel_booking.dto.response.RoleResponse;
import com.hotel_booking.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}