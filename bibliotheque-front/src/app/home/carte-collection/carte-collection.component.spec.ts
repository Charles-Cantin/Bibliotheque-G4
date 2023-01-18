import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarteCollectionComponent } from './carte-collection.component';

describe('CarteCollectionComponent', () => {
  let component: CarteCollectionComponent;
  let fixture: ComponentFixture<CarteCollectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarteCollectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarteCollectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
