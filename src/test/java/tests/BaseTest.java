package tests;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.hackathon.api.ApiClient;
import ge.tbc.testautomation.hackathon.utils.Constants;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser     browser;
    protected Page        page;

    protected RequestSpecification requestSpec;

    @Parameters({"browserName"})
    @BeforeSuite
    public void suiteSetup(@Optional("chromium") String browserName) {
        requestSpec = ApiClient.buildBaseSpec();
    }

    @Parameters({"browserName", "viewportWidth", "viewportHeight"})
    @BeforeMethod
    public void setUp(
            @Optional("chromium") String browserName,
            @Optional("1280")     String viewportWidth,
            @Optional("720")      String viewportHeight) {

        playwright = Playwright.create();
        browser    = launchBrowser(playwright, browserName);
        page       = browser.newPage();

        page.setViewportSize(
                Integer.parseInt(viewportWidth),
                Integer.parseInt(viewportHeight)
        );
        page.setDefaultTimeout(Constants.DEFAULT_TIMEOUT_MS);
    }

    @AfterMethod
    public void tearDown() {
        if (page       != null) page.close();
        if (browser    != null) browser.close();
        if (playwright != null) playwright.close();
    }

    protected RequestSpecification authSpec(String token) {
        return ApiClient.withAuth(requestSpec, token);
    }

    private static Browser launchBrowser(Playwright pw, String browserName) {
        BrowserType.LaunchOptions opts = new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setSlowMo(100);

        return switch (browserName.toLowerCase()) {
            case "firefox" -> pw.firefox().launch(opts);
            case "webkit"  -> pw.webkit().launch(opts);
            default        -> pw.chromium().launch(opts);
        };
    }
}
