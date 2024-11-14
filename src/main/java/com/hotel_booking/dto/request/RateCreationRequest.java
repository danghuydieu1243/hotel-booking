package com.hotel_booking.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateCreationRequest {
    String hotelId;
    String userId;
    String point;
    String comment;
}
