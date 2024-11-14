package com.hotel_booking.dto.response;

import com.hotel_booking.entity.Utilities;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

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
    Double rating;
    Set<Utilities> utilities;
}
