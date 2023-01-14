import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Compte } from 'src/model';
import { GlobalVariablesService } from '../global-variables.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  constructor(protected gvs: GlobalVariablesService, private router: Router){}

  unAuth(): void {
    this.gvs.compteConnecte = null;
    this.router.navigate(['']);
  }

}