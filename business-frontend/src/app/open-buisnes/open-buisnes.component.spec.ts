import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenBuisnesComponent } from './open-buisnes.component';

describe('OpenBuisnesComponent', () => {
  let component: OpenBuisnesComponent;
  let fixture: ComponentFixture<OpenBuisnesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpenBuisnesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenBuisnesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
