import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessService } from './business-service';

describe('BusinessServiceComponent', () => {
  let component: BusinessService;
  let fixture: ComponentFixture<BusinessService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessService ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessService);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
