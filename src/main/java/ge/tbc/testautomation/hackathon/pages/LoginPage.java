package ge.tbc.testautomation.hackathon.pages;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.hackathon.utils.Constants;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate(Constants.LOCAL_UI_URL + Constants.ROUTE_LOGIN);
        page.waitForLoadState();
    }

    public void fillUsername(String username) {
        page.locator(Constants.INPUT_USERNAME).first().fill(username);
    }

    public void fillPassword(String password) {
        page.locator(Constants.INPUT_PASSWORD).fill(password);
    }

    public void clickLoginButton() {
        page.locator(Constants.BTN_LOGIN).first().click();
    }

    public boolean isErrorVisible() {
        return page.locator(Constants.LBL_ERROR).count() > 0
                && page.locator(Constants.LBL_ERROR).first().isVisible();
    }

    public String getErrorText() {
        return page.locator(Constants.LBL_ERROR).first().textContent().trim();
    }

    public boolean isOnLoginPage() {
        return page.url().contains("/login");
    }
}