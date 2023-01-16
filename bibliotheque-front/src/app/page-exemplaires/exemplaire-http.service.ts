import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExemplaireByEditionDTO } from 'src/model';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class ExemplaireHttpService {

  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.serviceUrl = appConfig.backEndUrl + "exemplaires/";
  }

  findByEdition(idEdition: number): Observable<Array<ExemplaireByEditionDTO>> {
    return this.http.get<Array<ExemplaireByEditionDTO>>(this.serviceUrl + 'by-edition/' + idEdition);
  }
}
