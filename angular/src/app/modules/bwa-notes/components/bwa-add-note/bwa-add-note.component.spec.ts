import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BwaAddNoteComponent } from './bwa-add-note.component';

describe('BwaAddNoteComponent', () => {
  let component: BwaAddNoteComponent;
  let fixture: ComponentFixture<BwaAddNoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BwaAddNoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BwaAddNoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
