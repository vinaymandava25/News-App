import { protractor, browser } from 'protractor';
import { AdminPage } from './admin.po';
describe('Admin page', () => {
    let page: AdminPage;
    let news = new AdminPage();
    // tslint:disable-next-line:label-position
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new AdminPage();
        page.navigateToAdminPage();
    });
    it('should be able to search', () => {
        page.sendKeywordForSearch().sendKeys('nan');
        page.getSearchButton().click();
    });
});


