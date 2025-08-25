package com.wipro.mohan.service;

import com.wipro.mohan.entities.Booking;
import com.wipro.mohan.enumType.BookingStatus;
import com.wipro.mohan.exception.BookingNotFoundException;
import com.wipro.mohan.exception.MovieNotFoundException;
import com.wipro.mohan.exception.TheatreNotFoundException;
import com.wipro.mohan.feign.MovieFeign;
import com.wipro.mohan.feign.TheatreFeign;
import com.wipro.mohan.repos.BookingRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final MovieFeign movieClient;
    private final TheatreFeign theatreClient;
    private final BookingRepository bookingRepository;

    public Booking bookMovie(String movieName, String theatreName) {
        Long movieId = fetchMovieIdByName(movieName);
        Long theatreId = fetchTheatreIdByName(theatreName);

        Booking booking = new Booking();
        booking.setMovieId(movieId);
        booking.setTheatreId(theatreId);
        booking.setBookingStatus(BookingStatus.SUCCESS);

        return bookingRepository.save(booking);
    }

    private Long fetchMovieIdByName(String movieName) {
        List<Long> movieIds = movieClient.getMoviesByNames(List.of(movieName));
        if (movieIds.isEmpty()) {
            throw new MovieNotFoundException("Movie not found: " + movieName);
        }
        return movieIds.get(0);
    }

    private Long fetchTheatreIdByName(String theatreName) {
        List<Long> theatreIds = theatreClient.getTheatresByName(List.of(theatreName));
        if (theatreIds.isEmpty()) {
            throw new TheatreNotFoundException("Theatre not found: " + theatreName);
        }
        return theatreIds.get(0);
    }
    
 // Get total count of bookings
    public long getNumberOfBookings() {
        return bookingRepository.count();
    }

    // Get all bookings with pagination
    public Page<Booking> getAllBookings(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }
    
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + bookingId));
    }

}

