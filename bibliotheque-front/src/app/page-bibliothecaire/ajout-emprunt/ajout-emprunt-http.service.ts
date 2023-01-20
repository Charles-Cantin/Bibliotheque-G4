import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from 'src/app/app-config.service';
import { Emprunt } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class AjoutEmpruntHttpService {

  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "emprunts/";

  }

  create(emprunt: Emprunt): void {
    this.http.post<Emprunt>(this.serviceUrl, emprunt).subscribe(resp => {
      console.log(resp)
      //tODO REDIRECTION
    });
  }

  sendAjoutEmpruntDTO(AjoutEmpruntDTO: {}): Observable<Emprunt> {
    return this.http.post<Emprunt>(this.serviceUrl, AjoutEmpruntDTO);
  }


}
