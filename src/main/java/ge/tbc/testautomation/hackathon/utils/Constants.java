package ge.tbc.testautomation.hackathon.utils;

public class Constants {

    private Constants() {}

    public static final String LOCAL_UI_URL    = "https://travelmode.duckdns.org/login";
//    public static final String STAGING_UI_URL  = "https://travelmode.duckdns.org/login";
    public static final String LOCAL_API_URL   = "http://13.49.137.218:5000/api";
//    public static final String STAGING_API_URL = "http://13.49.137.218:5000/api";

    public static final String ROUTE_LOGIN       = "/login";
    public static final String ROUTE_TRAVEL_MODE = "/travel-mode";

    public static final String TEST_USERNAME = "tbc.student@tbcacademy.ge";
    public static final String TEST_PASSWORD = "TBC.Pass123!";

    public static final int DEFAULT_TIMEOUT_MS = 30_000;
    public static final int SHORT_TIMEOUT_MS   = 10_000;

    public static final String ENDPOINT_LOGIN            = "/Auth/login";
    public static final String ENDPOINT_TRAVEL_DASHBOARD = "/TravelDashboard";
    public static final String ENDPOINT_QUICK_EXCHANGE   = "/TravelDashboard/quick-exchange";
    public static final String ENDPOINT_TRANSACTIONS     = "/Transactions/history";
    public static final String ENDPOINT_TAX_FREE_SUMMARY = "/Transactions/tax-free-summary";
    public static final String ENDPOINT_AI_SUGGESTIONS   = "/Trips/ai-suggestions/{tripId}";

    public static final String EXPECTED_LOCATION = "Germany";
    public static final String EXPECTED_CURRENCY = "EUR";

    public static final String INPUT_USERNAME = "input[type='email'], input[formcontrolname='email'], input[formcontrolname='username']";
    public static final String INPUT_PASSWORD = "input[type='password']";
    public static final String BTN_LOGIN      = "button[type='submit'], button:has-text('Login'), button:has-text('Sign in')";
    public static final String LBL_ERROR      = "#login-error-message";

    public static final String NAV_TRAVEL_MODE       = "a:has-text('Travel Mode'), nav a[href*='travel-mode']";
    public static final String BADGE_ACTIVE          = "#travel-mode-active-badge";
    public static final String LBL_CITY              = "#city-name-display";
    public static final String LBL_BALANCE           = "#total-balance-display";
    public static final String LBL_EXCHANGE_RATE     = "#exchange-rate-display";
    public static final String LBL_BUDGET            = "#budget-section";
    public static final String LBL_REMAINING         = "#budget-section";
    public static final String BTN_CONVERT           = "#quick-exchange-section";
    public static final String INPUT_EXCHANGE_AMOUNT = "#quick-exchange-section input";
    public static final String LBL_TAX_FREE          = "#btn-tax-free-returns";
    public static final String LBL_TRAVEL_INSURANCE  = "#btn-travel-insurance";
    public static final String LBL_POLICY_ACTIVE     = "#insurance-policy-status";
    public static final String SECTION_AI_SUGGESTIONS = "#ai-suggestions-section";
    public static final String CARDS_SUGGESTIONS     = "#ai-suggestions-container";
    public static final String SECTION_OFFERS        = "#exclusive-offers-section";
    public static final String SECTION_TRANSACTIONS  = "#recent-transactions-section";
    public static final String LINK_VIEW_ALL         = "a:has-text('View All')";
    public static final String TABLE_ROWS            = "#recent-transactions-tbody";
}