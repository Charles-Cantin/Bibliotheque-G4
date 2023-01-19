import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-carte-collection',
  templateUrl: './carte-collection.component.html',
  styleUrls: ['./carte-collection.component.scss']
})
export class CarteCollectionComponent {

  @Input() urlImg: string;
  @Input() titre: string;
  @Input() lien: string;
  @Input() lienQueryParams: Object;
}
