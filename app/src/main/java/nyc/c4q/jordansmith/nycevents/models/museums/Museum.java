package nyc.c4q.jordansmith.nycevents.models.museums;

import org.simpleframework.xml.Element;

import java.io.Serializable;

import nyc.c4q.jordansmith.nycevents.DatabasePlace;
import nyc.c4q.jordansmith.nycevents.PlaceInterface;

/**
 * Created by helenchan on 2/1/17.
 */

public class Museum implements Serializable, PlaceInterface {

    @Element(name = "name", required = false)
    String name;


    @Element(name = "phone", required = false)
    String phone;


    @Element(name = "address", required = false)
    String address;


    @Element(name = "closing", required = false)
    String closing;


    @Element(name = "rates", required = false)
    String rates;


    @Element(name = "specials", required = false)
    String specials;


    public String getName() {
        return this.name;
    }

    public void setName(String _value) {
        this.name = _value;
    }


    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String _value) {
        this.phone = _value;
    }


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String _value) {
        this.address = _value;
    }


    public String getClosing() {
        return this.closing;
    }

    public void setClosing(String _value) {
        this.closing = _value;
    }


    public String getRates() {
        return this.rates;
    }

    public void setRates(String _value) {
        this.rates = _value;
    }


    public String getSpecials() {
        return this.specials;
    }

    public void setSpecials(String _value) {
        this.specials = _value;
    }


    @Override
    public DatabasePlace transform() {
        DatabasePlace databasePlace = new DatabasePlace();
        databasePlace.setName(this.getName());
        databasePlace.setHours(this.getClosing());
        databasePlace.setPhone(this.getPhone());
        databasePlace.setRates(this.getRates());
        databasePlace.setSpecials(this.getSpecials());
        databasePlace.setAddress(this.getAddress());
        return databasePlace;

    }
}
