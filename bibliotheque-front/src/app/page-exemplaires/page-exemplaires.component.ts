import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EditionDTO, ExemplaireByEditionDTO } from 'src/model';
import { EditionHTTPService } from '../page-edition/edition-http.service';
import { ExemplaireHttpService } from './exemplaire-http.service';

@Component({
  selector: 'app-page-exemplaires',
  templateUrl: './page-exemplaires.component.html',
  styleUrls: ['./page-exemplaires.component.scss']
})
export class PageExemplairesComponent {

  exemplaires: Array<ExemplaireByEditionDTO>;
  displayedEdition: EditionDTO;

  constructor(private route: ActivatedRoute, private exemplaireHttpService: ExemplaireHttpService, private editionService: EditionHTTPService) {
    // Récupère les paramètres de la requète ; on attends un id d'édition à inspecter.
    this.route.queryParams.subscribe(p => {
      let idEdition: number = p['id'];
      // Avec cet id : on envoie une requête en back pour récupérer les infos :
      this.exemplaireHttpService.findByEdition(idEdition).subscribe( resp => {this.exemplaires = resp;} );
      // Au passage, on récupère les infos de cette édition depuis le back :
      this.editionService.findById(idEdition).subscribe(resp => { this.displayedEdition = resp; })
    });
  }

  list(): Array<ExemplaireByEditionDTO> {
    return this.exemplaires;
  }

}
