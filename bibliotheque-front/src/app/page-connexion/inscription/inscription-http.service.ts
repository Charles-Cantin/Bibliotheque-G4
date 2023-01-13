import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from 'src/app/app-config.service';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class InscriptionHttpService {

  
  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private router: Router) {
    this.serviceUrl = appConfig.backEndUrl + "comptes/inscription/";
   }

  create(formCompte: Compte) {
    this.http.post<Compte>(this.serviceUrl, formCompte).subscribe(resp => {
      
      this.router.navigate(['bibliothecaire']);
    })
  }
}
