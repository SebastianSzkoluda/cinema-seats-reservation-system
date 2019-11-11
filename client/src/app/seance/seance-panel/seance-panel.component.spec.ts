import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeancePanelComponent } from './seance-panel.component';

describe('SeancePanelComponent', () => {
  let component: SeancePanelComponent;
  let fixture: ComponentFixture<SeancePanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeancePanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeancePanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
