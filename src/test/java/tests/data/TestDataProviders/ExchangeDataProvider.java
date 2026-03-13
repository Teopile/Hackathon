package tests.data.TestDataProviders;

import org.testng.annotations.DataProvider;

public class ExchangeDataProvider {

    @DataProvider(name = "validExchangeRequests")
    public static Object[][] validExchangeRequests() {
        return new Object[][] {
            { "GEL", "EUR", 100   },
            { "GEL", "EUR", 1     },
            { "GEL", "EUR", 10000 }
        };
    }

    @DataProvider(name = "invalidExchangeRequests")
    public static Object[][] invalidExchangeRequests() {
        return new Object[][] {
            { "GEL", "EUR",  0,    400 },  // zero amount
            { "GEL", "EUR",  -50,  400 },  // negative amount
            { "XYZ", "EUR",  100,  400 },  // unknown from-currency
            { "GEL", "XYZ",  100,  400 },  // unknown to-currency
            { "",    "EUR",  100,  400 },  // empty from-currency
        };
    }

    @DataProvider(name = "transactionCategories")
    public static Object[][] transactionCategories() {
        return new Object[][] {
            { "Shopping"    },
            { "Food"        },
            { "Transport"   },
            { "Health"      },
            { "Entertainment" }
        };
    }
}
