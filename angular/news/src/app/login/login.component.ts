import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { NewsApiService } from '../news-api.service';
import { NewsComponent } from '../news/news.component';
import { AuthService } from '../auth.service';
import { HeaderComponent } from '../header/header.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  languageCode: any;
  success: boolean;
  blocked:boolean;
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required,
    Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
    Validators.maxLength(255),
    ]),
    password: new FormControl('', [Validators.required,
    Validators.minLength(6),
    Validators.maxLength(50)])
  });

  constructor(private router: Router, private loginService: LoginService, private news: NewsApiService, private authService: AuthService) { }

  ngOnInit() {
  }

  login() {
    this.loginService.authenticate(this.loginForm.value)
      .subscribe(data => {
        console.log("Response: " + data.user)
        if (data.authenticated == true && data.user.status) {

          this.authService.login();
          this.authService.setUserId(data.user.id);
          this.authService.setToken(data.token);
          this.languageCode = data.user.userLanguage.languageCode;
          this.news.languageCode = this.languageCode;
          this.news.userId = data.user.id;//Sending UserId to news component
          this.news.user = data;
          console.log(data)
          if (data.user.isadmin == true) {
            this.router.navigate(['/search']);
          } else {
            this.router.navigate(['/news']);
          }
        }
        else if (!data.user.status) {
            this.blocked=true;
        }
        else {
          this.success = true;
        }
      });
  }
}
