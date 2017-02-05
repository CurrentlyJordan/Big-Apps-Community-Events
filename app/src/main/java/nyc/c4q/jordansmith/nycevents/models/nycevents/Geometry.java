package nyc.c4q.jordansmith.nycevents.models.nycevents;

import java.io.Serializable;

/**
 * Created by jordansmith on 1/31/17.
 */

public class Geometry implements Serializable {
    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    private String lat;
    private String lng;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
