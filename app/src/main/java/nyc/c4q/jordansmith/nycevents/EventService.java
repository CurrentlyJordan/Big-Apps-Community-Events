package nyc.c4q.jordansmith.nycevents;

import nyc.c4q.jordansmith.nycevents.Models.EventsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by helenchan on 1/29/17.
 */

public interface EventService {
    @GET("calendar/v1/search.htm")
    Call<EventsResponse> getEvents(@Query("app_id") String app_id,
                                   @Query("app_key") String app_key);
}