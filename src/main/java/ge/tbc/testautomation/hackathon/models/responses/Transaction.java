package ge.tbc.testautomation.hackathon.models.responses;

public class Transaction {

    private Object  id;
    private String  merchant;
    private String  category;
    private String  date;
    private Object  amount;
    private String  currencySymbol;
    private Boolean isTaxFree;

    public Transaction() {}

    public Object  getId()             { return id;             }
    public String  getMerchant()       { return merchant;       }
    public String  getCategory()       { return category;       }
    public String  getDate()           { return date;           }
    public Object  getAmount()         { return amount;         }
    public String  getCurrencySymbol() { return currencySymbol; }
    public Boolean getIsTaxFree()      { return isTaxFree;      }

    public void setId(Object id)                         { this.id             = id;             }
    public void setMerchant(String merchant)             { this.merchant       = merchant;       }
    public void setCategory(String category)             { this.category       = category;       }
    public void setDate(String date)                     { this.date           = date;           }
    public void setAmount(Object amount)                 { this.amount         = amount;         }
    public void setCurrencySymbol(String currencySymbol) { this.currencySymbol = currencySymbol; }
    public void setIsTaxFree(Boolean isTaxFree)          { this.isTaxFree      = isTaxFree;      }
}
