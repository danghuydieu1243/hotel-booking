package com.hotel_booking.service;

import com.hotel_booking.dto.request.HotelImageCreationRequest;
import com.hotel_booking.dto.request.HotelImageUpdateRequest;
import com.hotel_booking.dto.response.HotelImageResponse;
import com.hotel_booking.entity.HotelImage;
import com.hotel_booking.exception.AppException;
import com.hotel_booking.exception.ErrorCode;
import com.hotel_booking.mapper.HotelImageMapper;
import com.hotel_booking.repository.HotelImageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class HotelImageService {
    HotelImageRepository hotelImageRepository;
    HotelImageMapper hotelImageMapper;

    public HotelImageResponse createHotelImage(HotelImageCreationRequest request) {
        HotelImage hotelImage = hotelImageMapper.toHotelImage(request);
        hotelImage = hotelImageRepository.save(hotelImage);

        return hotelImageMapper.toHotelImageResponse(hotelImage);
    }

    public List<HotelImageResponse> getHotelImages() {
        log.info("In method get HotelImages");
        return hotelImageRepository.findAll().stream().map(hotelImageMapper::toHotelImageResponse).toList();
    }

    public HotelImageResponse getHotelImage(String id) {
        return hotelImageMapper.toHotelImageResponse(
                hotelImageRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.HOTEL_NOT_FOUND)));
    }

    public HotelImageResponse updateHotelImage(String hotelImageId, HotelImageUpdateRequest request) {
        HotelImage hotelImage = hotelImageRepository.findById(hotelImageId).orElseThrow(() -> new AppException(ErrorCode.HOTEL_NOT_FOUND));

        hotelImageMapper.updateHotelImage(hotelImage, request);

        return hotelImageMapper.toHotelImageResponse(hotelImageRepository.save(hotelImage));
    }

    public void deleteHotelImage(String hotelImageId) {
        hotelImageRepository.deleteById(hotelImageId);
    }
}
