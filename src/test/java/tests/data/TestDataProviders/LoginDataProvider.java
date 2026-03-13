package tests.data.TestDataProviders;

import framework.utils.Constants;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][] {
            { Constants.TEST_USERNAME, Constants.TEST_PASSWORD }
        };
    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][] {
            { "wrong@tbc.ge",          "WrongPassword!",     "wrong email and password"    },
            { Constants.TEST_USERNAME, "BadPassword!",       "correct email, wrong password" },
            { "notanemail",            Constants.TEST_PASSWORD, "malformed email"           },
            { "",                      "",                   "empty credentials"            }
        };
    }

    @DataProvider(name = "edgeCasePasswords")
    public static Object[][] edgeCasePasswords() {
        return new Object[][] {
            { Constants.TEST_USERNAME, " "                              }, // whitespace only
            { Constants.TEST_USERNAME, "a".repeat(256)                 }, // very long password
            { Constants.TEST_USERNAME, "<script>alert(1)</script>"     }, // XSS payload
            { Constants.TEST_USERNAME, "' OR '1'='1"                   }  // SQL injection
        };
    }
}
