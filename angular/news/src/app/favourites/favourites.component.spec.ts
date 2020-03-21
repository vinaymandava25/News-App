import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FavouritesComponent } from './favourites.component';
import { DebugElement } from '@angular/core';
import { Routes } from '@angular/router';
import { By, BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from '../login.service';
import { HttpClientModule } from '@angular/common/http';
import { NewsApiService } from '../news-api.service';
import { RouterTestingModule } from '@angular/router/testing';
import { SignupComponent } from '../signup/signup.component';
import { HeaderComponent } from '../header/header.component';
import { APP_BASE_HREF } from '@angular/common';
import { of } from 'rxjs';
import { NewsComponent } from '../news/news.component';
import { AppRoutingModule } from '../app-routing.module';
import { LoginComponent } from '../login/login.component';

fdescribe('FavouritesComponent', () => {
  let component: FavouritesComponent;
  let fixture: ComponentFixture<FavouritesComponent>;

  const routes: Routes = [
    { path: "", component: LoginComponent },
    { path: "login", component: LoginComponent },
    { path: "signup", component: SignupComponent },    
    { path: "favourite", component: FavouritesComponent },    
    { path: "news", component: NewsComponent }
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FavouritesComponent, LoginComponent, HeaderComponent],
      imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule,
      ], providers: [
        { provide: APP_BASE_HREF, useValue: '/' }, NewsApiService
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavouritesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  // it('Mock service', async(() => {
  //   let newsService: NewsApiService = fixture.debugElement.injector.get(NewsApiService);
  //   const response: any = JSON.parse(JSON.stringify({
  //     "userId": "1",
  //     "sourceName": "The Hindu",
  //     "title": "title",
  //     "author": "author",
  //     "description": "description",
  //     "url": "url",
  //     "publishedAt": "publishedAt",
  //     "content": "content"
  //   }));
  //   spyOn(newsService, 'deleteArticle').and.returnValue(of(response));
  //   component.deleteArticle(response);
  //   expect(newsService.deleteArticle).toHaveBeenCalledTimes(1);
  // }));
});
