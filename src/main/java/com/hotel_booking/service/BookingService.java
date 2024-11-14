package com.hotel_booking.service;

import com.hotel_booking.dto.request.BookingCreationRequest;
import com.hotel_booking.dto.request.BookingUpdateRequest;
import com.hotel_booking.dto.response.BookingResponse;
import com.hotel_booking.entity.Booking;
import com.hotel_booking.exception.AppException;
import com.hotel_booking.exception.ErrorCode;
import com.hotel_booking.mapper.BookingMapper;
import com.hotel_booking.repository.BookingRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class BookingService {
    BookingMapper bookingMapper;
    BookingRepository bookingRepository;

    public BookingResponse createBooking(BookingCreationRequest request) {
        Booking booking = bookingMapper.toBooking(request);
        booking.setCreatedAt(LocalDate.now());
        booking = bookingRepository.save(booking);

        return bookingMapper.toBookingResponse(booking);
    }

    public List<BookingResponse> getBookings() {
        log.info("In method get Bookings");
        return bookingRepository.findAll().stream().map(bookingMapper::toBookingResponse).toList();
    }

    public BookingResponse getBooking(String id) {
        return bookingMapper.toBookingResponse(
                bookingRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND)));
    }

    public BookingResponse updateBooking(String bookingId, BookingUpdateRequest request) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND));

        bookingMapper.updateBooking(booking, request);

        return bookingMapper.toBookingResponse(bookingRepository.save(booking));
    }

    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
