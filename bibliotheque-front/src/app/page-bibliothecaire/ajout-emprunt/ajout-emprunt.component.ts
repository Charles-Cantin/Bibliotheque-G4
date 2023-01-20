import { Component } from '@angular/core';
import { AjoutEmpruntHttpService } from './ajout-emprunt-http.service';

@Component({
  selector: 'app-ajout-emprunt',
  templateUrl: './ajout-emprunt.component.html',
  styleUrls: ['./ajout-emprunt.component.scss']
})
export class AjoutEmpruntComponent {

formEmprunt = {idEmprunteur:-1, idExemplaire:-1, debut:"", fin:""};

constructor(private ajoutEmpruntService: AjoutEmpruntHttpService) {

  this.cancel_emprunt();
}

cancel_emprunt(): void {
  let dateDebut: Date = new Date(); 
  let Day: number = dateDebut.getDate();
  let Month: number = dateDebut.getMonth()+1; 
  let Year: number = dateDebut.getFullYear();
  let dateString: string = Year +"-"+ ((Month < 10) ? "0" : "") + Month +"-"  + ((Day < 10) ? "0" : "") + Day;

  this.formEmprunt = {idEmprunteur:null,idExemplaire:null, debut: dateString, fin: dateString};
  console.log(dateString);
}

save_emprunt():void{

  this.ajoutEmpruntService.sendAjoutEmpruntDTO(this.formEmprunt).subscribe();
  alert("Emprunt ajouté !");
  this.cancel_emprunt;
  
}
}
