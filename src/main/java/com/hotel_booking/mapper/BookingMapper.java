package com.hotel_booking.mapper;

import com.hotel_booking.dto.request.BookingCreationRequest;
import com.hotel_booking.dto.request.BookingUpdateRequest;
import com.hotel_booking.dto.request.UserUpdateRequest;
import com.hotel_booking.dto.response.BookingResponse;
import com.hotel_booking.entity.Booking;
import com.hotel_booking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking toBooking(BookingCreationRequest request);
    BookingResponse toBookingResponse(Booking booking);
    void updateBooking(@MappingTarget Booking booking, BookingUpdateRequest request);

}
