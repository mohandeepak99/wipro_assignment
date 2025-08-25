package com.wipro.mohan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    private String theatreName;
    private String city;

    // list of movie IDs that this theatre is currently screening
    @ElementCollection
    @Column(name = "movie_id")
    private List<Long> movieIds;
}
