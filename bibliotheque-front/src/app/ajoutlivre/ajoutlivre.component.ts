import { Component } from '@angular/core';
import { Auteur, Livre } from 'src/model';
import { AuteurhttpService } from './auteurhttp.service';
import { LivrehttpService } from './livrehttp.service';

@Component({
  selector: 'app-ajoutlivre',
  templateUrl: './ajoutlivre.component.html',
  styleUrls: ['./ajoutlivre.component.scss']
})
export class AjoutlivreComponent {

formAuteur:Auteur=null;

formLivre = {titre:"",resume:"",publication:"",auteurs:-1};

constructor(private auteurService: AuteurhttpService,private livreService: LivrehttpService) {
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
  this.formLivre = null;
}

save_livre():void{

  this.livreService.sendlivreDTO(this.formLivre).subscribe();
  alert("Livre ajouté !");
  this.cancel_livre;
  
}

}
