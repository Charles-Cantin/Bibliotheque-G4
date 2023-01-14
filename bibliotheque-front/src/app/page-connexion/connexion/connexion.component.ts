import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { ConnexionService } from './connexion.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {
  login: string;
  password: string;

  constructor(private connexionService: ConnexionService, private authService: AuthService, private router: Router){}

  auth(): void {
    this.connexionService.findByLoginAndPassword(this.login, this.password).subscribe(resp => {
      // TODO Si ça marche pas ?
      this.authService.setLoggedInAccount(resp);

      switch (resp.type) {
        case 'admin': alert("connection admin ok ; mais pas encore page admin"); this.router.navigate(['']) ; break;
        case 'bibliothecaire': this.router.navigate(['bibliothecaire']) ; break;
        case 'inscrit': this.router.navigate(['lecteur']) ; break;
      }
    });
  }
}
