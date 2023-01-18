import { Component } from '@angular/core';
import { Compte } from 'src/model';
import { GestionComptesHttpService } from './gestion-comptes-http.service';

@Component({
  selector: 'app-gestion-comptes',
  templateUrl: './gestion-comptes.component.html',
  styleUrls: ['./gestion-comptes.component.scss']
})
export class GestionComptesComponent {

  formGestionComptes: Compte = null;

  constructor(private gestionComptesService: GestionComptesHttpService){

  }

  list(): Array<Compte> {
    return this.gestionComptesService.findAll();
  }

  add():void {
    this.formGestionComptes = new Compte();
  }

  edit(id: number): void {
    this.gestionComptesService.findById(id).subscribe(resp => {
      this.formGestionComptes = resp;
    });
  }

  save(): void {
    if(this.formGestionComptes.id) { // UPDATE
      this.gestionComptesService.update(this.formGestionComptes);
    } else { // CREATE
      this.gestionComptesService.create(this.formGestionComptes);
    }

    this.cancel();
  }

  cancel(): void {
    this.formGestionComptes = null;
  }

  remove(id: number): void {
    this.gestionComptesService.remove(id);
  }

}
