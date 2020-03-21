import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SignUpPage {

    navigateToSignupPage() {
        return browser.get('/signup');
    }

    getSignUpButton() {
        return element(by.className('btn btn-block mybtn btn-primary tx-tfm'));
    }

    sendNameForSignUp() {
        return element(by.id('name'));
    }

    sendEmailForSignUp() {
        return element(by.id('email'));
    }

    sendPasswordForSignUp() {
        return element(by.id('password'));
    }

    sendLanguageForSignUp() {
        return element(by.id('language'));
    }

}