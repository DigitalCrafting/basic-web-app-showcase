import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BwaLoginComponent } from './bwa-login.component';

describe('BwaLoginComponent', () => {
  let component: BwaLoginComponent;
  let fixture: ComponentFixture<BwaLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BwaLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BwaLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
