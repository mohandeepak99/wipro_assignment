package com.wipro.mohan.service;

import com.wipro.mohan.feign.TheatreInterface;
import com.wipro.mohan.entities.Theatre;
import com.wipro.mohan.exception.TheatreNotFoundException;
import com.wipro.mohan.repos.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TheatreService {

    private final TheatreRepository repo;
    private final TheatreInterface movieClient;

    
    public Theatre addTheatre(Theatre theatre) {
        try {
            
            List<Long> randomMovieIds = fetchRandomMovieIdsForTheatre(3);  
            theatre.setMovieIds(randomMovieIds);  

            return repo.save(theatre); 
        } catch (Exception e) {
            
            throw new RuntimeException("Failed to fetch random movie IDs: " + e.getMessage());
        }
    }
    
    private List<Long> fetchRandomMovieIdsForTheatre(int count) {
        return movieClient.getRandomMovieIdsForTheatre(count); 
    }
    

    public List<Theatre> getTheatres() {
        return repo.findAll();
    }

    public Theatre getTheatre(Long id) {
        return repo.findById(id).orElseThrow(() -> new TheatreNotFoundException("Theatre not found with ID: " + id));
    }

    // returns ONLY movies (fetched from Movie Service)
    public List<Map<String, Object>> getMoviesForTheatre(Long theatreId) {
        Theatre t = getTheatre(theatreId);
        List<Long> ids = t.getMovieIds();
        if (ids == null || ids.isEmpty()) return List.of();
        return movieClient.getMoviesByIds(ids);
    }
    
    public List<Long> getTheatresByName(List<String> names) {
        return repo.findAll().stream()
                   .filter(t -> names.contains(t.getTheatreName()))
                   .map(Theatre::getTheatreId)
                   .toList();
    }


}