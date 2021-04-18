import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BusinessListComponent } from './business-list/business-list.component';
import { BusinessService } from './business-service/business-service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OpenBuisnesComponent } from './open-buisnes/open-buisnes.component';

@NgModule({
  declarations: [
    AppComponent,
    BusinessListComponent,
    OpenBuisnesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [BusinessService],
  bootstrap: [AppComponent]
})
export class AppModule { }
