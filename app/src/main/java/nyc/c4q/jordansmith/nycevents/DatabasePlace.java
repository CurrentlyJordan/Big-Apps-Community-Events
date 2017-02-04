package nyc.c4q.jordansmith.nycevents;

/**
 * Created by jordansmith on 2/3/17.
 */
public class DatabasePlace {

    String name;
    String hours;
    String rates;
    String specials;
    String phone;
    private Long _id;
    String typeOfEvent;

    public DatabasePlace(String typeOfEvent){
        this.typeOfEvent = typeOfEvent;
    }

    DatabasePlace(){
        this.name = "unknown";
    }



    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }


    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
