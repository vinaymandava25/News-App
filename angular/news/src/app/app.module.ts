import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { NewsComponent } from './news/news.component';
import { AdminComponent } from './admin/admin.component';
import { HeaderComponent } from './header/header.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { APP_BASE_HREF } from '@angular/common';
import { JwtInterceptor } from './interceptor/interceptor';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    NewsComponent,
    AdminComponent,
    HeaderComponent,
    FavouritesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

  ],
  exports: [
    HeaderComponent
  ],
  providers: [{ provide: APP_BASE_HREF, useValue: '/' },
  { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
