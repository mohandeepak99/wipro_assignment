package com.wipro.mohan.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingRequest {
    private Long bookingId;
    private int stars;
    private String comment;
}
