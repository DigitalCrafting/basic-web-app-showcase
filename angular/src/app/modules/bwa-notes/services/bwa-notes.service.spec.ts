import { TestBed } from '@angular/core/testing';

import { BwaNotesService } from './bwa-notes.service';

describe('BwaNotesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BwaNotesService = TestBed.get(BwaNotesService);
    expect(service).toBeTruthy();
  });
});
