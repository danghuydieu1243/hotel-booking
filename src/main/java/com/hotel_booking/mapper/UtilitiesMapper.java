package com.hotel_booking.mapper;

import com.hotel_booking.dto.request.UtilitiesCreationRequest;
import com.hotel_booking.dto.request.UtilitiesUpdateRequest;
import com.hotel_booking.dto.response.UtilitiesResponse;
import com.hotel_booking.entity.Utilities;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UtilitiesMapper {
    Utilities toUtilities(UtilitiesCreationRequest request);
    UtilitiesResponse toUtilitiesResponse(Utilities utilities);
    void updateUtilities(@MappingTarget Utilities utilities, UtilitiesUpdateRequest request);
}
