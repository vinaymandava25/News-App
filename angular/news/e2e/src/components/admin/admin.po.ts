import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class AdminPage {

    navigateToAdminPage() {
        return browser.get('/search');
    }

    sendKeywordForSearch() {
        return element(by.id('keyword'));
    }

    getSearchButton() {
        return element(by.className('btn btn-outline-secondary'));
    }
}
