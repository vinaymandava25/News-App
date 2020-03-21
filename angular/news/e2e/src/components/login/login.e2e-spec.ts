import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { NewsPage } from '../news/news.po';

describe('Login page', () => {
    let page: LoginPage;
    let  news = new NewsPage();
    // tslint:disable-next-line:label-position
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
     
        page.navigateToLoginPage();
    });
    it('should be able to login', () => {
        page.sendEmailForLogin().sendKeys('vinay@gmail.com');
        page.sendPasswordForLogin().sendKeys('123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(news.getTitle()));
       expect(browser.driver.getCurrentUrl()).toContain('/news');
    });
    it('should be not be able to login if email is wrong', () => {
        page.sendEmailForLogin().sendKeys('email@gmail.com');
        page.sendPasswordForLogin().sendKeys('123456');
        page.getLoginButton().click();
    });
});


