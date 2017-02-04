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

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.eateries.Eateries;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by helenchan on 2/3/17.
 */

public class EateriesFragment extends Fragment {
    List<Eateries.Facility> eateriesList = new ArrayList<>();
    RecyclerView eateryRV;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.eatery_fragment, container, false);
        eateryRV = (RecyclerView) rootView.findViewById(R.id.eatery_recyclerview);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchEateries();
    }

    private void fetchEateries() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nycgovparks.org/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        EateryService service = retrofit.create(EateryService.class);
        Call<Eateries> call = service.getEateries();
        call.enqueue(new Callback<Eateries>() {
            @Override
            public void onResponse(Call<Eateries> call, Response<Eateries> response) {
                Log.d(TAG, "success " + response.body().toString());
                eateriesList = response.body().getFacility();
                eateryRV.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
                eateryRV.setAdapter(new EateryAdapter(eateriesList));
            }

            @Override
            public void onFailure(Call<Eateries> call, Throwable t) {
                Log.d("failure", "no connection");
                Toast.makeText(rootView.getContext(), "Unable to Download Data", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
