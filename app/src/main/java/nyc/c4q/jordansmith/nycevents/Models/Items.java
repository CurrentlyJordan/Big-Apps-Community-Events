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
<<<<<<< HEAD
    private List<String> boroughs;
=======
    private List<Geometry> geometry;


>>>>>>> ddba71577bec6fa3cfa1b87e4e188d88e400f5d8


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

<<<<<<< HEAD
    public List<String> getBoroughs() {
        return boroughs;
    }

=======
    public List<Geometry> getGeometry() {
        return geometry;
    }
>>>>>>> ddba71577bec6fa3cfa1b87e4e188d88e400f5d8
}
