package ge.tbc.testautomation.hackathon.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserManager {

    private Playwright playwright;
    private Browser    browser;
    private Page       page;

    public void launch(boolean headless, int slowMo) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setSlowMo(slowMo)
        );
        page = browser.newPage();
        page.setDefaultTimeout(Constants.DEFAULT_TIMEOUT_MS);
    }

    public void launch() {
        launch(false, 100);
    }

    public Page getPage() {
        return page;
    }

    public void close() {
        if (page       != null) page.close();
        if (browser    != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
