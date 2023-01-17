import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Livre, ResultatDTO} from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  serviceUrl: string;
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "livres/";
   }

   findById(id: number): Observable<Livre> {
    return this.http.get<Livre>(this.serviceUrl + id);
  }

  findByTitle(searchText: string): Observable<Array<ResultatDTO>>{
    return this.http.post<Array<ResultatDTO>>(this.serviceUrl + "searchV1", searchText);
   }
}


