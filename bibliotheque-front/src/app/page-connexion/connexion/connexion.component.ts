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
    this.connexionService.findByLoginAndPassword(this.login, this.password).subscribe({
      next: (resp) => { // Success
        this.authService.setLoggedInAccount(resp);
        this.authService.redirectMonCompte(resp.type);
      },
      error: (err) => { // Erreur
        alert("Mauvais nom d'utilisateur ou mot de passe.")
      }
    });
  }

}
