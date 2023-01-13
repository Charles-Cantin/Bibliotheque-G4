import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalVariablesService } from 'src/app/global-variables.service';
import { ConnexionService } from './connexion.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {
  login: string;
  password: string;

  constructor(private connexionService: ConnexionService, private globalVariables: GlobalVariablesService, private router: Router){}

  auth(): void {
    this.connexionService.findByLoginAndPassword(this.login, this.password).subscribe(resp => {
      // TODO Si ça marche pas ?
      this.globalVariables.compteConnecte = resp;

      switch (resp.type) {
        case 'admin': alert("connection admin ok ; mais pas encore page admin"); this.router.navigate(['']) ; break;
        case 'bibliothecaire': this.router.navigate(['bibliothecaire']) ; break;
        case 'inscrit': this.router.navigate(['lecteur']) ; break;
      }
    });
  }
}
