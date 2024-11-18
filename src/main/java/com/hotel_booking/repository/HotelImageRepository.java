package com.hotel_booking.repository;

import com.hotel_booking.entity.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage, String> {
}
