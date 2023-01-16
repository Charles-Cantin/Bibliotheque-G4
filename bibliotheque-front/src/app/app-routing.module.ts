import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageBibliothecaireComponent } from './page-bibliothecaire/page-bibliothecaire.component';
import { ConnexionComponent } from './page-connexion/connexion/connexion.component';
import { InscriptionComponent } from './page-connexion/inscription/inscription.component';
import { PageLecteurComponent } from './page-lecteur/page-lecteur.component';
import { PageEditionComponent } from './page-edition/page-edition.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';
import { PageExemplairesComponent } from './page-exemplaires/page-exemplaires.component';
import { PageAdminComponent } from './page-admin/page-admin.component';
import { RechercheComponent } from './recherche/recherche.component';
import { BibliothecaireEmpruntsComponent } from './bibliothecaire-emprunts/bibliothecaire-emprunts.component';
import { AjoutlivreComponent } from './ajoutlivre/ajoutlivre.component';

const routes: Routes = [
  {path: "", redirectTo: "livre", pathMatch: 'full'},
  {path: "inscription", component: InscriptionComponent},
  {path: "home", component: HomeComponent},
  {path: "recherche", component: RechercheComponent},
  {path: "connexion", component: PageConnexionComponent},
  {path: "bibliothecaire", component: PageBibliothecaireComponent},
  {path: "lecteur", component: PageLecteurComponent},
  {path: "admin", component: PageAdminComponent},
  {path: "livre", component: PageEditionComponent},
  {path: "exemplaires", component: PageExemplairesComponent},
  {path: "bibliothecaires-emprunts", component: BibliothecaireEmpruntsComponent},
  {path: "ajout-livre", component: AjoutlivreComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
