import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})
export class SignupService {

  signupUrl: string = "/news-service/signup";
  languageUrl:string ="/news-service/getLanguages";
  constructor(private http: HttpClient) { }

  addAnalyst(user): Observable<any>{  
    console.log(user);
      return this.http.post<any>(this.signupUrl,user,httpOptions);
  }
  getanalyst():Observable<any>{
    return this.http.get<any>(this.languageUrl);
  }
}
