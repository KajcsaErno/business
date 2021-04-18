import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BusinessListComponent} from './business-list/business-list.component'
import {OpenBuisnesComponent} from './open-buisnes/open-buisnes.component'

const routes: Routes = [
  { path: 'allBusinesses', component: BusinessListComponent },
  { path: 'busines/:id', component: OpenBuisnesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
