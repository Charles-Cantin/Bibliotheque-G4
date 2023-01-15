import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageBibliothecaireComponent } from './page-bibliothecaire/page-bibliothecaire.component';
import { ConnexionComponent } from './page-connexion/connexion/connexion.component';
import { InscriptionComponent } from './page-connexion/inscription/inscription.component';
import { PageLecteurComponent } from './page-lecteur/page-lecteur.component';
import { PageEditionComponent } from './page-edition/page-edition.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';

const routes: Routes = [
  {path: "", redirectTo: "livre", pathMatch: 'full'},
  {path: "inscription", component: InscriptionComponent},
  {path: "home", component: HomeComponent},
  {path: "connexion", component: PageConnexionComponent},
  {path: "bibliothecaire", component: PageBibliothecaireComponent},
  {path: "lecteur", component: PageLecteurComponent},
  {path: "livre", component: PageEditionComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
