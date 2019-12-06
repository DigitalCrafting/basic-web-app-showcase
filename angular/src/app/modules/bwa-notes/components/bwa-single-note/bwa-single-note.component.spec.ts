import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BwaSingleNoteComponent } from './bwa-single-note.component';

describe('BwaSingleNoteComponent', () => {
  let component: BwaSingleNoteComponent;
  let fixture: ComponentFixture<BwaSingleNoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BwaSingleNoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BwaSingleNoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
