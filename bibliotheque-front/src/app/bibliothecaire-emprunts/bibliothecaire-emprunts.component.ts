import { Component } from '@angular/core';
import { EmpruntDetail } from 'src/model';
import { BibliothecaireEmpruntsHttpService } from './bibliothecaire-emprunts-http.service';

@Component({
  selector: 'app-bibliothecaire-emprunts',
  templateUrl: './bibliothecaire-emprunts.component.html',
  styleUrls: ['./bibliothecaire-emprunts.component.scss']
})
export class BibliothecaireEmpruntsComponent {

  Empruntdetailrendu: EmpruntDetail = null;

  constructor(private bibliothecair_emprunt:BibliothecaireEmpruntsHttpService) {
  }

  list(): Array<EmpruntDetail> {
    return this.bibliothecair_emprunt.findAll();
  }

Rendrelivre(id : number) :void{

 
  
}

}
