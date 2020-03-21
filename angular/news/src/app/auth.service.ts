import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  loggedIn = false;
  userId: any;
  token:any;

  getUserId() {
    return this.userId;
  }

  setUserId(userId:any) {
    this.userId = userId;
  }

  login() {
    console.log("Inside auth service login()")
    this.loggedIn = true;
  }

  logout() {
    console.log("Inside auth service logout()")
    this.loggedIn = false;
  }

  getToken() {
    return this.token;
  }

  setToken(token:any) {
    this.token = token;
  }


}
