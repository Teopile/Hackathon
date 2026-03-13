package ge.tbc.testautomation.hackathon.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import ge.tbc.testautomation.hackathon.utils.Constants;

/**
 * Manages Playwright browser lifecycle.
 * Centralises browser creation so tests stay free of boilerplate.
 */
public class BrowserManager {

    private Playwright playwright;
    private Browser    browser;
    private Page       page;

    /**
     * Launches a Chromium browser.
     *
     * @param headless {@code true} for CI / headless runs, {@code false} for local debugging
     * @param slowMo   delay in ms between actions (0 for no slow-mo)
     */
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

    /** Launches with project defaults (headless=false, slowMo=100). */
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
