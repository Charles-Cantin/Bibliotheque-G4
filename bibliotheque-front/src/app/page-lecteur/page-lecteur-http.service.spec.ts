import { TestBed } from '@angular/core/testing';

import { PageLecteurHttpService } from './page-lecteur-http.service';

describe('PageLecteurHttpService', () => {
  let service: PageLecteurHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PageLecteurHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
