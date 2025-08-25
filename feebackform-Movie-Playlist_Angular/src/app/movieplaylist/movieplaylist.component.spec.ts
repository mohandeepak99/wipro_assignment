import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieplaylistComponent } from './movieplaylist.component';

describe('MovieplaylistComponent', () => {
  let component: MovieplaylistComponent;
  let fixture: ComponentFixture<MovieplaylistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieplaylistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovieplaylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
