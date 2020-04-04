import { Injectable } from '@angular/core';
import * as jwt_decode from 'jwt-decode';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  loggedIn = false;
  userId: any;
  token: any;

  getUserId() {
    return this.userId;
  }

  setUserId(userId: any) {
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

  setToken(token: any) {
    this.token = token;
  }
  getTokenExpirationDate(token: string) {
    const decoded = jwt_decode(token);
    if(decoded.exp === undefined) {
      return null;
    }
    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
  }

  isTokenExpired(token?: string): boolean {
    if(!token) {
      token = this.getToken();
    }
    if(!token) {
      return true;
    }
    const date = this.getTokenExpirationDate(token);
    if(date === undefined || date === null) {
      return false;
    }
    return !(date.valueOf() > new Date().valueOf());
  }


}
