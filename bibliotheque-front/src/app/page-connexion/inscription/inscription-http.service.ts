import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from 'src/app/app-config.service';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class InscriptionHttpService {

  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "comptes/inscription/";
  }

  create(formCompte: Compte): Observable<Compte> {
    return this.http.post<Compte>(this.serviceUrl, formCompte)
  }

}