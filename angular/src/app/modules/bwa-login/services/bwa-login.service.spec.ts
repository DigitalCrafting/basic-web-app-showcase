import { TestBed } from '@angular/core/testing';

import { BwaLoginService } from './bwa-login.service';

describe('BwaLoginService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BwaLoginService = TestBed.get(BwaLoginService);
    expect(service).toBeTruthy();
  });
});
