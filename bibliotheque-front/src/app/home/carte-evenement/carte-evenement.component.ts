import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-carte-evenement',
  templateUrl: './carte-evenement.component.html',
  styleUrls: ['./carte-evenement.component.scss']
})
export class CarteEvenementComponent {

  @Input() tag: string;
  @Input() title: string;
  @Input() content: string;
  @Input() date: string;
  @Input() thumbnailUrl: string;
}
