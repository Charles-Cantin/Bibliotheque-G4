import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Livre } from 'src/model';
import { AppConfigService } from './app-config.service';

@Injectable({
  providedIn: 'root'
})
export class LivreService {

  serviceUrl: string;
  livres: Array<Livre>

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "livres/";
    this.load();
   }

   findAll(): Array<Livre> {
    return this.livres;
   }

   findById(id: number): Observable<Livre> {
    return this.http.get<Livre>(this.serviceUrl + id);
  }

  findByTitle(searchText: string): Array<Livre> {
    this.http.post<Array<Livre>>(this.serviceUrl + "strict-title-search", searchText).subscribe(resp => {
      this.livres = resp;
    });
    return this.livres;
   }

  create(livre: Livre): void {
    this.http.post<Livre>(this.serviceUrl, livre).subscribe(resp => {
      this.load();
    });
  }

  update(livre: Livre): void {
    this.http.put<Livre>(this.serviceUrl + livre.id, livre).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>(this.serviceUrl + id).subscribe(resp => {
      this.load();
    });
  }

   /*private load(): void {
    this.http.get<Array<Livre>>(this.serviceUrl).subscribe(resp => {
      this.livres = resp;
    });
    */
   private load(): void {
    this.livres = null;
   }
}


