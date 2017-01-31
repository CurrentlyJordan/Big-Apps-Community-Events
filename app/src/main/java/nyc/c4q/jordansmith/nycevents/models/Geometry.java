package nyc.c4q.jordansmith.nycevents.models;

import java.io.Serializable;

/**
 * Created by jordansmith on 1/31/17.
 */

public class Geometry implements Serializable {
    private String lat;
    private String lng;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
