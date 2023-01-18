import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EmpruntDetail } from 'src/model';
import { AppConfigService } from 'src/app/app-config.service';

@Injectable({
  providedIn: 'root'
})
export class BibliothecaireEmpruntsHttpService {
  

  serviceUrl: string;
  EmpruntDetails: Array<EmpruntDetail> = new Array<EmpruntDetail>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.serviceUrl = appConfig.backEndUrl + "bibliothecaires/interface/";
    this.load();
   }


   findAll(): Array<EmpruntDetail> {
    return this.EmpruntDetails;
  }


  findById(id: number): Observable<EmpruntDetail> {
    return this.http.get<EmpruntDetail>(this.serviceUrl + id);
  }


  update(EmpruntDetail: EmpruntDetail): void {
    this.http.put<EmpruntDetail>(this.serviceUrl + EmpruntDetail.idInscrit, EmpruntDetail).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<EmpruntDetail>>(this.serviceUrl).subscribe(response => {
      this.EmpruntDetails = response;
    });
  }

  
  rendrebyid(id: number) {
    
     this.http.patch<EmpruntDetail>("http://localhost:9999/emprunts/rendre/"+id, {}).subscribe(resp=>{this.load()});
    
  }


}

