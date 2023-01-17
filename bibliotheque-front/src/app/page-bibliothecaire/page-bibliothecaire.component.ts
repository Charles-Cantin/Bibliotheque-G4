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

  formAuteur:Auteur=null;

  formLivre = {titre:"",resume:"",publication:"",auteurs:-1};

  constructor(private authService: AuthService,private auteurService: AuteurhttpService,private livreService: LivrehttpService) {
    authService.kickSiMauvaisCompte('bibliothecaire')
  
  }

  add():void {
    this.formAuteur = new Auteur();
    
  }

listauteurs() : Array<Auteur>{
 return this.auteurService.findAll()
}

cancel_auteur(): void {
  this.formAuteur = null;
}

save_auteur(): void {
  
  this.auteurService.create(this.formAuteur);
  this.cancel_auteur();
}

cancel_livre(): void {
  this.formLivre= {titre:null,resume:null,publication:null,auteurs:null};
}

save_livre():void{

  this.livreService.sendlivreDTO(this.formLivre).subscribe();
  alert("Livre ajouté !");
  this.cancel_livre;
  
}


}
