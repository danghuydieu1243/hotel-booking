package com.hotel_booking.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RatingUpdateRequest {
    String hotelId;
    String userId;
    Double point;
    String comment;
}
