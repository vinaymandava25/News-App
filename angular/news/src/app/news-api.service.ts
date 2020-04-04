import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}
@Injectable({
  providedIn: 'root'
})
export class NewsApiService {


  userId: any;
  user: any;
  articles: any;
  articleUrl: string = "/news-service/rest/saveArticle";
  favArticleUrl: string = "/news-service/rest/getFavArticles";
  deleteArticleUrl: string = "/news-service/rest/deleteArticle";
  languageCode: any;
  api_key = 'cc190edd640a47b3a861a41171404af4';
  constructor(private http: HttpClient) { }

  setArticles(articles) {
    this.articles = articles;
  }
  getArticles() {
    return this.articles;
  }


  initSources() {
    return this.http.get('https://newsapi.org/v2/sources?language=' + this.languageCode + '&apiKey=' + this.api_key);
  }
  getArticlesByID(source: String) {
    return this.http.get('https://newsapi.org/v2/top-headlines?sources=' + source + '&apiKey=' + this.api_key);
  }
  saveArticle(articleJson): Observable<any> {
    return this.http.post<any>(this.articleUrl, articleJson, httpOptions);
  }
  deleteArticle(user): Observable<any> {
    console.log(user);
    return this.http.post<any>(this.deleteArticleUrl, user, httpOptions);
  }
  getFavArticles(userId) {
    console.log(userId);
    return this.http.get<any>(this.favArticleUrl + '/' + userId, httpOptions);

  }
  searchNews(keyword) {
    return this.http.get('https://newsapi.org/v2/everything?q=' + keyword + '&apiKey=' + this.api_key);
  }

} 
