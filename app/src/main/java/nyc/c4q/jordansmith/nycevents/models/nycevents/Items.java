package nyc.c4q.jordansmith.nycevents.models.nycevents;

import java.io.Serializable;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.nycevents.Geometry;

/**
 * Created by helenchan on 1/29/17.
 *
 */



public class Items implements Serializable{
    private Long _id;
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
    private List<Geometry> geometry;



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

    public List<Geometry> getGeometry() {
        return geometry;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setDatePart(String datePart) {
        this.datePart = datePart;
    }

    public void setTimePart(String timePart) {
        this.timePart = timePart;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setBoroughs(List<String> boroughs) {
        this.boroughs = boroughs;
    }

    public void setGeometry(List<Geometry> geometry) {
        this.geometry = geometry;
    }

}
