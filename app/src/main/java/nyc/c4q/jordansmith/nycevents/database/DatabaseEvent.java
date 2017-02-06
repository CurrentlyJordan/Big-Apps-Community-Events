package nyc.c4q.jordansmith.nycevents.database;

import java.io.Serializable;

import nyc.c4q.jordansmith.nycevents.models.nycevents.Items;

/**
 * Created by jordansmith on 2/3/17.
 */

public class DatabaseEvent implements Serializable {

    String name;
    String description;
    String startTime;
    String startDate;
    String latitude;
    String longitude;
    String shortDesc;
    String imageUrl;
    String webUrl;
    private Long _id;


    public DatabaseEvent(Items event){
        this.name = event.getName();
        this.description = event.getDesc();
        this.imageUrl = event.getImageUrl();
        this.webUrl = event.getImageUrl();
        this.shortDesc = event.getShortDesc();
        this.startTime = event.getTimePart();
        this.startDate = event.getDatePart();
        if(event.getGeometry() != null) {
            this.latitude = event.getGeometry().get(0).getLat();
            this.longitude = event.getGeometry().get(0).getLng();
        }

    }

    DatabaseEvent() {
        this.name = "unknown";
        this.description = "unknown";
        this.imageUrl = "unknown";
        this.webUrl = "unknown";
    }

    public String getName() {
        return name;
    }

    public Long get_id() {
        return _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
