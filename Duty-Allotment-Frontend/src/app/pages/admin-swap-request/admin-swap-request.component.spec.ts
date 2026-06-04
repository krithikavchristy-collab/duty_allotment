import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSwapRequestComponent } from './admin-swap-request.component';

describe('AdminSwapRequestComponent', () => {
  let component: AdminSwapRequestComponent;
  let fixture: ComponentFixture<AdminSwapRequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminSwapRequestComponent]
    });
    fixture = TestBed.createComponent(AdminSwapRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
