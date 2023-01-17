import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Emprunt, EmpruntDTO } from 'src/model';
import { AuthService } from '../auth.service';
import { PageLecteurHttpService } from './page-lecteur-http.service';

@Component({
  selector: 'app-page-lecteur',
  templateUrl: './page-lecteur.component.html',
  styleUrls: ['./page-lecteur.component.scss']
})
export class PageLecteurComponent {

  id_emprunteur : number ;
  emprunts: Array<EmpruntDTO> = new Array<EmpruntDTO>();

constructor(private pageLecteurService: PageLecteurHttpService, private authService: AuthService) {
  authService.kickSiMauvaisCompte('inscrit')
}

list():Array<EmpruntDTO> {
  return this.pageLecteurService.findAll();
  

}


}
