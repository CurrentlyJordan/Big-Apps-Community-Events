package nyc.c4q.jordansmith.nycevents.models.parkModel;

import org.simpleframework.xml.Element;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.EventInterface;
import nyc.c4q.jordansmith.nycevents.models.nycevents.Geometry;
import nyc.c4q.jordansmith.nycevents.models.nycevents.Items;

/**
 * Created by jordansmith on 1/27/17.
 */

public class Item implements EventInterface {
    @Element(name="title", required = false)
    String title;


    @Element(name="guid", required = false)
    String guid;


    @Element(name="link", required = false)
    String link;


    @Element(name="description", required = false)
    String description;


    @Element(name="parkids", required = false)
    String parkids;


    @Element(name="parknames", required = false)
    String parknames;


    @Element(name="startdate", required = false)
    String startdate;


    @Element(name="enddate", required = false)
    String enddate;


    @Element(name="starttime", required = false)
    String starttime;


    @Element(name="endtime", required = false)
    String endtime;


    @Element(name="contact_phone", required = false)
    String contact_phone;


    @Element(name="location", required = false)
    String location;


    @Element(name="categories", required = false)
    String categories;


    @Element(name="coordinates", required = false)
    String coordinates;


    @Element(name="image", required = false)
    String image;


    @Element(name="pubDate", required = false)
    String pubDate;



    public String getTitle() { return this.title; }
    public void setTitle(String _value) { this.title = _value; }


    public String getGuid() { return this.guid; }
    public void setGuid(String _value) { this.guid = _value; }


    public String getLink() { return this.link; }
    public void setLink(String _value) { this.link = _value; }


    public String getDescription() { return this.description; }
    public void setDescription(String _value) { this.description = _value; }


    public String getParkids() { return this.parkids; }
    public void setParkids(String _value) { this.parkids = _value; }


    public String getParknames() { return this.parknames; }
    public void setParknames(String _value) { this.parknames = _value; }


    public String getStartdate() { return this.startdate; }
    public void setStartdate(String _value) { this.startdate = _value; }


    public String getEnddate() { return this.enddate; }
    public void setEnddate(String _value) { this.enddate = _value; }


    public String getStarttime() { return this.starttime; }
    public void setStarttime(String _value) { this.starttime = _value; }


    public String getEndtime() { return this.endtime; }
    public void setEndtime(String _value) { this.endtime = _value; }


    public String getContact_phone() { return this.contact_phone; }
    public void setContact_phone(String _value) { this.contact_phone = _value; }


    public String getLocation() { return this.location; }
    public void setLocation(String _value) { this.location = _value; }


    public String getCategories() { return this.categories; }
    public void setCategories(String _value) { this.categories = _value; }


    public String getCoordinates() { return this.coordinates; }
    public void setCoordinates(String _value) { this.coordinates = _value; }


    public String getImage() { return this.image; }
    public void setImage(String _value) { this.image = _value; }


    public String getPubDate() { return this.pubDate; }
    public void setPubDate(String _value) { this.pubDate = _value; }


    @Override
    public Items transform() {
        Items transformedItem = new Items();
        transformedItem.setName(getTitle());
        transformedItem.setDesc(getDescription());
        transformedItem.setImageUrl(getImage());
        transformedItem.setWebsite(getLink());
        transformedItem.setTimePart(getStarttime());
        transformedItem.setDatePart(getStartdate());
        transformedItem.setShortDesc(getDescription().substring(0,150) + "...");
        List<Geometry> geometryList = new ArrayList<>();
        Geometry geometry = new Geometry();
        String lat,lon;
        String fullCoordinates = getCoordinates();
        String [] array = fullCoordinates.split(", ");
        lat = array[0];
        lon = array[1];
        geometry.setLat(lat);
        geometry.setLng(lon);
        geometryList.add(geometry);
        transformedItem.setGeometry(geometryList);
        return transformedItem;
    }
}
