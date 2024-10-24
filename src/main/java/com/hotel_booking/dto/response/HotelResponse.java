package com.hotel_booking.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {
    String id;
    String ownerId;
    String name;
    String street;
    String district;
    String city;
    String description;
}
