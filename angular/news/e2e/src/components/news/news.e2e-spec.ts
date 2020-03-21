
import { protractor, browser } from 'protractor';
import { NewsPage } from '../news/news.po';

describe('News page', () => {
    let page: NewsPage;
    let  news = new NewsPage();
    // tslint:disable-next-line:label-position
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new NewsPage();
        page.navigateToNewsPage();
     
    });
    it('should be able to search', () => {
        page.sendForSearch().sendKeys('bitcoin');
        page.getSearchButton().click();
    });
});


