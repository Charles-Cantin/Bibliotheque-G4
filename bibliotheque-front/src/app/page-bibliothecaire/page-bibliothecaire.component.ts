import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-page-bibliothecaire',
  templateUrl: './page-bibliothecaire.component.html',
  styleUrls: ['./page-bibliothecaire.component.scss']
})
export class PageBibliothecaireComponent {

  constructor(private authService: AuthService) {
    authService.kickSiMauvaisCompte('bibliothecaire')
  }
}
