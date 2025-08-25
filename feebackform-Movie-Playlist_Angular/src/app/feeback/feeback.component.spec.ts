import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeebackComponent } from './feeback.component';

describe('FeebackComponent', () => {
  let component: FeebackComponent;
  let fixture: ComponentFixture<FeebackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeebackComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeebackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
