import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
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

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
    const routes: Routes = [
      { path: "", component: LoginComponent },
      { path: "login", component: LoginComponent },
      { path: "signup", component: SignupComponent },
      { path: "news", component: NewsComponent }
    ];
    TestBed.configureTestingModule({
      declarations: [LoginComponent, HeaderComponent, NewsComponent],
      imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule,
      ], providers: [
        { provide: APP_BASE_HREF, useValue: '/' }, LoginService
      ]
    })
      .compileComponents().then(() => {
        fixture = TestBed.createComponent(LoginComponent);
        component = fixture.componentInstance;
        de = fixture.debugElement.query(By.css('form'));
        el = de.nativeElement;
      });
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should valid when field is not empty', async(() => {
    //accessing controls
    component.loginForm.controls['email'].setValue('vk@gmail.com');
    component.loginForm.controls['password'].setValue('vinayk');
    expect(component.loginForm.valid).toBeTruthy();
  }));
  it('form should invalid when empty', async(() => {
    //accessing controls
    component.loginForm.controls['email'].setValue('');
    component.loginForm.controls['password'].setValue('');
    expect(component.loginForm.valid).toBeFalsy();
  }));

  it('form invalid when email pattern is wrong ', async(() => {
    component.loginForm.controls['email'].setValue('vinay');
    expect(component.loginForm.valid).toBeFalsy();
    expect(component.loginForm.controls['email'].valid).toBeFalsy();
  }));

  it('form invalid when password character less than 6', async(() => {
    component.loginForm.controls['password'].setValue('vinay');
    expect(component.loginForm.valid).toBeFalsy();
    expect(component.loginForm.controls['password'].valid).toBeFalsy();
  }));

  it('is form invalid when password character more than 50', async(() => {
    component.loginForm.controls['password'].setValue('xfhszdgsdzgdgsdfdsdgbsdzgsgsdgdvsdgvdgvdgdgvdgvdgvbdgvbdsdfsadfsafdsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff');
    expect(component.loginForm.valid).toBeFalsy();
    expect(component.loginForm.controls['password'].valid).toBeFalsy();
  }));

  it('should call the login method', async(() => {
    fixture.detectChanges();
    spyOn(component, 'login');
    el = fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.login).toHaveBeenCalledTimes(0);
  }));

  it('Mock service', async(() => {
    let loginService: LoginService = fixture.debugElement.injector.get(LoginService);
    const response: any = JSON.parse(JSON.stringify({
      "authenticated": "true",
      "user": {
        "status": "true",
        "userLanguage": {
          "languageCode": "en"
        }
      }
    }));
    console.log(response);
    spyOn(loginService, 'authenticate').and.returnValue(of(response));
    // spyOn(newsService,'authenticate').and.returnValue(of(login)); 
    component.login();
    expect(loginService.authenticate).toHaveBeenCalledTimes(1);
  }));

});
