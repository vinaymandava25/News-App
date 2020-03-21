import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class NewsPage {

    navigateToNewsPage() {
        return browser.get('/news');
    }
    getTitle() {
        return element(by.css('h1'));
    }
    sendForSearch() {
        return element(by.id('search'));
    }
    getSearchButton() {
        return element(by.className('btn btn-outline-secondary'));
    }

}
