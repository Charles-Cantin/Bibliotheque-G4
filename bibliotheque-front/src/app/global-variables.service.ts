import { Injectable } from '@angular/core';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class GlobalVariablesService {
  compteConnecte: Compte;

  constructor() { }
}
