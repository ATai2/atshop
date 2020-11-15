import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserninfoComponent } from './userninfo/userninfo.component';
import {FormsModule} from "@angular/forms"
import {HttpClientModule} from "@angular/common/http"
import {from} from "rxjs"

@NgModule({
  declarations: [
    AppComponent,
    UserninfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
