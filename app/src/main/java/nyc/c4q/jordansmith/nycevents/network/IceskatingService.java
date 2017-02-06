package nyc.c4q.jordansmith.nycevents.network;

import nyc.c4q.jordansmith.nycevents.models.iceskating.Iceskating;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 2/5/17.
 * http://nycgovparks.org/bigapps/DPR_IceSkating_001.xml
 */

public interface IceskatingService {

    @GET("bigapps/DPR_IceSkating_001.xml")
    Call<Iceskating> getSkatingDeets();
}
