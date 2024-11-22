package com.hotel_booking.dto.response;

import com.hotel_booking.common.PaymentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceResponse {
    String id;
    String userId;
    Double totalAmount;
    LocalDate creationDate;
    PaymentStatus paymentStatus;
}
