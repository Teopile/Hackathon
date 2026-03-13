package ge.tbc.testautomation.hackathon.models.responses;


import java.util.List;

public class TravelDashboard {

    private boolean isTravelModeActive;
    private String  location;

    private float  totalAvailableBalanceGel;
    private float  estimatedEquivalentTarget;
    private String targetCurrencyCode;
    private String exchangeRateText;
    private float  exchangeRateRatio;
    private float  inverseRateRatio;

    private float totalSpent;
    private float remaining;
    private int   spentPercentage;
    private float dailyAvg;

    private float totalPotentialRefund;
    private int   taxFreeTransactionsCount;

    private InsuranceDetails insuranceDetails;

    private List<ExclusiveOffer> exclusiveOffers;
    private List<Transaction>    recentTransactions;

    public TravelDashboard() {}

    public boolean isTravelModeActive()           { return isTravelModeActive;           }
    public String  getLocation()                  { return location;                     }
    public float   getTotalAvailableBalanceGel()  { return totalAvailableBalanceGel;     }
    public float   getEstimatedEquivalentTarget() { return estimatedEquivalentTarget;    }
    public String  getTargetCurrencyCode()        { return targetCurrencyCode;           }
    public String  getExchangeRateText()          { return exchangeRateText;             }
    public float   getExchangeRateRatio()         { return exchangeRateRatio;            }
    public float   getInverseRateRatio()          { return inverseRateRatio;             }
    public float   getTotalSpent()                { return totalSpent;                   }
    public float   getRemaining()                 { return remaining;                    }
    public int     getSpentPercentage()           { return spentPercentage;              }
    public float   getDailyAvg()                  { return dailyAvg;                     }
    public float   getTotalPotentialRefund()      { return totalPotentialRefund;         }
    public int     getTaxFreeTransactionsCount()  { return taxFreeTransactionsCount;     }
    public InsuranceDetails     getInsuranceDetails()   { return insuranceDetails;       }
    public List<ExclusiveOffer> getExclusiveOffers()    { return exclusiveOffers;        }
    public List<Transaction>    getRecentTransactions() { return recentTransactions;     }

    public void setTravelModeActive(boolean v)                   { this.isTravelModeActive        = v; }
    public void setLocation(String v)                            { this.location                  = v; }
    public void setTotalAvailableBalanceGel(float v)             { this.totalAvailableBalanceGel  = v; }
    public void setEstimatedEquivalentTarget(float v)            { this.estimatedEquivalentTarget = v; }
    public void setTargetCurrencyCode(String v)                  { this.targetCurrencyCode        = v; }
    public void setExchangeRateText(String v)                    { this.exchangeRateText          = v; }
    public void setExchangeRateRatio(float v)                    { this.exchangeRateRatio         = v; }
    public void setInverseRateRatio(float v)                     { this.inverseRateRatio          = v; }
    public void setTotalSpent(float v)                           { this.totalSpent                = v; }
    public void setRemaining(float v)                            { this.remaining                 = v; }
    public void setSpentPercentage(int v)                        { this.spentPercentage           = v; }
    public void setDailyAvg(float v)                             { this.dailyAvg                  = v; }
    public void setTotalPotentialRefund(float v)                 { this.totalPotentialRefund      = v; }
    public void setTaxFreeTransactionsCount(int v)               { this.taxFreeTransactionsCount  = v; }
    public void setInsuranceDetails(InsuranceDetails v)          { this.insuranceDetails          = v; }
    public void setExclusiveOffers(List<ExclusiveOffer> v)       { this.exclusiveOffers           = v; }
    public void setRecentTransactions(List<Transaction> v)       { this.recentTransactions        = v; }
}
