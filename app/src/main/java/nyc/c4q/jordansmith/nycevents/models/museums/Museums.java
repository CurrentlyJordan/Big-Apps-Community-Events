package nyc.c4q.jordansmith.nycevents.models.museums;

/**
 * Created by helenchan on 2/1/17.
 */


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "museums")
public class Museums {

    @ElementList(name = "museum", inline = true, required = false)
    List<Museum> museum;


    public List<Museum> getMuseum() {
        return this.museum;
    }

    public void setMuseum(List<Museum> _value) {
        this.museum = _value;
    }

}