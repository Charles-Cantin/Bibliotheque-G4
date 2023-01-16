import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LivreService } from '../livre.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent {

  searchText: string = null;

  constructor(private livreService: LivreService, private router: Router){

  }

  public goToSearch() {
    this.router.navigate(['/recherche'], { queryParams :{'search': this.searchText}});
   }
}
