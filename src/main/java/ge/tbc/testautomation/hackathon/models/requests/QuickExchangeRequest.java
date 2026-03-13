package ge.tbc.testautomation.hackathon.models.requests;

public class QuickExchangeRequest {

    private String fromCurrency;
    private String toCurrency;
    private Number amount;

    public QuickExchangeRequest() {}

    public QuickExchangeRequest(String fromCurrency, String toCurrency, Number amount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency   = toCurrency;
        this.amount       = amount;
    }

    public String getFromCurrency() { return fromCurrency; }
    public String getToCurrency()   { return toCurrency;   }
    public Number getAmount()       { return amount;       }

    public void setFromCurrency(String fromCurrency) { this.fromCurrency = fromCurrency; }
    public void setToCurrency(String toCurrency)     { this.toCurrency   = toCurrency;   }
    public void setAmount(Number amount)             { this.amount       = amount;       }
}
