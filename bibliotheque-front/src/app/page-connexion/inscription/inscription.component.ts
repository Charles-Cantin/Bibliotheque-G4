import { Component } from '@angular/core';
import { Compte } from 'src/model';
import { InscriptionHttpService } from './inscription-http.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent {
  formCompte: Compte = new Compte();

  constructor(private inscriptionService:InscriptionHttpService) {}

  create() : void {
    this.inscriptionService.create(this.formCompte);
  }

}
