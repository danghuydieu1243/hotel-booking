package com.hotel_booking.mapper;

import com.hotel_booking.dto.request.RatingCreationRequest;
import com.hotel_booking.dto.request.RatingUpdateRequest;
import com.hotel_booking.dto.response.RatingResponse;
import com.hotel_booking.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    Rating toRating(RatingCreationRequest request);
    RatingResponse toRatingResponse(Rating rating);
    void updateRating(@MappingTarget Rating rating, RatingUpdateRequest request);
}
