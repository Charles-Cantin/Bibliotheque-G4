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
  formEmpruntrendu: EmpruntDetail;
  recherche: string;

  Empruntfiltre: Array<Emprunt> = new Array<Emprunt>();

  constructor(private bibliothecaireEmprunt: BibliothecaireEmpruntsHttpService) {}

  list(): Array<EmpruntDetail> {
    if (this.recherche) {
      return this.bibliothecaireEmprunt.findAll().filter(resp => resp.nomPrenomInscrit.toLowerCase().indexOf(this.recherche.toLowerCase()) != -1 || resp.titreLivre.toLowerCase().indexOf(this.recherche.toLowerCase()) != -1);
    }
    else {
      return this.bibliothecaireEmprunt.findAll()
    }
  }

  Rendrelivre(id: number): void {
    this.bibliothecaireEmprunt.rendrebyid(id);
  }
  
}
