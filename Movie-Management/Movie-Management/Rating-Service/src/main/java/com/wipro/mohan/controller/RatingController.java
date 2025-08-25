package com.wipro.mohan.controller;

import com.wipro.mohan.entities.Rating;
import com.wipro.mohan.entities.RatingRequest;
import com.wipro.mohan.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping("/add")
    public Rating addRating(@RequestBody RatingRequest request) {
        return ratingService.addRating(request);
    }

    @GetMapping("/forMovie/{movieId}")
    public List<Rating> getRatingsForMovie(@PathVariable Long movieId) {
        return ratingService.getRatingsForMovie(movieId);
    }

    @GetMapping("/count")
    public long getNumberOfRatings() {
        return ratingService.getNumberOfRatings();
    }

    @GetMapping("/page")
    public Page<Rating> getRatingsPaged(Pageable pageable) {
        return ratingService.getRatings(pageable);
    }
}

