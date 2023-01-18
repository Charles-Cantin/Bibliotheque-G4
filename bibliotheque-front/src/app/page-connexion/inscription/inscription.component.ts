import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { Compte } from 'src/model';
import { InscriptionHttpService } from './inscription-http.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent {

  formCompte: Compte = new Compte();

  constructor(private inscriptionService: InscriptionHttpService, private router: Router, private authService: AuthService) { }

  inscriptionLecteur(): void {
    this.formCompte.type = "inscrit";
    this.inscriptionService.create(this.formCompte).subscribe({
      next: (resp) => {
        this.authService.setLoggedInAccount(resp)
        this.authService.redirectMonCompte(resp.type)
      },
      error: (err) => {
        /* Erreur ! Données non valides. Deux possibilités :
         *  - il manque un champ : se backend nous renvoie un code erreur 400 BAD REQUEST ;
         *  - le login existe déjà : c'est SQL qui plante, et le back renvoie une erreur 500
         */
        switch (err.status) {
          case 400: alert("Merci de remplir tous les champs."); break;
          case 500: alert("Ce nom d'utilisateur est déjà utilisé."); break;
          default: alert("Une erreur est survenue. Merci de réessayer plus tard (jamais)."); break;
        }
      }
    })
  }

}
