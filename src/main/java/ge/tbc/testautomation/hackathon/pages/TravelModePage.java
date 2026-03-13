package ge.tbc.testautomation.hackathon.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import ge.tbc.testautomation.hackathon.utils.Constants;

public class TravelModePage {

    private final Page page;

    public TravelModePage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate(Constants.LOCAL_UI_URL + Constants.ROUTE_TRAVEL_MODE);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void clickTravelModeNav() {
        page.locator(Constants.NAV_TRAVEL_MODE).first().click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public boolean isBadgeVisible() {
        return page.locator(Constants.BADGE_ACTIVE).first().isVisible();
    }

    public String getCityText() {
        return page.locator(Constants.LBL_CITY).first().textContent().trim();
    }

    public String getBalanceText() {
        return page.locator(Constants.LBL_BALANCE).first().textContent().trim();
    }

    public String getExchangeRateText() {
        return page.locator(Constants.LBL_EXCHANGE_RATE).first().textContent().trim();
    }

    public boolean isBudgetVisible() {
        return page.locator(Constants.LBL_BUDGET).first().isVisible();
    }

    public boolean isRemainingVisible() {
        return page.locator(Constants.LBL_REMAINING).first().isVisible();
    }

    public boolean isConvertButtonVisible() {
        return page.locator(Constants.BTN_CONVERT).isVisible();
    }

    public void fillExchangeAmount(String amount) {
        page.locator(Constants.INPUT_EXCHANGE_AMOUNT).first().fill(amount);
    }

    public void clickConvert() {
        page.locator(Constants.BTN_CONVERT).click();
    }

    public boolean isTaxFreeVisible() {
        return page.locator(Constants.LBL_TAX_FREE).first().isVisible();
    }

    public boolean isTravelInsuranceVisible() {
        return page.locator(Constants.LBL_TRAVEL_INSURANCE).first().isVisible();
    }

    public boolean isPolicyActiveVisible() {
        return page.locator(Constants.LBL_POLICY_ACTIVE).first().isVisible();
    }

    public boolean isAISuggestionsVisible() {
        return page.locator(Constants.SECTION_AI_SUGGESTIONS).first().isVisible();
    }

    public int getSuggestionsCount() {
        return page.locator(Constants.CARDS_SUGGESTIONS).count();
    }

    public boolean isExclusiveOffersVisible() {
        return page.locator(Constants.SECTION_OFFERS).first().isVisible();
    }

    public boolean isRecentTransactionsVisible() {
        return page.locator(Constants.SECTION_TRANSACTIONS).first().isVisible();
    }

    public int getTransactionRowCount() {
        return page.locator(Constants.TABLE_ROWS).count();
    }

    public void clickViewAll() {
        page.locator(Constants.LINK_VIEW_ALL).click();
    }
}