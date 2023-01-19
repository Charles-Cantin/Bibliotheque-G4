import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-page-admin',
  templateUrl: './page-admin.component.html',
  styleUrls: ['./page-admin.component.scss']
})
export class PageAdminComponent {

  constructor(authService: AuthService){
    authService.kickSiMauvaisCompte('admin');
  }

}
