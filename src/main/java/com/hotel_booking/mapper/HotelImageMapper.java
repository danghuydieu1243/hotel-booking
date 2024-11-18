package com.hotel_booking.mapper;

import com.hotel_booking.dto.request.HotelImageCreationRequest;
import com.hotel_booking.dto.request.HotelImageUpdateRequest;
import com.hotel_booking.dto.response.HotelImageResponse;
import com.hotel_booking.entity.HotelImage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HotelImageMapper {
    HotelImage toHotelImage(HotelImageCreationRequest request);
    HotelImageResponse toHotelImageResponse(HotelImage hotelImage);
    void updateHotelImage(@MappingTarget HotelImage hotelImage, HotelImageUpdateRequest request);
}
