

package com.wipro.mohan.entities;

import com.wipro.mohan.enumType.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private Long movieId;
    private Long theatreId;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
}
