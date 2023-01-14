import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageBibliothecaireComponent } from './page-bibliothecaire/page-bibliothecaire.component';
import { InscriptionComponent } from './page-connexion/inscription/inscription.component';
import { PageLecteurComponent } from './page-lecteur/page-lecteur.component';
import { PageEditionComponent } from './page-edition/page-edition.component';

const routes: Routes = [
  {path: "", redirectTo: "livre", pathMatch: 'full'},
  {path: "inscription", component: InscriptionComponent},
  {path: "bibliothecaire", component: PageBibliothecaireComponent},
  {path: "lecteur", component: PageLecteurComponent},
  {path: "livre", component: PageEditionComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
