import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { LivreService } from '../livre.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.scss']
})
export class SearchBarComponent {

  @Input() searchText: string = null;
  @Input() maListeDeClasses: string[] = ['form-control'];

  constructor(private livreService: LivreService, private router: Router){}

  public goToSearch() {

      this.router.navigate(['/recherche'], { queryParams :{'search': this.searchText}});
   }

  public ecriretitre() {

  alert("Veuillez renseigner un titre")
}


  }

