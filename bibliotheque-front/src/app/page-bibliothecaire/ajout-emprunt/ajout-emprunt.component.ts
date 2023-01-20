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

  let dateFin: Date = this.addDays(dateDebut, 21);
  let Dayf: number = dateDebut.getDate();
  let Monthf: number = dateDebut.getMonth()+1; 
  let Yearf: number = dateDebut.getFullYear();
  let dateStringf: string = Yearf +"-"+ ((Monthf < 10) ? "0" : "") + Monthf +"-"  + ((Dayf < 10) ? "0" : "") + Dayf;

  this.formEmprunt = {idEmprunteur:null,idExemplaire:null, debut: dateString, fin: dateStringf};
  console.log(dateString);
  
}

save_emprunt():void{

  this.ajoutEmpruntService.sendAjoutEmpruntDTO(this.formEmprunt).subscribe();
  alert("Emprunt ajouté !");
  this.cancel_emprunt;
  
}

addDays(date: Date, days: number): Date {
  date.setDate(date.getDate() + days);
  return date;
}
}
