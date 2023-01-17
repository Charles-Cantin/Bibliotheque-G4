import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PageLecteurComponent } from './page-lecteur/page-lecteur.component';
import { PageBibliothecaireComponent } from './page-bibliothecaire/page-bibliothecaire.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';
import { HttpClientModule } from '@angular/common/http';
import { ConnexionComponent } from './page-connexion/connexion/connexion.component';
import { InscriptionComponent } from './page-connexion/inscription/inscription.component';
import { FooterComponent } from './footer/footer.component';
import { PageEditionComponent } from './page-edition/page-edition.component';
import { PageExemplairesComponent } from './page-exemplaires/page-exemplaires.component';
import { PageAdminComponent } from './page-admin/page-admin.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { RechercheComponent } from './recherche/recherche.component';
import { AjoutlivreComponent } from './page-bibliothecaire/ajoutlivre/ajoutlivre.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { BibliothecaireEmpruntsComponent } from './page-bibliothecaire/bibliothecaire-emprunts/bibliothecaire-emprunts.component';
import { AjoutEmpruntComponent } from './page-bibliothecaire/ajout-emprunt/ajout-emprunt.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PageLecteurComponent,
    PageBibliothecaireComponent,
    PageConnexionComponent,
    ConnexionComponent,
    InscriptionComponent,
    FooterComponent,
    PageEditionComponent,
    HomeComponent,
    RechercheComponent,
    PageAdminComponent,
    PageExemplairesComponent,
    AjoutlivreComponent,
    BibliothecaireEmpruntsComponent,
    SearchBarComponent,
    AjoutEmpruntComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
