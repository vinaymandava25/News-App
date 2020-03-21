import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupComponent } from './signup.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { SignupService } from '../signup.service';
import { Routes } from '@angular/router';
import { NewsComponent } from '../news/news.component';
import { LoginComponent } from '../login/login.component';
import { AdminComponent } from '../admin/admin.component';
import { FavouritesComponent } from '../favourites/favourites.component';
import { AppComponent } from '../app.component';
import { HeaderComponent } from '../header/header.component';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';
describe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;

  beforeEach(async(() => {
    const routes: Routes = [
      { path: "news", component: NewsComponent },
      { path: "signup", component: SignupComponent },
      { path: "", component: SignupComponent },
      { path: "login", component: LoginComponent },
      { path: "search", component: AdminComponent },
      { path: "favourite", component: FavouritesComponent }
    ];
    TestBed.configureTestingModule({
      declarations: [SignupComponent,
        AppComponent,
        LoginComponent,
        NewsComponent,
        AdminComponent,
        HeaderComponent,
        FavouritesComponent],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,

      ],
      providers: [SignupService,{provide: APP_BASE_HREF, useValue : '/' }]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should be able to signup', () => {
    component.signupForm.controls['name'].setValue('vinaykumar');
    component.signupForm.controls['email'].setValue('vk@gmail.com');
    component.signupForm.controls['password'].setValue('vinayk');
    component.signupForm.controls['language'].setValue('French');
    expect(component.signupForm.valid).toBeTruthy();
  });
  it('should not be able to signup', () => {
    component.signupForm.controls['name'].setValue('');
    component.signupForm.controls['email'].setValue('');
    component.signupForm.controls['password'].setValue('');
    component.signupForm.controls['language'].setValue('');
    expect(component.signupForm.valid).toBeFalsy();
  });
  it('form invalid when email pattern is wrong', () => {
    component.signupForm.controls['email'].setValue('vinay');
    expect(component.signupForm.valid).toBeFalsy();
    expect(component.signupForm.controls['email'].valid).toBeFalsy();
  });
  it('form invalid when name is lengthy', () => {
    component.signupForm.controls['name'].setValue('sdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffsdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjsjs');
    expect(component.signupForm.valid).toBeFalsy();
    expect(component.signupForm.controls['name'].valid).toBeFalsy();
  });
  it('form invalid when password is lengthy', () => {
    component.signupForm.controls['password'].setValue('sdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffsdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjssdfbkajsdbfklajsdfkljasbdkfbaskdbfkasjdfbaskdjbfkasjdbfkasdbfkasdbfkasbdfkjbasdkfjbaskdfjbaskdfbkasjdbfkasdbfkajsbdfkbasdkfbaskdfbkasdbfkasbffjsjs');
    expect(component.signupForm.valid).toBeFalsy();
    expect(component.signupForm.controls['password'].valid).toBeFalsy();
  });
  it('form invalid when password is short', () => {
    component.signupForm.controls['password'].setValue('vinay');
    expect(component.signupForm.valid).toBeFalsy();
    expect(component.signupForm.controls['password'].valid).toBeFalsy();
  });
});
