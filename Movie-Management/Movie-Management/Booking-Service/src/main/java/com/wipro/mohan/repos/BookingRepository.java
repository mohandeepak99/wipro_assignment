

package com.wipro.mohan.repos;

import com.wipro.mohan.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

