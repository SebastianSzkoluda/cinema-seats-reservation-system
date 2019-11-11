import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeanceCreatorComponent } from './seance-creator.component';

describe('SeanceCreatorComponent', () => {
  let component: SeanceCreatorComponent;
  let fixture: ComponentFixture<SeanceCreatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeanceCreatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeanceCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
