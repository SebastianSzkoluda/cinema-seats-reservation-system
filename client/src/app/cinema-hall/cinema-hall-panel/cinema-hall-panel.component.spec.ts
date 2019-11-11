import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CinemaHallPanelComponent } from './cinema-hall-panel.component';

describe('CinemaHallPanelComponent', () => {
  let component: CinemaHallPanelComponent;
  let fixture: ComponentFixture<CinemaHallPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CinemaHallPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CinemaHallPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
