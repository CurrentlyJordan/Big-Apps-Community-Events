package nyc.c4q.jordansmith.nycevents;

import nyc.c4q.jordansmith.nycevents.Models.EventsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by helenchan on 1/29/17.
 * https://api.cityofnewyork.us/calendar/v1/search.htm?app_id=4ab80f31&app_key=070272f54de4cefedd0559455024680e&endDate=02%2F20%2F2017+01%3A00+am
 */

public interface EventService {
    @GET("calendar/v1/search.htm")
    Call<EventsResponse> getEvents(@Query("app_id") String app_id,
                                   @Query("app_key") String app_key);
}