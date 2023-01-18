import { Component } from '@angular/core';
import { Auteur } from 'src/model';
import { AuthService } from '../auth.service';
import { AuteurhttpService } from './auteurhttp.service';
import { LivrehttpService } from './livrehttp.service';

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
