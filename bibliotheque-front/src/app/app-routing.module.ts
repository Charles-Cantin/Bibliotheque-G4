import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InscriptionComponent } from './page-connexion/inscription/inscription.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';

const routes: Routes = [
  {path: "", component: PageConnexionComponent, pathMatch: 'full'},
  {path: "inscription", component: InscriptionComponent, pathMatch: 'full'}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
