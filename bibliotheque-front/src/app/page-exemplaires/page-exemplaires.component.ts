import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExemplaireByEditionDTO } from 'src/model';
import { ExemplaireHttpService } from './exemplaire-http.service';

@Component({
  selector: 'app-page-exemplaires',
  templateUrl: './page-exemplaires.component.html',
  styleUrls: ['./page-exemplaires.component.scss']
})
export class PageExemplairesComponent {

  exemplaires: Array<ExemplaireByEditionDTO>;

  constructor(private route: ActivatedRoute, private exemplaireHttpService: ExemplaireHttpService) {
    // Récupère les paramètres de la requète ; on attends un id d'édition à inspecter.
    this.route.queryParams.subscribe(p => {
      let idEdition: number = p['id'];
      // Avec cet id : on envoie une requête en back pour récupérer les infos :
      this.exemplaireHttpService.findByEdition(idEdition).subscribe(resp => {
        console.log(resp);
        this.exemplaires = resp;
      });
    });
  }

  list(): Array<ExemplaireByEditionDTO> {
    return this.exemplaires;
  }

}
