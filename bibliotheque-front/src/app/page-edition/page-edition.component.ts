import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EditionDTO } from 'src/model';
import { EditionHTTPService } from './edition-http.service';

@Component({
  selector: 'app-page-edition',
  templateUrl: './page-edition.component.html',
  styleUrls: ['./page-edition.component.scss']
})
export class PageEditionComponent {

  fetchedEdition: EditionDTO;

  constructor(private route: ActivatedRoute, private livreHTTPService: EditionHTTPService) {
    // Récupère les paramètres de la requète ; on attends un id d'édition à inspecter.
    this.route.queryParams.subscribe(p => {
      let idEdition: number = p['id'];
      // Avec cet id : on envoie une requête en back pour récupérer les infos :
      this.livreHTTPService.findById(idEdition).subscribe(resp => {
        console.log(resp);
        this.fetchedEdition = resp;
      });
    });
  }
}