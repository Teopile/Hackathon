package ge.tbc.testautomation.hackathon.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.hackathon.pages.TravelModePage;
import io.qameta.allure.Step;

public class TravelModeSteps {

    private final TravelModePage travelModePage;

    public TravelModeSteps(Page page) {
        this.travelModePage = new TravelModePage(page);
    }

    @Step("Open Travel Mode dashboard")
    public void openTravelModeDashboard() {
        travelModePage.navigate();
    }

    @Step("Open Travel Mode dashboard via navigation menu")
    public void openTravelModeDashboardViaNav() {
        travelModePage.clickTravelModeNav();
    }

    @Step("Check if Travel Mode is active")
    public boolean isTravelModeActive() {
        return travelModePage.isBadgeVisible();
    }

    @Step("Get current city displayed in Travel Mode")
    public String getCurrentCity() {
        return travelModePage.getCityText();
    }

    @Step("Get displayed account balance")
    public String getDisplayedBalance() {
        return travelModePage.getBalanceText();
    }

    @Step("Get displayed exchange rate")
    public String getDisplayedExchangeRate() {
        return travelModePage.getExchangeRateText();
    }

    @Step("Check if budget section is visible")
    public boolean isBudgetSectionVisible() {
        return travelModePage.isBudgetVisible() && travelModePage.isRemainingVisible();
    }

    @Step("Check if Quick Exchange is available")
    public boolean isQuickExchangeAvailable() {
        return travelModePage.isConvertButtonVisible();
    }

    @Step("Check if Tax Free Returns option is available")
    public boolean isTaxFreeReturnsAvailable() {
        return travelModePage.isTaxFreeVisible();
    }

    @Step("Check if Travel Insurance option is available")
    public boolean isTravelInsuranceAvailable() {
        return travelModePage.isTravelInsuranceVisible();
    }

    @Step("Check if insurance policy is active")
    public boolean isInsurancePolicyActive() {
        return travelModePage.isPolicyActiveVisible();
    }

    @Step("Check if AI suggestions section is visible")
    public boolean isAISuggestionsVisible() {
        return travelModePage.isAISuggestionsVisible();
    }

    @Step("Get number of AI suggestions")
    public int getAISuggestionsCount() {
        return travelModePage.getSuggestionsCount();
    }

    @Step("Check if exclusive offers section is visible")
    public boolean isExclusiveOffersVisible() {
        return travelModePage.isExclusiveOffersVisible();
    }

    @Step("Check if recent transactions section is visible")
    public boolean isRecentTransactionsVisible() {
        return travelModePage.isRecentTransactionsVisible();
    }

    @Step("Get number of recent transactions")
    public int getRecentTransactionsCount() {
        return travelModePage.getTransactionRowCount();
    }

    @Step("Navigate to all transactions page")
    public void goToAllTransactions() {
        travelModePage.clickViewAll();
    }
}