import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  userId: any;
  userName: any;
  userNames: string = "/news-service/rest/getUsersOnSearch";
  blockUrl: string = "/news-service/rest/blockAnalyst/"
  constructor(private http: HttpClient) { }

  usersOnSearch(name): Observable<any> {
    return this.http.get<any>(this.userNames + "/" + name);
  }
  blockAnalyst(email): Observable<any> {
    return this.http.get<any>(this.blockUrl + email);
  }

}
