import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarteEvenementComponent } from './carte-evenement.component';

describe('CarteEvenementComponent', () => {
  let component: CarteEvenementComponent;
  let fixture: ComponentFixture<CarteEvenementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarteEvenementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarteEvenementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
