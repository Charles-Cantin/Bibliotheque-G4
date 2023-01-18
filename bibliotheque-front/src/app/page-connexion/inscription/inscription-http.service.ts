import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from 'src/app/app-config.service';
import { AuthService } from 'src/app/auth.service';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class InscriptionHttpService {

  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private router: Router, private authService: AuthService) {
    this.serviceUrl = appConfig.backEndUrl + "comptes/inscription/";
   }

  create(formCompte: Compte) {

   if(formCompte.type==null){
     alert("Merci de renseigner un type de compte de compte pour commencer");
   }  
   

  if(formCompte.type=="bibliothecaire" || formCompte.type=="inscrit"){
  
  if(formCompte.prenom==null||formCompte.nom==null||formCompte.login==null||formCompte.password==null) {
    alert("Merci de compléter les champs suivants: Nom,Prénom,Nom d'utilisateur,Mot de passe");
  } 
    else{
      
      this.http.post<Compte>(this.serviceUrl, formCompte).subscribe(resp => {
        this.authService.setLoggedInAccount(resp)
        this.authService.redirectMonCompte(resp.type)})
      }

      }
      
      if(formCompte.type=="admin"){
  
        if(formCompte.login==null||formCompte.password==null) {
          alert("Merci de compléter les champs suivants: Nom d'utilisateur, Mot de passe");
        } 
          else{
            
            this.http.post<Compte>(this.serviceUrl, formCompte).subscribe(resp => {
              this.authService.setLoggedInAccount(resp)
              this.authService.redirectMonCompte(resp.type)})
            }
      
            }

    }
  }
