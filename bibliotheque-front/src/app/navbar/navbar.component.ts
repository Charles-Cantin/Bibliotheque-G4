import { ChangeDetectorRef, Component, HostListener } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Compte } from 'src/model';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  connectedAccount: Compte;

  constructor(protected authS: AuthService, private router: Router, private changeDetectorRef: ChangeDetectorRef){
    // Met à jour la var locale connectedAccount à chaque changement de route; 
    this.router.events.subscribe((ev) => {
      if (ev instanceof NavigationEnd) {
        this.connectedAccount = authS.getLoggedInAccount();
      }
    });
  }

  unAuth(): void {
    this.authS.setLoggedInAccount(null);
    this.connectedAccount = null;
    this.changeDetectorRef.detectChanges(); // Force la détection du changement, pour cacher le nom du compte déconnecté
    this.router.navigate(['']);
  }

  redirectMonCompte = this.authS.redirectMonCompte;
}