import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Livre } from 'src/model';
import { AppConfigService } from '../app-config.service';


@Injectable({
  providedIn: 'root'
})
export class LivrehttpService {
  
  
  serviceUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "livres/";
   
  }


   create(livre: Livre): void {
    this.http.post<Livre>(this.serviceUrl, livre).subscribe(resp => {
      console.log(resp)
    //tODO REDIRECTION
    });
  }

  sendlivreDTO(LivreDTO: {}):Observable<Livre> {
       return this.http.post<Livre>(this.serviceUrl, LivreDTO);
     }



}
