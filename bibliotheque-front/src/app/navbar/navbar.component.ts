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
  nomPrenom: string = "";
  initials: string = "";

  constructor(protected authS: AuthService, private router: Router, private changeDetectorRef: ChangeDetectorRef){
    // Met à jour la var locale connectedAccount à chaque changement de route; 
    this.router.events.subscribe((ev) => {
      if (ev instanceof NavigationEnd) {
        this.connectedAccount = authS.getLoggedInAccount();
       this.nomPrenom = reduceNomPrenom(this.connectedAccount.nom, this.connectedAccount.prenom);
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
 function onlyCapitalLetters (myString:string) {
  return myString.replace(/[^A-Z]+/g, "");
}

const reduceNomPrenom = (nom:string, prenom:string, maxLength:number=30) => {return (nom + " " + prenom).length < maxLength ? initials(prenom) + " " + nom : initials(prenom) + " " + initials(nom)} ;
const initials = (str:string) => str.split('').filter(a => a.match(/[A-Z]/)).map(item => item + '.').join('');