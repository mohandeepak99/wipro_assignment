import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FeebackComponent } from './feeback/feeback.component';
import { MovielistComponent } from "./movielist/movielist.component";
import { MovieplaylistComponent } from './movieplaylist/movieplaylist.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FeebackComponent, MovielistComponent,MovieplaylistComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'feebackform';
}
