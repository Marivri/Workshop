import { TestBed } from '@angular/core/testing';

import { AstronimicalObjectService } from './object.service';

describe('ObjectService', () => {
  let service: AstronimicalObjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AstronimicalObjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
