package ge.tbc.testautomation.hackathon.models.responses;

public class ExclusiveOffer {

    private Object id;
    private String title;
    private String description;

    public ExclusiveOffer() {}

    public Object getId()          { return id;          }
    public String getTitle()       { return title;       }
    public String getDescription() { return description; }

    public void setId(Object id)            { this.id          = id;   }
    public void setTitle(String title)      { this.title       = title; }
    public void setDescription(String desc) { this.description = desc;  }
}
