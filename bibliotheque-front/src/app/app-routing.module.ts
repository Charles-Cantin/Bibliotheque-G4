import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageBibliothecaireComponent } from './page-bibliothecaire/page-bibliothecaire.component';
import { InscriptionComponent } from './page-connexion/inscription/inscription.component';
import { PageLecteurComponent } from './page-lecteur/page-lecteur.component';
import { PageEditionComponent } from './page-edition/page-edition.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';
import { PageExemplairesComponent } from './page-exemplaires/page-exemplaires.component';
import { PageAdminComponent } from './page-admin/page-admin.component';

const routes: Routes = [
  {path: "", redirectTo: "livre", pathMatch: 'full'},
  {path: "inscription", redirectTo: "connexion"},
  {path: "connexion", component: PageConnexionComponent},
  {path: "bibliothecaire", component: PageBibliothecaireComponent},
  {path: "lecteur", component: PageLecteurComponent},
  {path: "admin", component: PageAdminComponent},
  {path: "livre", component: PageEditionComponent},
  {path: "exemplaires", component: PageExemplairesComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
