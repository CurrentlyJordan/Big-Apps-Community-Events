package nyc.c4q.jordansmith.nycevents.models.eateries;

/**
 * Created by helenchan on 2/3/17.
 */


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "eateries")
public class Eateries {

    @ElementList(name = "facility", inline = true, required = false)
    List<Facility> facility;



    public List<Facility> getFacility() { return this.facility; }
    public void setFacility(List<Facility> _value) { this.facility = _value; }



    public class Facility {

        @Element(name="name", required = false)
        String name;


        @Element(name="location", required = false)
        String location;


        @Element(name="park_id", required = false)
        String park_id;


        @Element(name="start_date", required = false)
        String start_date;


        @Element(name="end_date", required = false)
        String end_date;


        @Element(name="description", required = false)
        String description;


        @Element(name="permit_number", required = false)
        String permit_number;


        @Element(name="phone", required = false)
        String phone;


        @Element(name="website", required = false)
        String website;


        @Element(name="type_name", required = false)
        String type_name;



        public String getName() { return this.name; }
        public void setName(String _value) { this.name = _value; }


        public String getLocation() { return this.location; }
        public void setLocation(String _value) { this.location = _value; }


        public String getPark_id() { return this.park_id; }
        public void setPark_id(String _value) { this.park_id = _value; }


        public String getStart_date() { return this.start_date; }
        public void setStart_date(String _value) { this.start_date = _value; }


        public String getEnd_date() { return this.end_date; }
        public void setEnd_date(String _value) { this.end_date = _value; }


        public String getDescription() { return this.description; }
        public void setDescription(String _value) { this.description = _value; }


        public String getPermit_number() { return this.permit_number; }
        public void setPermit_number(String _value) { this.permit_number = _value; }


        public String getPhone() { return this.phone; }
        public void setPhone(String _value) { this.phone = _value; }


        public String getWebsite() { return this.website; }
        public void setWebsite(String _value) { this.website = _value; }


        public String getType_name() { return this.type_name; }
        public void setType_name(String _value) { this.type_name = _value; }


    }
}