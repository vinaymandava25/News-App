import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { NewsComponent } from './news/news.component';
import { AdminComponent } from './admin/admin.component';
import { HeaderComponent } from './header/header.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { Routes } from '@angular/router';
import { APP_BASE_HREF } from '@angular/common';


describe('AppComponent', () => {
  const routes: Routes = [
    {path:"news",component:NewsComponent},
    {path:"signup",component:SignupComponent},
    {path:"",component:SignupComponent},
    {path:"login",component:LoginComponent},
    {path:"search",component:AdminComponent},
    {path:"favourite",component:FavouritesComponent},
    {path : "head", component: HeaderComponent}
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
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
      providers: [{provide: APP_BASE_HREF, useValue : '/' }],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'news'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('news');
  });

 
});
