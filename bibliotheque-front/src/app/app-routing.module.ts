import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';

const routes: Routes = [
  {path: "", component: PageConnexionComponent, pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
