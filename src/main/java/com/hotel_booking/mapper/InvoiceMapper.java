package com.hotel_booking.mapper;

import com.hotel_booking.dto.request.InvoiceCreationRequest;
import com.hotel_booking.dto.response.InvoiceResponse;
import com.hotel_booking.entity.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice toInvoice(InvoiceCreationRequest request);
    InvoiceResponse toInvoiceResponse(Invoice invoice);
}
