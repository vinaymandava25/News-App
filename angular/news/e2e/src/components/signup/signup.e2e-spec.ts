import { protractor, browser } from 'protractor';
import { NewsPage } from '../news/news.po';
import { SignUpPage } from './signup.po';

describe('Signup page', () => {
    let page: SignUpPage;
    let  news = new NewsPage();
    // tslint:disable-next-line:label-position
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new SignUpPage();
        page.navigateToSignupPage();
    });
    it('should be able to signup', () => {
        page.sendNameForSignUp().sendKeys('vinaymandava');
        page.sendEmailForSignUp().sendKeys('vinaymk@gmail.com');
        page.sendPasswordForSignUp().sendKeys('123456');
        page.sendLanguageForSignUp().sendKeys('French');
        page.getSignUpButton().click();
        expect(browser.driver.getCurrentUrl()).toContain('/signup');
    });
});


