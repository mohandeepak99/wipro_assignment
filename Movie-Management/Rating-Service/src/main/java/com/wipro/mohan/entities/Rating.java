package com.wipro.mohan.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    private Long bookingId;
    private Long movieId;

    private int stars; // e.g. 1-5
    private String comment;
}
