package nyc.c4q.jordansmith.nycevents.models.zoos_aquariums;

/**
 * Created by helenchan on 2/2/17.
 */


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "zoos")
public class Zoos {

    @ElementList(name = "facility", inline = true, required = false)
    List<Facility> facility;


    public List<Facility> getFacility() {
        return this.facility;
    }

    public void setFacility(List<Facility> _value) {
        this.facility = _value;
    }


}