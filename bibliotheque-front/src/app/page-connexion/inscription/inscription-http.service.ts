import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from 'src/app/app-config.service';
import { GlobalVariablesService } from 'src/app/global-variables.service';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class InscriptionHttpService {

  
  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private router: Router, private globalVariables: GlobalVariablesService) {
    this.serviceUrl = appConfig.backEndUrl + "comptes/inscription/";
   }

  create(formCompte: Compte) {
    this.http.post<Compte>(this.serviceUrl, formCompte).subscribe(resp => {
      this.globalVariables.compteConnecte = resp;
      switch (resp.type) {
        case 'admin': alert("connection admin ok ; mais pas encore page admin"); this.router.navigate(['']) ; break;
        case 'bibliothecaire': this.router.navigate(['bibliothecaire']) ; break;
        case 'inscrit': this.router.navigate(['lecteur']) ; break;
      }
    })
  }
}
