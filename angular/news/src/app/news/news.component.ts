import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { LoginComponent } from '../login/login.component';
import { LoginService } from '../login.service';



@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  user: any;
  userId: any;
  articleJson: any;
  Articles: any[];
  Sources: any[];
  searchedNews: any = [];
  search: any;
  favouriteArticles: any;
  searchNewsClicked: boolean = false;
  count:any;
  ngOnInit() {

   
    this.user = this.newsApi.user.user;
  
    //load news sources
    this.newsApi.initSources().subscribe(
      data => this.Sources = data['sources']
    );
  }
  constructor(private newsApi: NewsApiService) { }

  searchArticles(source) {
    console.log("selected source is: " + source);
    this.newsApi.getArticlesByID(source)
      .subscribe(
        data =>
          this.Articles = data['articles']
      );
    console.log(this.Articles);

  }
  articles(sourceName, title, author, description, url, publishedAt, content) {
    let articleJson = JSON.stringify({
      userId: this.newsApi.userId,
      sourceName: sourceName,
      title: title,
      author: author,
      description: description,
      url: url,
      publishedAt: publishedAt,
      content: content
    });
    console.log(articleJson)
    this.newsApi.saveArticle(articleJson)
      .subscribe(data => {
        console.log("Article Saved: " + data.status)
        console.log("Article : " + data)
        this.newsApi.articles=data.articles;
      });
  }


  searchNews() {
    this.newsApi.searchNews(this.search).subscribe(data => {
      console.log(data)   
      this.searchNewsClicked = true;
      this.searchedNews = data['articles'];
    });
  }

}
