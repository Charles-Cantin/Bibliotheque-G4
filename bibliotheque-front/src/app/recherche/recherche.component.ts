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
  focusedRow: number;
  livres:Array<Livre>;

  constructor(private livreService: LivreService, private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
      let searchTerm:string = params['search'];
      this.livreService.findByTitle(searchTerm).subscribe(resp => {
        this.livres = resp;
        console.log(resp);
      })
    })
  }
}
