package ge.tbc.testautomation.hackathon.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.hackathon.pages.LoginPage;
import ge.tbc.testautomation.hackathon.utils.Constants;
import io.qameta.allure.Step;

public class LoginSteps {

    private final LoginPage loginPage;
    private final Page page;

    public LoginSteps(Page page) {
        this.page = page;
        this.loginPage = new LoginPage(page);
    }

    @Step("Login as test user")
    public void loginAsTestUser() {
        loginPage.navigate();
        loginPage.fillUsername(Constants.TEST_USERNAME);
        loginPage.fillPassword(Constants.TEST_PASSWORD);
        loginPage.clickLoginButton();
        page.waitForURL("**/travel-mode**",
                new Page.WaitForURLOptions().setTimeout(Constants.SHORT_TIMEOUT_MS));
    }

    @Step("Login with username: {username}")
    public void loginWithCredentials(String username, String password) {
        loginPage.navigate();
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
    }

    @Step("Check if login error is displayed")
    public boolean isLoginErrorShown() {
        return loginPage.isErrorVisible();
    }

    @Step("Get login error message")
    public String getLoginErrorText() {
        return loginPage.getErrorText();
    }

    @Step("Verify user is still on login page")
    public boolean isStillOnLoginPage() {
        return loginPage.isOnLoginPage();
    }
}