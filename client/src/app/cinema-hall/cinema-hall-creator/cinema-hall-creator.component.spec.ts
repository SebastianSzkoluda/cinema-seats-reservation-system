import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CinemaHallCreatorComponent } from './cinema-hall-creator.component';

describe('CinemaHallCreatorComponent', () => {
  let component: CinemaHallCreatorComponent;
  let fixture: ComponentFixture<CinemaHallCreatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CinemaHallCreatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CinemaHallCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
