import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { AlertsService } from 'angular-alert-module';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {

  favouriteArticles: any;
  constructor(private newsApi: NewsApiService, private loaderService: NgxUiLoaderService, private alertsService: AlertsService) { }

  articleJson: any;
  ngOnInit() {
    this.favouriteArticles = this.newsApi.getArticles();
  }
  deleteArticle(article) {
    this.loaderService.start();

    this.articleJson = article;
    this.articleJson.userId = this.newsApi.userId;
    this.newsApi.deleteArticle(this.articleJson)
      .subscribe(data => {
        this.alertsService.setMessage('Deleted successfully!', 'success')
        this.favouriteArticles = data.articles;
        this.newsApi.setArticles(data.articles);
        this.loaderService.stop();

      });
  }

}
