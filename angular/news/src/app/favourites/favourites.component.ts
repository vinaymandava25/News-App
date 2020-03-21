import { Component, OnInit } from '@angular/core';
import { NewsApiService } from '../news-api.service';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.css']
})
export class FavouritesComponent implements OnInit {

  favouriteArticles: any;
  constructor(private newsApi: NewsApiService) { }

  articleJson:any;
  ngOnInit() {

    this.favouriteArticles = this.newsApi.user.user.articles;
    console.log(this.favouriteArticles)
  }
  deleteArticle(article) {
    console.log(article)
    this.articleJson = article;
    this.articleJson.userId = this.newsApi.userId;
    this.newsApi.deleteArticle(this.articleJson)
      .subscribe(data => {
        this.favouriteArticles = data.articles;
        });
  }

}
