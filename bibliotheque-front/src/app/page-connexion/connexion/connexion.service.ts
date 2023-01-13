import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from 'src/app/app-config.service';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class ConnexionService {

  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.serviceUrl = appConfig.backEndUrl + "comptes/";
  }

  //findAll(): Array<Compte> {
  //  return this.comptes;
  //}

  //findById(id: number): Observable<Compte> {
  //  return this.http.get<Compte>(this.serviceUrl + id);
  //}

  findByLoginAndPassword(login: string, password: string): Observable<Compte> {
    let authDTO: Object = {login: login, password: password};
    return this.http.post<Compte>(this.serviceUrl + 'connexion/', authDTO);
  }

  //create(compte: Compte): void {
  //  this.http.post<Compte>(this.serviceUrl, compte).subscribe(resp => {
  //    this.load();
  //  });
  //}

  //update(compte: Compte): void {
  //  this.http.put<Compte>(this.serviceUrl + compte.id, compte).subscribe(resp => {
  //    this.load();
  //  });
  //}

  //remove(id: number): void {
  //  this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
  //    this.load();
  //  });
  //}

  //private load(): void {
  //  this.http.get<Array<Compte>>(this.serviceUrl).subscribe(response => {
  //    this.comptes = response;
  //  });
  //}
}
