package nyc.c4q.jordansmith.nycevents.models.parkModel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by jordansmith on 1/27/17.
 */

public class Channel {
    @Element(name="title", required = false)
    String title;


    @Element(name="copyright", required = false)
    String copyright;


    @Element(name="link", required = false)
    String link;


    @Element(name="description", required = false)
    String description;


    @Element(name="language", required = false)
    String language;


    @Element(name="lastBuildDate", required = false)
    String lastBuildDate;


    @ElementList(name = "item", inline = true, required = false)
    List<Item> item;



    public String getTitle() { return this.title; }
    public void setTitle(String _value) { this.title = _value; }


    public String getCopyright() { return this.copyright; }
    public void setCopyright(String _value) { this.copyright = _value; }


    public String getLink() { return this.link; }
    public void setLink(String _value) { this.link = _value; }


    public String getDescription() { return this.description; }
    public void setDescription(String _value) { this.description = _value; }


    public String getLanguage() { return this.language; }
    public void setLanguage(String _value) { this.language = _value; }


    public String getLastBuildDate() { return this.lastBuildDate; }
    public void setLastBuildDate(String _value) { this.lastBuildDate = _value; }


    public List<Item> getItem() { return this.item; }
    public void setItem(List<Item> _value) { this.item = _value; }


}
