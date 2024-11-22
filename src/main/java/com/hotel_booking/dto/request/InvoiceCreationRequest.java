package com.hotel_booking.dto.request;

import com.hotel_booking.common.PaymentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceCreationRequest {
    String userId;
    Double totalAmount;
//    LocalDate creationDate;
    PaymentStatus paymentStatus;
}
