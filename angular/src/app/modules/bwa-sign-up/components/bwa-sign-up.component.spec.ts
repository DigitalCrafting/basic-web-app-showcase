import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BwaSignUpComponent } from './bwa-sign-up.component';

describe('BwaSignUpComponent', () => {
  let component: BwaSignUpComponent;
  let fixture: ComponentFixture<BwaSignUpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BwaSignUpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BwaSignUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
