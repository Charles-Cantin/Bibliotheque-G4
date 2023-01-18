import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageAccesComponent } from './page-acces.component';

describe('PageAccesComponent', () => {
  let component: PageAccesComponent;
  let fixture: ComponentFixture<PageAccesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageAccesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageAccesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
