import { Component } from '@angular/core';
import { AjoutEmpruntHttpService } from './ajout-emprunt-http.service';

@Component({
  selector: 'app-ajout-emprunt',
  templateUrl: './ajout-emprunt.component.html',
  styleUrls: ['./ajout-emprunt.component.scss']
})
export class AjoutEmpruntComponent {

formEmprunt = {idEmprunteur:-1,idExemplaire:-1,debut:""};

constructor(private ajoutEmpruntService: AjoutEmpruntHttpService) {
}

cancel_emprunt(): void {
  this.formEmprunt = {idEmprunteur:null,idExemplaire:null,debut:""};
}

save_emprunt():void{

  this.ajoutEmpruntService.sendAjoutEmpruntDTO(this.formEmprunt).subscribe();
  alert("Emprunt ajouté !");
  this.cancel_emprunt;
  
}
}
