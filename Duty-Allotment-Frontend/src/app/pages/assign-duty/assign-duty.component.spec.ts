import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignDutyComponent } from './assign-duty.component';

describe('AssignDutyComponent', () => {
  let component: AssignDutyComponent;
  let fixture: ComponentFixture<AssignDutyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssignDutyComponent]
    });
    fixture = TestBed.createComponent(AssignDutyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
