import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginUrl: string= "news-service/authenticate";
  constructor(private http:HttpClient) { }

  authenticate(user){
    return this.http.post<any>(this.loginUrl,user,httpOptions);
  }
  
}
