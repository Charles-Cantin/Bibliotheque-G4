import { Injectable } from '@angular/core';
import { Compte } from 'src/model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedInAccount: Compte;

  constructor() {}

  getLoggedInAccount(): Compte {
    /* Fetches the locally stored (in nav) account infos, and syncs it with
     * the internal variable of the service.*/
    let storedLoggedInAccount = JSON.parse( localStorage.getItem("loggedInAccount") );
    return storedLoggedInAccount;
  }

  setLoggedInAccount(compte: Compte): void {
    /* Sets the locally stored (in nav) account infos.
     * If compte is null; removes the item ; otherwise, updates it. */
    if (compte==null) {
      localStorage.removeItem('loggedInAccount')
    }
    else {
      localStorage.setItem('loggedInAccount', JSON.stringify(compte) );
    }
  }
}
