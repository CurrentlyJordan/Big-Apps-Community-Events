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

import nyc.c4q.jordansmith.nycevents.models.museums.Museum;
import nyc.c4q.jordansmith.nycevents.models.museums.Museums;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by helenchan on 2/1/17.
 */

public class MuseumFragment extends Fragment {
    private RecyclerView museumRV;
    List<Museum> museumsList = new ArrayList<>();
    MuseumAdapter adapter;
    View museumRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        museumRootView = inflater.inflate(R.layout.museum_fragment, container, false);
        museumRV = (RecyclerView) museumRootView.findViewById(R.id.museum_recyclerview);
        return museumRootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchMuseums();
    }

    public void fetchMuseums() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        MuseumsService service = retrofit.create(MuseumsService.class);
        Call<Museums> call = service.getMuseums();
        call.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                museumsList = response.body().getMuseum();
                museumRV.setLayoutManager(new LinearLayoutManager(museumRootView.getContext()));
                museumRV.setAdapter(new MuseumAdapter(museumsList));
            }

            @Override
            public void onFailure(Call<Museums> call, Throwable t) {
                Toast.makeText(museumRootView.getContext(), "Unable to Download Museum Data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
