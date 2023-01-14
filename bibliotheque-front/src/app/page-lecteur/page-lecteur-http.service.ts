import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte, Emprunt, EmpruntDTO } from 'src/model';
import { AppConfigService } from '../app-config.service';
import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root'
})
export class PageLecteurHttpService {

  serviceUrl: string;
  emprunts: Array<EmpruntDTO> = new Array<EmpruntDTO>(); 

  constructor(private http: HttpClient, private appConfig: AppConfigService, private authService: AuthService) { 
    this.serviceUrl = appConfig.backEndUrl + "emprunts/";
    console.log(this.serviceUrl);
    this.load();
  }

  findAll(): Array<EmpruntDTO> {
    return this.emprunts;
  }

  private load(): void {
    let compteEmprunteur = this.authService.getLoggedInAccount();
    let id_emprunteur : number = compteEmprunteur.id;
    this.http.get<Array<EmpruntDTO>>(this.serviceUrl + id_emprunteur + "/empruntsDTO").subscribe(response => {
      this.emprunts = response;
    });
  }
}
