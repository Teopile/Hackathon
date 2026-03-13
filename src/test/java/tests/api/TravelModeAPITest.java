package tests.api;

import ge.tbc.testautomation.hackathon.api.AuthHelper;
import ge.tbc.testautomation.hackathon.utils.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.BaseTest;
import java.util.HashMap;
import java.util.Map;

import static ge.tbc.testautomation.hackathon.api.AuthHelper.credentials;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TravelModeAPITest extends BaseTest {

    private String authToken;

    @BeforeClass
    public void obtainToken() {
        authToken = AuthHelper.fetchAuthToken(requestSpec);
    }

    @Test(description = "Login with valid credentials returns 200 and a JWT token")
    public void testLoginReturnsToken() {
        given()
                .spec(requestSpec)
                .body(credentials(Constants.TEST_USERNAME, Constants.TEST_PASSWORD))
                .when()
                .post(Constants.ENDPOINT_LOGIN)
                .then()
                .statusCode(200)
                .body("token",    notNullValue())
                .body("token",    not(emptyString()))
                .body("email",    equalTo(Constants.TEST_USERNAME))
                .body("fullName", notNullValue());
    }

    @Test(description = "Login with invalid credentials returns 401")
    public void testLoginInvalidCredentials() {
        given()
                .spec(requestSpec)
                .body(credentials("wrong@tbc.ge", "WrongPassword!"))
                .when()
                .post(Constants.ENDPOINT_LOGIN)
                .then()
                .statusCode(401);
    }

    @Test(description = "Dashboard endpoint returns 200")
    public void testDashboardReturns200() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200);
    }

    @Test(description = "Dashboard without auth token returns 401")
    public void testDashboardWithoutAuthReturns401() {
        given()
                .spec(requestSpec)
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(401);
    }

    @Test(description = "isTravelModeActive is true")
    public void testTravelModeIsActive() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("isTravelModeActive", equalTo(true));
    }

    @Test(description = "Location field returns Germany")
    public void testLocationField() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("location", equalTo(Constants.EXPECTED_LOCATION));
    }

    @Test(description = "Balance and currency fields are present and valid")
    public void testBalanceFields() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("totalAvailableBalanceGel",  greaterThan(0f))
                .body("estimatedEquivalentTarget", greaterThan(0f))
                .body("targetCurrencyCode",        equalTo(Constants.EXPECTED_CURRENCY));
    }

    @Test(description = "Exchange rate fields are present and valid")
    public void testExchangeRateFields() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("exchangeRateText",  notNullValue())
                .body("exchangeRateRatio", greaterThan(0f))
                .body("inverseRateRatio",  greaterThan(0f));
    }

    @Test(description = "Expense tracking fields are present and valid")
    public void testExpenseFields() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("totalSpent",      greaterThanOrEqualTo(0f))
                .body("remaining",       greaterThanOrEqualTo(0f))
                .body("spentPercentage", greaterThanOrEqualTo(0))
                .body("dailyAvg",        greaterThanOrEqualTo(0f));
    }

    @Test(description = "Tax-free fields are present")
    public void testTaxFreeFields() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("totalPotentialRefund",     greaterThanOrEqualTo(0f))
                .body("taxFreeTransactionsCount", greaterThanOrEqualTo(0));
    }

    @Test(description = "Insurance details are present and policy is active")
    public void testInsuranceDetails() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("insuranceDetails",              notNullValue())
                .body("insuranceDetails.isActive",     equalTo(true))
                .body("insuranceDetails.policyNumber", notNullValue())
                .body("insuranceDetails.validFrom",    notNullValue())
                .body("insuranceDetails.validTo",      notNullValue());
    }

    @Test(description = "Exclusive offers list is present and not empty")
    public void testExclusiveOffersNotEmpty() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("exclusiveOffers",        notNullValue())
                .body("exclusiveOffers.size()", greaterThan(0));
    }

    @Test(description = "Each offer has id, title, and description")
    public void testExclusiveOffersStructure() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("exclusiveOffers[0].id",          notNullValue())
                .body("exclusiveOffers[0].title",        notNullValue())
                .body("exclusiveOffers[0].description",  notNullValue());
    }

    @Test(description = "Recent transactions list is present and not empty")
    public void testRecentTransactionsNotEmpty() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("recentTransactions",        notNullValue())
                .body("recentTransactions.size()", greaterThan(0));
    }

    @Test(description = "Each transaction has required fields")
    public void testTransactionStructure() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TRAVEL_DASHBOARD)
                .then()
                .statusCode(200)
                .body("recentTransactions[0].id",             notNullValue())
                .body("recentTransactions[0].merchant",       notNullValue())
                .body("recentTransactions[0].category",       notNullValue())
                .body("recentTransactions[0].date",           notNullValue())
                .body("recentTransactions[0].amount",         notNullValue())
                .body("recentTransactions[0].currencySymbol", notNullValue())
                .body("recentTransactions[0].isTaxFree",      notNullValue());
    }

    @Test(description = "Transaction history returns 200 with pagination fields")
    public void testTransactionHistoryReturns200() {
        given()
                .spec(authSpec(authToken))
                .queryParam("PageNumber", 1)
                .queryParam("PageSize", 10)
                .when()
                .get(Constants.ENDPOINT_TRANSACTIONS)
                .then()
                .statusCode(200)
                .body("items",      notNullValue())
                .body("pageNumber", equalTo(1))
                .body("totalCount", greaterThanOrEqualTo(0))
                .body("totalPages", greaterThanOrEqualTo(0));
    }

    @Test(description = "Transaction history without auth returns 401")
    public void testTransactionHistoryWithoutAuthReturns401() {
        given()
                .spec(requestSpec)
                .queryParam("PageNumber", 1)
                .queryParam("PageSize", 10)
                .when()
                .get(Constants.ENDPOINT_TRANSACTIONS)
                .then()
                .statusCode(401);
    }

    @Test(description = "Transaction history can be filtered by category")
    public void testTransactionHistoryFilterByCategory() {
        given()
                .spec(authSpec(authToken))
                .queryParam("PageNumber", 1)
                .queryParam("PageSize", 10)
                .queryParam("Category", "Shopping")
                .when()
                .get(Constants.ENDPOINT_TRANSACTIONS)
                .then()
                .statusCode(200)
                .body("items", notNullValue());
    }

    @Test(description = "Tax-free summary returns totals and eligible transactions")
    public void testTaxFreeSummary() {
        given()
                .spec(authSpec(authToken))
                .when()
                .get(Constants.ENDPOINT_TAX_FREE_SUMMARY)
                .then()
                .statusCode(200)
                .body("totalExpectedRefund",  greaterThanOrEqualTo(0f))
                .body("eligibleTransactions", notNullValue());
    }

    @Test(description = "Quick Exchange with valid payload returns 200")
    public void testQuickExchange() {
        Map<String, Object> body = new HashMap<>();
        body.put("fromCurrency", "GEL");
        body.put("toCurrency",   "EUR");
        body.put("amount",       100);

        given()
                .spec(authSpec(authToken))
                .body(body)
                .when()
                .post(Constants.ENDPOINT_QUICK_EXCHANGE)
                .then()
                .statusCode(200);
    }

    @Test(description = "Delete an AI suggestion returns 204")
    public void testDeleteAISuggestion() {
        given()
                .spec(authSpec(authToken))
                .pathParam("tripId", 1)
                .queryParam("title", "Berlin TV Tower")
                .when()
                .delete(Constants.ENDPOINT_AI_SUGGESTIONS)
                .then()
                .statusCode(204);
    }
}