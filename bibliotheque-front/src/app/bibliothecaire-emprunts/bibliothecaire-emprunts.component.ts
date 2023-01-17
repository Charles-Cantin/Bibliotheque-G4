import { Component } from '@angular/core';
import { Emprunt, EmpruntDetail } from 'src/model';
import { BibliothecaireEmpruntsHttpService } from './bibliothecaire-emprunts-http.service';

@Component({
  selector: 'app-bibliothecaire-emprunts',
  templateUrl: './bibliothecaire-emprunts.component.html',
  styleUrls: ['./bibliothecaire-emprunts.component.scss']
})
export class BibliothecaireEmpruntsComponent {

  Empruntdetailrendu: EmpruntDetail = null;
  
  formEmpruntrendu : EmpruntDetail;
 

  constructor(private bibliothecair_emprunt:BibliothecaireEmpruntsHttpService) {
  }

  list(): Array<EmpruntDetail> {
    return this.bibliothecair_emprunt.findAll();
  }

Rendrelivre(id : number) :void{

this.bibliothecair_emprunt.rendrebyid(id);


}

}
