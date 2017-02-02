package nyc.c4q.jordansmith.nycevents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.Items;
import nyc.c4q.jordansmith.nycevents.models.parkModel.Item;
import nyc.c4q.jordansmith.nycevents.models.parkModel.Rss;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by jordansmith on 2/1/17.
 */

public class ParksEventsFragments extends Fragment {
    View rootView;
    RecyclerView recyclerView;
    List<Items> eventItems = new ArrayList<>();
    ParkEventsAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.parks_events_fragment, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.park_event_rv);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchEvents();
    }

    private void fetchEvents() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.nycgovparks.org/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        ParksService parkService = retrofit.create(ParksService.class);
        Call<Rss> httpRequest = parkService.getParkEvents();
        httpRequest.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                Log.d(TAG, "success " + response.body().toString());
                try {
                    if (response.isSuccessful()) {
                        Rss parkApiResponse = response.body();
                        for (Item item : parkApiResponse.getChannel().getItem()) {
                            Items transformedItem = item.transform();
                            eventItems.add(transformedItem);
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
                        adapter = new ParkEventsAdapter(eventItems);
                        recyclerView.setAdapter(adapter);

                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.d("failure", "no connection");


                Toast.makeText(rootView.getContext(), "Error getting park data", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
