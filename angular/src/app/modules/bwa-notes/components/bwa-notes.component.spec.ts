import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BwaNotesComponent } from './bwa-notes.component';

describe('BwaNotesComponent', () => {
  let component: BwaNotesComponent;
  let fixture: ComponentFixture<BwaNotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BwaNotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BwaNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
