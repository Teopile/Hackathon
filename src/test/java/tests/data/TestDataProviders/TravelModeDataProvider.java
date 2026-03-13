package tests.data.TestDataProviders;

import ge.tbc.testautomation.hackathon.utils.Constants;
import org.testng.annotations.DataProvider;

public class TravelModeDataProvider {

    private TravelModeDataProvider() {}

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][] {
                { Constants.TEST_USERNAME, Constants.TEST_PASSWORD }
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][] {
                { "wrong@tbc.ge",              "WrongPassword!",    "invalid" },
                { "",                           Constants.TEST_PASSWORD, "required" },
                { Constants.TEST_USERNAME,      "",                  "required" },
                { "notanemail",                 "SomePass1!",        "invalid"  },
                { "sql'--@tbc.ge",             "pass",              "invalid"  },
        };
    }

    @DataProvider(name = "quickExchangePayloads")
    public static Object[][] quickExchangePayloads() {
        return new Object[][] {
                { "GEL", "EUR", 100  },
                { "GEL", "EUR", 1    },
                { "GEL", "EUR", 9999 },
        };
    }

    @DataProvider(name = "transactionPagination")
    public static Object[][] transactionPagination() {
        return new Object[][] {
                { 1, 5  },
                { 1, 10 },
                { 1, 20 },
                { 2, 10 },
        };
    }

    @DataProvider(name = "transactionCategories")
    public static Object[][] transactionCategories() {
        return new Object[][] {
                { "Shopping"    },
                { "Dining"      },
                { "Transport"   },
                { "Accommodation" },
        };
    }
}
