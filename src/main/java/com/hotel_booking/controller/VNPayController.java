package com.hotel_booking.controller;

import com.hotel_booking.dto.response.ApiResponse;
import com.hotel_booking.service.VNPayService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/VnPay")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class VNPayController {

    VNPayService vnPayService;

    @PostMapping("/{bookingId}")
    ApiResponse<String> createPayment(@PathVariable("bookingId") String bookingId) {
        return ApiResponse.<String>builder()
                .result(vnPayService.createPaymentRequest(bookingId))
                .build();
    }

    @GetMapping("/callback")
    ApiResponse<String> handlePaymentCallback(@RequestParam Map<String, String> params) {
        return ApiResponse.<String>builder()
                .result(vnPayService.handlePaymentCallback(params))
                .build();
    }
}
