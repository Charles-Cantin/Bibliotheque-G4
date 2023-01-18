import { Component } from '@angular/core';
import { Auteur, Livre } from 'src/model';
import { AuteurHttpService } from './auteur-http.service';
import { LivreHttpService } from './livre-http.service';

@Component({
  selector: 'app-ajout-livre',
  templateUrl: './ajout-livre.component.html',
  styleUrls: ['./ajout-livre.component.scss']
})
export class AjoutLivreComponent {

  formAuteur: Auteur = null;
  formLivre = { titre: "", resume: "", publication: "", auteurs: -1 };

  constructor(private auteurService: AuteurHttpService, private livreService: LivreHttpService) {
  }

  add(): void {
    this.formAuteur = new Auteur();
  }

  listauteurs(): Array<Auteur> {
    return this.auteurService.findAll()
  }

  cancel_auteur(): void {
    this.formAuteur = null;
  }

  save_auteur(): void {
    this.auteurService.create(this.formAuteur);
    this.cancel_auteur();
  }

  cancel_livre(): void {
    this.formLivre = { titre: "", resume: "", publication: "", auteurs: -1 };
  }

  save_livre(): void {
    this.livreService.sendlivreDTO(this.formLivre).subscribe({
      next: (resp) => {alert("Livre ajouté !"); this.cancel_livre();},
      error: (err) => {console.error(err); alert("Une erreur est survenue."); this.cancel_livre();}
    });
  }

}
