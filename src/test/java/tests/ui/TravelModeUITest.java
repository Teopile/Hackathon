package tests.ui;

import ge.tbc.testautomation.hackathon.steps.LoginSteps;
import ge.tbc.testautomation.hackathon.steps.TravelModeSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TravelModeUITest extends BaseTest {

    private LoginSteps      loginSteps;
    private TravelModeSteps travelModeSteps;

    @Parameters({"browserName", "viewportWidth", "viewportHeight"})
    @BeforeMethod(dependsOnMethods = "setUp")
    public void initSteps(
            @Optional("chromium") String browserName,
            @Optional("1280")     String viewportWidth,
            @Optional("720")      String viewportHeight) {
        loginSteps      = new LoginSteps(page);
        travelModeSteps = new TravelModeSteps(page);
        loginSteps.loginAsTestUser();
        travelModeSteps.openTravelModeDashboard();
    }

    @Test(description = "Valid credentials log the user in successfully")
    public void testSuccessfulLogin() {
        Assert.assertFalse(loginSteps.isStillOnLoginPage(),
                "User should be redirected away from /login after successful login");
    }

    @Test(description = "TRAVEL MODE ACTIVE badge is visible")
    public void testTravelModeActiveBadgeVisible() {
        Assert.assertTrue(travelModeSteps.isTravelModeActive(),
                "'TRAVEL MODE ACTIVE' badge should be displayed");
    }

    @Test(description = "City name shows Berlin, Germany")
    public void testCityNameDisplayed() {
        String city = travelModeSteps.getCurrentCity();
        Assert.assertTrue(city.toLowerCase().contains("berlin") || city.toLowerCase().contains("germany"),
                "City should show Berlin, Germany. Actual: " + city);
    }

    @Test(description = "Total balance is displayed")
    public void testBalanceDisplayed() {
        String balance = travelModeSteps.getDisplayedBalance();
        Assert.assertFalse(balance.isBlank(), "Balance should not be empty");
        Assert.assertTrue(balance.contains("€") || balance.contains("1,700"),
                "Balance should contain EUR amount. Actual: " + balance);
    }

    @Test(description = "Exchange rate GEL to EUR is displayed")
    public void testExchangeRateDisplayed() {
        String rate = travelModeSteps.getDisplayedExchangeRate();
        Assert.assertTrue(rate.contains("GEL") || rate.contains("EUR"),
                "Exchange rate should show GEL/EUR. Actual: " + rate);
    }

    @Test(description = "Quick Exchange panel with Convert button is visible")
    public void testQuickExchangeVisible() {
        Assert.assertTrue(travelModeSteps.isQuickExchangeAvailable(),
                "'Convert Instantly' button should be visible");
    }


    @Test(description = "Tax-Free Returns option is visible")
    public void testTaxFreeReturnsVisible() {
        Assert.assertTrue(travelModeSteps.isTaxFreeReturnsAvailable(),
                "Tax-Free Returns should be visible in Travel Toolkit");
    }

    @Test(description = "Travel Insurance is visible")
    public void testTravelInsuranceVisible() {
        Assert.assertTrue(travelModeSteps.isTravelInsuranceAvailable(),
                "Travel Insurance should be visible in Travel Toolkit");
    }

    @Test(description = "Travel Insurance shows Policy Active")
    public void testInsurancePolicyActive() {
        Assert.assertTrue(travelModeSteps.isInsurancePolicyActive(),
                "'Policy Active' label should be shown under Travel Insurance");
    }

    @Test(description = "AI Travel Suggestions section is visible")
    public void testAISuggestionsVisible() {
        Assert.assertTrue(travelModeSteps.isAISuggestionsVisible(),
                "AI Travel Suggestions section should be visible");
    }

    @Test(description = "AI Travel Suggestions shows at least one card")
    public void testAISuggestionsHasCards() {
        Assert.assertTrue(travelModeSteps.getAISuggestionsCount() >= 1,
                "At least 1 suggestion card should be shown");
    }

    @Test(description = "Exclusive Offers section is visible")
    public void testExclusiveOffersVisible() {
        Assert.assertTrue(travelModeSteps.isExclusiveOffersVisible(),
                "Exclusive Offers section should be visible");
    }

    @Test(description = "Recent Transactions section is visible")
    public void testRecentTransactionsVisible() {
        Assert.assertTrue(travelModeSteps.isRecentTransactionsVisible(),
                "Recent Transactions section should be visible");
    }

    @Test(description = "Recent Transactions has at least one row")
    public void testRecentTransactionsHasRows() {
        Assert.assertTrue(travelModeSteps.getRecentTransactionsCount() >= 1,
                "Recent Transactions should have at least 1 row");
    }
}
