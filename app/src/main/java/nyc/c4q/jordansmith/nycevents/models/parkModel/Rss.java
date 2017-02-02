package nyc.c4q.jordansmith.nycevents.models.parkModel;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * Created by jordansmith on 1/27/17.
 */

public class Rss {
    @Element(name="channel", required = false)
    Channel channel;


    @Attribute(name="event", required = false)
    String event;


    @Attribute(name="version", required = false)
    String version;



    public Channel getChannel() { return this.channel; }
    public void setChannel(Channel _value) { this.channel = _value; }


    public String getEvent() { return this.event; }
    public void setEvent(String _value) { this.event = _value; }


    public String getVersion() { return this.version; }
    public void setVersion(String _value) { this.version = _value; }


}
