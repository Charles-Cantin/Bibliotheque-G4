import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Livre } from 'src/model';
import { LivreService } from '../livre.service';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.scss']
})



export class RechercheComponent {
  livres:Array<Livre> = this.livreService.livres;
  searchTerm:string;

  constructor(private livreService: LivreService, private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
      console.log(params[0]);
      this.searchTerm = params[0];
      this.livreService.findByTitle(this.searchTerm);
      this.livres = this.livreService.livres;
    })
  }
}
