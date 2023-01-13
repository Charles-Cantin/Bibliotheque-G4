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
    this.serviceUrl = appConfig.backEndUrl + "comptes";
    // TODO check cette addresse !!!!!!!!!!!!!!!!!!
  }

  //findAll(): Array<Compte> {
  //  return this.comptes;
  //}

  //findById(id: number): Observable<Compte> {
  //  return this.http.get<Compte>(this.serviceUrl + id);
  //}

  findByLoginAndPassword(login: string, password: string): Observable<Compte> {
    let authDTO = {login: login, password: password}
    return this.http.post<Compte>(this.serviceUrl, authDTO);
  }

  //create(ordinateur: Ordinateur): void {
  //  this.http.post<Ordinateur>(this.serviceUrl, ordinateur).subscribe(resp => {
  //    this.load();
  //  });
  //}

  //update(ordinateur: Ordinateur): void {
  //  this.http.put<Ordinateur>(this.serviceUrl + ordinateur.id, ordinateur).subscribe(resp => {
  //    this.load();
  //  });
  //}

  //remove(id: number): void {
  //  this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
  //    this.load();
  //  });
  //}

  //private load(): void {
  //  this.http.get<Array<Ordinateur>>(this.serviceUrl).subscribe(response => {
  //    this.ordinateurs = response;
  //  });
  //}
}
