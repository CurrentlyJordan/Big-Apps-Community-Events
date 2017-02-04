package nyc.c4q.jordansmith.nycevents;

import nyc.c4q.jordansmith.nycevents.models.eateries.Eateries;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 2/3/17.
 * http://nycgovparks.org/bigapps/DPR_Eateries_001.xml
 */

public interface EateryService {

    @GET("bigapps/DPR_Eateries_001.xml")
    Call<Eateries> getEateries();
}
