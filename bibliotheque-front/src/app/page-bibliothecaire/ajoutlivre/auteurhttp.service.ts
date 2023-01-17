import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Auteur } from 'src/model';
import { AppConfigService } from '../../app-config.service';


@Injectable({
  providedIn: 'root'
})
export class AuteurhttpService {

  serviceUrl: string;
  auteurs: Array<Auteur> = new Array<Auteur>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "auteurs/";
    this.load();
   }

  findAll(): Array<Auteur> {
    return this.auteurs;
  }

  create(auteur:Auteur): void {
    this.http.post<Auteur>(this.serviceUrl, auteur).subscribe(resp => {
      this.load();
    });
  }
  private load(): void {
    this.http.get<Array<Auteur>>(this.serviceUrl).subscribe(response => {
      this.auteurs = response;
    });
  }


}
