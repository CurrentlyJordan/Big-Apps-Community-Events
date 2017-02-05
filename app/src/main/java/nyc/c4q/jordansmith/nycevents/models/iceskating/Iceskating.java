package nyc.c4q.jordansmith.nycevents.models.iceskating;

/**
 * Created by helenchan on 2/5/17.
 */


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import nyc.c4q.jordansmith.nycevents.DatabasePlace;
import nyc.c4q.jordansmith.nycevents.PlaceInterface;

@Root(name = "iceskating")
public class Iceskating {

    @ElementList(name = "facility", inline = true, required = false)
    List<Facility> facility;



    public List<Facility> getFacility() { return this.facility; }
    public void setFacility(List<Facility> _value) { this.facility = _value; }



    public static class Facility implements PlaceInterface{

        @Element(name="Prop_ID", required = false)
        String prop_ID;


        @Element(name="Name", required = false)
        String name;


        @Element(name="Location", required = false)
        String location;


        @Element(name="Phone", required = false)
        String phone;


        @Element(name="Accessible", required = false)
        String accessible;


        @Element(name="lat", required = false)
        String lat;


        @Element(name="lon", required = false)
        String lon;


        @Element(name="IceSkating_Type", required = false)
        String iceSkating_Type;


        @Element(name="Public_Skate_Admission_Price_Adult", required = false)
        String public_Skate_Admission_Price_Adult;


        @Element(name="Public_Skate_Admission_Price_Child", required = false)
        String public_Skate_Admission_Price_Child;


        @Element(name="Public_Skate_Admission_Price_Senior", required = false)
        String public_Skate_Admission_Price_Senior;


        @Element(name="Skate_Rental_Cost", required = false)
        String skate_Rental_Cost;


        @Element(name="Locker_Information", required = false)
        String locker_Information;


        @Element(name="Opening_Date", required = false)
        String opening_Date;


        @Element(name="Closing_Date", required = false)
        String closing_Date;


        @Element(name="Sunday_Public_Skating_Hours", required = false)
        String sunday_Public_Skating_Hours;


        @Element(name="Monday_Public_Skating_Hours", required = false)
        String monday_Public_Skating_Hours;


        @Element(name="Tuesday_Public_Skating_Hours", required = false)
        String tuesday_Public_Skating_Hours;


        @Element(name="Wednesday_Public_Skating_Hours", required = false)
        String wednesday_Public_Skating_Hours;


        @Element(name="Thursday_Public_Skating_Hours", required = false)
        String thursday_Public_Skating_Hours;


        @Element(name="Friday_Public_Skating_Hours", required = false)
        String friday_Public_Skating_Hours;


        @Element(name="Saturday_Public_Skating_Hours", required = false)
        String saturday_Public_Skating_Hours;


        @Element(name="Holiday_Public_Skating_Hours", required = false)
        String holiday_Public_Skating_Hours;


        @Element(name="Programming", required = false)
        String programming;


        @Element(name="Notes", required = false)
        String notes;



        public String getProp_ID() { return this.prop_ID; }
        public void setProp_ID(String _value) { this.prop_ID = _value; }


        public String getName() { return this.name; }
        public void setName(String _value) { this.name = _value; }


        public String getLocation() { return this.location; }
        public void setLocation(String _value) { this.location = _value; }


        public String getPhone() { return this.phone; }
        public void setPhone(String _value) { this.phone = _value; }


        public String getAccessible() { return this.accessible; }
        public void setAccessible(String _value) { this.accessible = _value; }


        public String getLat() { return this.lat; }
        public void setLat(String _value) { this.lat = _value; }


        public String getLon() { return this.lon; }
        public void setLon(String _value) { this.lon = _value; }


        public String getIceSkating_Type() { return this.iceSkating_Type; }
        public void setIceSkating_Type(String _value) { this.iceSkating_Type = _value; }


        public String getPublic_Skate_Admission_Price_Adult() { return this.public_Skate_Admission_Price_Adult; }
        public void setPublic_Skate_Admission_Price_Adult(String _value) { this.public_Skate_Admission_Price_Adult = _value; }


        public String getPublic_Skate_Admission_Price_Child() { return this.public_Skate_Admission_Price_Child; }
        public void setPublic_Skate_Admission_Price_Child(String _value) { this.public_Skate_Admission_Price_Child = _value; }


        public String getPublic_Skate_Admission_Price_Senior() { return this.public_Skate_Admission_Price_Senior; }
        public void setPublic_Skate_Admission_Price_Senior(String _value) { this.public_Skate_Admission_Price_Senior = _value; }


        public String getSkate_Rental_Cost() { return this.skate_Rental_Cost; }
        public void setSkate_Rental_Cost(String _value) { this.skate_Rental_Cost = _value; }


        public String getLocker_Information() { return this.locker_Information; }
        public void setLocker_Information(String _value) { this.locker_Information = _value; }


        public String getOpening_Date() { return this.opening_Date; }
        public void setOpening_Date(String _value) { this.opening_Date = _value; }


        public String getClosing_Date() { return this.closing_Date; }
        public void setClosing_Date(String _value) { this.closing_Date = _value; }


        public String getSunday_Public_Skating_Hours() { return this.sunday_Public_Skating_Hours; }
        public void setSunday_Public_Skating_Hours(String _value) { this.sunday_Public_Skating_Hours = _value; }


        public String getMonday_Public_Skating_Hours() { return this.monday_Public_Skating_Hours; }
        public void setMonday_Public_Skating_Hours(String _value) { this.monday_Public_Skating_Hours = _value; }


        public String getTuesday_Public_Skating_Hours() { return this.tuesday_Public_Skating_Hours; }
        public void setTuesday_Public_Skating_Hours(String _value) { this.tuesday_Public_Skating_Hours = _value; }


        public String getWednesday_Public_Skating_Hours() { return this.wednesday_Public_Skating_Hours; }
        public void setWednesday_Public_Skating_Hours(String _value) { this.wednesday_Public_Skating_Hours = _value; }


        public String getThursday_Public_Skating_Hours() { return this.thursday_Public_Skating_Hours; }
        public void setThursday_Public_Skating_Hours(String _value) { this.thursday_Public_Skating_Hours = _value; }


        public String getFriday_Public_Skating_Hours() { return this.friday_Public_Skating_Hours; }
        public void setFriday_Public_Skating_Hours(String _value) { this.friday_Public_Skating_Hours = _value; }


        public String getSaturday_Public_Skating_Hours() { return this.saturday_Public_Skating_Hours; }
        public void setSaturday_Public_Skating_Hours(String _value) { this.saturday_Public_Skating_Hours = _value; }


        public String getHoliday_Public_Skating_Hours() { return this.holiday_Public_Skating_Hours; }
        public void setHoliday_Public_Skating_Hours(String _value) { this.holiday_Public_Skating_Hours = _value; }


        public String getProgramming() { return this.programming; }
        public void setProgramming(String _value) { this.programming = _value; }


        public String getNotes() { return this.notes; }
        public void setNotes(String _value) { this.notes = _value; }


        @Override
        public DatabasePlace transform() {
            DatabasePlace databasePlace = new DatabasePlace("iceskating");
            databasePlace.setName(this.getName());
            databasePlace.setPhone(this.getPhone());
            databasePlace.setRates(this.getPublic_Skate_Admission_Price_Adult());
            databasePlace.setDescription(this.getNotes());
            databasePlace.setAddress(this.getLocation());
            return databasePlace;

        }
    }

}
