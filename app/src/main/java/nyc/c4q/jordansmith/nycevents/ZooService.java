package nyc.c4q.jordansmith.nycevents;

import nyc.c4q.jordansmith.nycevents.models.zoos_aquariums.Zoos;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 2/3/17.
 */

public interface ZooService {
    @GET("bigapps/DPR_Zoos_001.xml")
    Call<Zoos> getZooAndAq();
}
