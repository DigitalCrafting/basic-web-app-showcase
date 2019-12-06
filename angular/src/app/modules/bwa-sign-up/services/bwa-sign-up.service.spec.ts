import { TestBed } from '@angular/core/testing';

import { BwaSignUpService } from './bwa-sign-up.service';

describe('BwaSignUpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BwaSignUpService = TestBed.get(BwaSignUpService);
    expect(service).toBeTruthy();
  });
});
