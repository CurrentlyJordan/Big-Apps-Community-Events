package nyc.c4q.jordansmith.nycevents.models.zoos_aquariums;

import org.simpleframework.xml.Element;

import java.io.Serializable;

import nyc.c4q.jordansmith.nycevents.database.DatabasePlace;
import nyc.c4q.jordansmith.nycevents.database.PlaceInterface;

/**
 * Created by helenchan on 2/2/17.
 */

public class Facility implements PlaceInterface, Serializable{

    @Element(name = "Prop_ID", required = false)
    String prop_ID;


    @Element(name = "Name", required = false)
    String name;


    @Element(name = "Location", required = false)
    String location;


    @Element(name = "Phone_Num", required = false)
    String phone_Num;


    public String getProp_ID() {
        return this.prop_ID;
    }

    public void setProp_ID(String _value) {
        this.prop_ID = _value;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String _value) {
        this.name = _value;
    }


    public String getLocation() {
        return this.location;
    }

    public void setLocation(String _value) {
        this.location = _value;
    }


    public String getPhone_Num() {
        return this.phone_Num;
    }

    public void setPhone_Num(String _value) {
        this.phone_Num = _value;
    }

    @Override
    public DatabasePlace transform() {
        DatabasePlace databasePlace = new DatabasePlace("Zoo");
        databasePlace.setAddress(getLocation());
        databasePlace.setName(getName());
        databasePlace.setPhone(getPhone_Num());
        return databasePlace;
    }
}
