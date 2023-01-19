import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ResultatDTO } from 'src/model';
import { SearchService } from './search.service';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.scss']
})

export class RechercheComponent {
  [x: string]: any;
  focusedRow: number;
  resultats: Array<ResultatDTO> = new Array<ResultatDTO>();
  searchText: string;

  constructor(private searchService: SearchService, private route: ActivatedRoute) {

    this.route.queryParams.subscribe(params => {
      this.searchText = params['search'];
      this.load();
    })
  }

  public load() {
    this.searchService.findByTitle(this.searchText).subscribe(resp => {
    this.resultats = resp; 
    
  })
    

  }

  public focus(clickedRowIndex: number) {
    if (this.focusedRow == clickedRowIndex) {
      this.focusedRow = -1;
    }
    else {
      this.focusedRow = clickedRowIndex;
    }
  }


}
