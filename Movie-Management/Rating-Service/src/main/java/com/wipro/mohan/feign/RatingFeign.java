package com.wipro.mohan.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.mohan.entities.BookingResponse;

@FeignClient(name = "BOOKING-SERVICE", url = "${booking.service.url}")
public interface RatingFeign {
	@GetMapping("/api/bookings/{bookingId}")
    BookingResponse getBookingById(@PathVariable("bookingId") Long bookingId);
}
