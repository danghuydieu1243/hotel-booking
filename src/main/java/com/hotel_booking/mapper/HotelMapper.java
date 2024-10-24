package com.hotel_booking.mapper;

import com.hotel_booking.dto.request.BookingUpdateRequest;
import com.hotel_booking.dto.request.HotelCreationRequest;
import com.hotel_booking.dto.request.HotelUpdateRequest;
import com.hotel_booking.dto.response.HotelResponse;
import com.hotel_booking.entity.Booking;
import com.hotel_booking.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel toHotel(HotelCreationRequest request);
    HotelResponse toHotelResponse(Hotel hotel);
    void updateHotel(@MappingTarget Hotel hotel, HotelUpdateRequest request);
}
