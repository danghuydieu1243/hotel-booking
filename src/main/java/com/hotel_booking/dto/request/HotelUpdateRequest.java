package com.hotel_booking.dto.request;

import com.hotel_booking.entity.HotelImage;
import com.hotel_booking.entity.Utilities;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelUpdateRequest {
    String name;
    String street;
    String district;
    String city;
    String description;
    List<Utilities> utilities;
    List<HotelImage> hotelImages;
}
