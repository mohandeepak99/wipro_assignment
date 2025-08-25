package com.wipro.mohan.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Long bookingId;
    private Long movieId;
    private Long theatreId;
    private String bookingStatus; // enum as String
}

