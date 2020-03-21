import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormArray } from '@angular/forms';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  languages: any;
  email: any;
  password: any;
  language: any;
  name: any;
  unsuccessful: any;
  signupForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
    Validators.maxLength(255)]),
    name: new FormControl('', [Validators.required,Validators.minLength(1),Validators.maxLength(70)]),
    password: new FormControl('', [Validators.required,Validators.minLength(6),Validators.maxLength(50)]),
    language: new FormControl()
  });

  constructor(private router: Router, private signupService: SignupService) { }

  ngOnInit() {
    this.signupService.getanalyst().subscribe(
      data => {
        this.languages = data;
        console.log(this.languages)
      },
    );
  }

  signup() {
    console.log(this.signupForm.value)
    let json = JSON.stringify({
      email: this.signupForm.value.email,
      name: this.signupForm.value.name,
      password: this.signupForm.value.password,
      userLanguage: {
        languageId: this.signupForm.controls['language'].value
      }
    });
    console.log("Response: " + json)
    this.signupService.addAnalyst(json)
      .subscribe(data => {
        console.log("Response: " + data.status)
        if (data.status == false) {
          this.unsuccessful = true;
        } else {
          this.router.navigate(['/login']);
        }
      });
    this.signupForm.reset();
  }
}
