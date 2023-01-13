import { Component } from '@angular/core';
import { Compte } from 'src/model';
import { ConnexionService } from './connexion.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {
  login: string;
  password: string;
  compteConnecte: Compte;

  constructor(private connexionService: ConnexionService){}

  auth(login: string, password: string) {
    this.connexionService.findByLoginAndPassword(login, password).subscribe(resp => {
      this.compteConnecte = resp;
      // TODO : redirections
    });
  }
}
