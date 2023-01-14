import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EditionDTO } from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class EditionHTTPService {

  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.serviceUrl = appConfig.backEndUrl + "editions/";
  }
  
  findById(idEdition: number): Observable<EditionDTO> {
    //return new EditionDTO(idEdition, "TITRE", 'RESUME', 'ISBN_livre', 1200, 1990, "Poche", "EDITION_TO_FILL", "Anglais", "AUTEUR_TO_FILL")
    return this.http.get<EditionDTO>(this.serviceUrl + idEdition + '/dto');
  }
}