import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { LoginComponent } from '../login/login.component';
import { LoginService } from '../login.service';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { AlertsService } from 'angular-alert-module';



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
  count: any;
  disablesFlag = false;
  ngOnInit() {

    this.loaderService.start();
    
    this.user = this.newsApi.user.user;
    this.newsApi.initSources().subscribe(
      data => this.Sources = data['sources']
    );
    this.loaderService.stop();
    
  }
  constructor(private alertService:AlertsService,private newsApi: NewsApiService, private loaderService: NgxUiLoaderService) { }

  searchArticles(source) {
    console.log("selected source is: " + source);
    this.loaderService.start();
    this.newsApi.getArticlesByID(source)
      .subscribe(
        data => {
          this.Articles = data['articles'];
          this.loaderService.stop();
        });

  }
  articles(sourceName, title, author, description, url, publishedAt, content) {
    this.loaderService.start();

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
    
    this.newsApi.saveArticle(articleJson)
      .subscribe(data => {
        
        this.alertService.setMessage('Added to favourites !', 'success') 
        this.newsApi.articles = data.articles;
        this.loaderService.stop();

      });
  }


  searchNews() {
    this.loaderService.start();

    this.newsApi.searchNews(this.search).subscribe((data: any) => {
      this.searchNewsClicked = true;
      this.searchedNews = data['articles'];
      this.loaderService.stop();

    });
  }

}
