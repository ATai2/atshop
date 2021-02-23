import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserninfoComponent } from './userninfo.component';

describe('UserninfoComponent', () => {
  let component: UserninfoComponent;
  let fixture: ComponentFixture<UserninfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserninfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserninfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
