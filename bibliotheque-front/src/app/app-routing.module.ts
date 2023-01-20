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
import { PageAccesComponent } from './page-acces/page-acces.component';
import { AboutComponent } from './about/about.component';
import { FaqComponent } from './faq/faq.component';

const routes: Routes = [
  {path: "", redirectTo: "home", pathMatch: 'full'},
  // Recherches
  {path: "home", component: HomeComponent},
  {path: "recherche", component: RechercheComponent},
  //Connexions
  {path: "connexion", component: PageConnexionComponent},
  //Comptes
  {path: "bibliothecaire", component: PageBibliothecaireComponent},
  {path: "lecteur", component: PageLecteurComponent},
  {path: "admin", component: PageAdminComponent},
  // Acces
  {path: "acces", component: PageAccesComponent},
  // CRUDs
  {path: "livre", component: PageEditionComponent},
  {path: "about", component: AboutComponent},
  {path: "exemplaires", component: PageExemplairesComponent},
  {path: "**", pathMatch: 'full', component: FaqComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
