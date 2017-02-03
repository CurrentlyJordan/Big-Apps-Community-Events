package nyc.c4q.jordansmith.nycevents;

import nyc.c4q.jordansmith.nycevents.models.museums.Museums;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 2/1/17.
 * https://data.cityofnewyork.us/download/kcrm-j9hh/application%2Fxml
 */

public interface MuseumsService {

    @GET("download/kcrm-j9hh/application%2Fxml")
    Call<Museums> getMuseums();
}
