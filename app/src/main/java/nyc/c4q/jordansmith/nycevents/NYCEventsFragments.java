package nyc.c4q.jordansmith.nycevents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.EventsResponse;
import nyc.c4q.jordansmith.nycevents.models.Items;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by helenchan on 1/30/17.
 */

public class NYCEventsFragments extends Fragment {
    private String myApiKey = BuildConfig.API_KEY;
    private String myAppId = BuildConfig.APP_ID;
    private RecyclerView recyclerView;
    private EventsAdapter adapter;
    List<Items> eventsList = new ArrayList<>();
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.nyc_events_fragment_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.event_rv);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchEvents();
    }

    public void fetchEvents(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EventService service = retrofit.create(EventService.class);
        Call<EventsResponse> call = service.getEvents(myAppId, myApiKey);
        call.enqueue(new Callback<EventsResponse>() {
            @Override
            public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {
                eventsList = response.body().getItems();
                recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
                adapter = new EventsAdapter(eventsList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<EventsResponse> call, Throwable t) {
                Toast.makeText(rootView.getContext(), "Unable to Download NYC Event Data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
