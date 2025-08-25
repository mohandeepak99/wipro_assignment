import { Component } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-movieplaylist',
  standalone: true,
  imports: [
    NgFor,
    NgIf,
    FormsModule,
    MatCardModule,
    MatSelectModule,
    MatIconModule,
    MatFormFieldModule
  ],
  templateUrl: './movieplaylist.component.html',
  styleUrl: './movieplaylist.component.css'
})
export class MovieplaylistComponent {
  artists = ['All', 'Arijit Singh','Anurag Kulkarni', 'Shreya Ghoshal', 'Sid Sriram','Rahul Sipligunj'];
  albums = ['All', 'Pushpa', ' Ala Vaikunthapurramuloo', 'Geetha Govindam','Sarileru Neekevvaru'];
  filterType = 'artist';
  filterValue = 'All';

  songs = [
  {
    name: 'Srivalli',
    artist: 'Sid Sriram',
    album: 'Pushpa',
    duration: '3:14',
    rating: 4.9
  },
  {
    name: 'Ramuloo Ramulaa',
    artist: 'Anurag Kulkarni',
    album: 'Ala Vaikunthapurramuloo',
    duration: '3:38',
    rating: 4.8
  },
  {
    name: 'Inkem Inkem Inkem Kaavaale',
    artist: 'Sid Sriram',
    album: 'Geetha Govindam',
    duration: '3:48',
    rating: 4.7
  },
  {
    name: 'Butta Bomma',
    artist: 'Armaan Malik',
    album: 'Ala Vaikunthapurramuloo',
    duration: '3:23',
    rating: 4.6
  },
  {
    name: 'Mind Block',
    artist: 'Rahul Sipligunj',
    album: 'Sarileru Neekevvaru',
    duration: '3:41',
    rating: 4.7
  }
];


  get filteredSongs() {
    if (this.filterValue === 'All') return this.songs;
    return this.songs.filter(song =>
      this.filterType === 'artist'
        ? song.artist === this.filterValue
        : song.album === this.filterValue
    );
  }

  isTopRated(rating: number) {
    return rating >= 4.7;
  }
}
