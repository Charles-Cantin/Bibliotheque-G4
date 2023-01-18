import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from 'src/model';
import { AppConfigService } from '../../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class GestionComptesHttpService {

  serviceUrl: string;
  comptes: Array<Compte> = new Array<Compte>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "comptes/";
    this.load();
   }

   findAll(): Array<Compte> {
    return this.comptes;
  }

  findById(id: number): Observable<Compte> {
    return this.http.get<Compte>(this.serviceUrl + id);
  }

  create(compte: Compte): void {
    this.http.post<Compte>(this.serviceUrl, compte).subscribe(resp => {
      this.load();
    });
  }

  update(compte: Compte): void {
    this.http.put<Compte>(this.serviceUrl + compte.id, compte).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Compte>>(this.serviceUrl).subscribe(response => {
      this.comptes = response;
    });
  }
}
