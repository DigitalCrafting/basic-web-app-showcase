import { TestBed } from '@angular/core/testing';

import { BwaLoginVerifyService } from './bwa-login-verify.service';

describe('BwaLoginVerifyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BwaLoginVerifyService = TestBed.get(BwaLoginVerifyService);
    expect(service).toBeTruthy();
  });
});
