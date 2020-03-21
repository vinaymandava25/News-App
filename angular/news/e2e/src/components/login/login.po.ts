import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class LoginPage {

    navigateToLoginPage() {
        return browser.get('/login');
    }

    sendEmailForLogin() {
        return element(by.id('email'));
    }

    sendPasswordForLogin() {
        return element(by.id('password'));
    }
    getLoginButton() {
        return element(by.className('btn btn-block mybtn btn-primary tx-tfm'));
    }
}
