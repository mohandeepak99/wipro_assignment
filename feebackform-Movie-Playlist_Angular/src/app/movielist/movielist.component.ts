import { Component } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-movielist',
  standalone: true,
  imports: [
    NgFor,
    NgIf, FormsModule,
    MatCardModule,
    MatSelectModule,
    MatIconModule,
    MatFormFieldModule,
  ],
  templateUrl: './movielist.component.html',
  styleUrl: './movielist.component.css'
})
export class MovielistComponent {
  genres = ['All', 'Action', 'Comedy', 'Drama', 'Romance'];
  selectedGenre = 'All';

    movies = [
  {
    title: 'Pushpa 2',
    genre: 'Action',
    rating: 4.8,
    poster: 'https://m.media-amazon.com/images/M/MV5BZjI2NGQxMGMtYzQ5Mi00NTBjLWJhYzktMjE2ZDkxOTU3YWZjXkEyXkFqcGc@._V1_QL75_UX223.5_.jpg',
    description: 'The continuation of Pushpa\'s rise in the red sandalwood smuggling world.'
  },
  {
    title: 'GameChanger',
    genre: 'Drama',
    rating: 4.4,
    poster: 'https://m.media-amazon.com/images/M/MV5BMThkN2YyMDMtOGNlMC00OWQzLWJjZDktMzBlNDY0MjMwZDYzXkEyXkFqcGc@._V1_QL75_UX217.5_.jpg',
    description: 'A political thriller directed by S. Shankar starring Ram Charan.'
  },
  {
    title: 'Kalki 2989AD',
    genre: 'Sci-Fi',
    rating: 4.6,
    poster: 'https://m.media-amazon.com/images/M/MV5BZTU0MzFmNjAtYjk1YS00N2JlLThjMjYtZjM4ZDY4NTBlNDM5XkEyXkFqcGc@._V1_QL75_UX219_.jpg',
    description: 'A futuristic epic starring Prabhas, Deepika Padukone and Amitabh Bachchan.'
  },
  {
    title: 'Hi Nanna',
    genre: 'Romance',
    rating: 4.7,
    poster: 'https://www.acmodasi.in/amdb/images/movie/w200/j/g/hi-nanna-373753.webp',
    description: 'A single father begins to narrate the story of the missing mother to his child and nothing remains the same.'
  },
  {
    title: 'Coolie',
    genre: 'Action',
    rating: 4.2,
    poster: 'https://m.media-amazon.com/images/M/MV5BZDViOWQ5MTAtYmY4YS00YmRlLTg1MTktMDUwNjE4ZmIyYzA2XkEyXkFqcGc@._V1_QL75_UX217.5_.jpg',
    description: 'A much-awaited entertainer starring Rajinikath and directed by Lokesh kangaraj.'
  }
];


  get filteredMovies() {
    if (this.selectedGenre === 'All') return this.movies;
    return this.movies.filter(m => m.genre === this.selectedGenre);
  }

  get averageRating() {
    const arr = this.filteredMovies;
    if (!arr.length) return 0;
    return (arr.reduce((s, m) => s + m.rating, 0) / arr.length).toFixed(2);
  }

  isTopRated(rating: number) {
    return rating >= 4.7;
  }
}
