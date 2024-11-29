package com.hotel_booking.controller;

import com.hotel_booking.dto.response.ApiResponse;
import com.hotel_booking.service.VNPayService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public void handlePaymentCallback(@RequestParam Map<String, String> params, HttpServletResponse response)throws IOException {
        // Chuyển hướng người dùng đến giao diện Frontend
        String redirectUrl = String.format("https://hotel-booking-t05s.onrender.com/payment-result?status=%s", vnPayService.handlePaymentCallback(params));
        response.sendRedirect(redirectUrl);
    }
}
