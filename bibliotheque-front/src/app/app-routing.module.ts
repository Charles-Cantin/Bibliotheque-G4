import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageBibliothecaireComponent } from './page-bibliothecaire/page-bibliothecaire.component';
import { InscriptionComponent } from './page-connexion/inscription/inscription.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';
import { PageLecteurComponent } from './page-lecteur/page-lecteur.component';

const routes: Routes = [
  {path: "", component: PageConnexionComponent, pathMatch: 'full'},
  {path: "inscription", component: InscriptionComponent},
  {path: "bibliothecaire", component: PageBibliothecaireComponent},
  {path: "lecteur", component: PageLecteurComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
