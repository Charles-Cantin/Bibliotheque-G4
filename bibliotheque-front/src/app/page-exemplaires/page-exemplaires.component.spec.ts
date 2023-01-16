import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageExemplairesComponent } from './page-exemplaires.component';

describe('PageExemplairesComponent', () => {
  let component: PageExemplairesComponent;
  let fixture: ComponentFixture<PageExemplairesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageExemplairesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageExemplairesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
