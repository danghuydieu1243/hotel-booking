package com.hotel_booking.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
    String roomId;
    String customerId;
    String checkInDate;
    String checkOutDate;
    String status;
}
