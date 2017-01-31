package nyc.c4q.jordansmith.nycevents.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by helenchan on 1/29/17.
 *
 */

public class Items implements Serializable{
    private String startDate;
    private String datePart;
    private String timePart;
    private boolean canceled;
    private String permalink;
    private String name;
    private String desc;
    private String shortDesc;
    private String website;
    private String imageUrl;
    private List<String> boroughs;


    public String getStartDate() {
        return startDate;
    }

    public String getDatePart() {
        return datePart;
    }

    public String getTimePart() {
        return timePart;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getWebsite() {
        return website;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getBoroughs() {
        return boroughs;
    }

}
