package com.wipro.mohan.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.mohan.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByMovieId(Long movieId);
}
