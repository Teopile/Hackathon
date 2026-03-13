package ge.tbc.testautomation.hackathon.models.responses;

public class InsuranceDetails {

    private boolean isActive;
    private String  policyNumber;
    private String  validFrom;
    private String  validTo;

    public InsuranceDetails() {}

    public boolean isActive()        { return isActive;      }
    public String  getPolicyNumber() { return policyNumber;  }
    public String  getValidFrom()    { return validFrom;     }
    public String  getValidTo()      { return validTo;       }

    public void setActive(boolean active)            { this.isActive      = active;       }
    public void setPolicyNumber(String policyNumber) { this.policyNumber  = policyNumber; }
    public void setValidFrom(String validFrom)       { this.validFrom     = validFrom;    }
    public void setValidTo(String validTo)           { this.validTo       = validTo;      }
}
