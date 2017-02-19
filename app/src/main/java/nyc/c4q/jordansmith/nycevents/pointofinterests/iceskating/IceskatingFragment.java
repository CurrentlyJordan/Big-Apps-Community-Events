package nyc.c4q.jordansmith.nycevents.pointofinterests.iceskating;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.iceskating.Iceskating;
import nyc.c4q.jordansmith.nycevents.network.IceskatingService;
import nyc.c4q.jordansmith.nycevents.pointofinterests.iceskating.IceSkatingAdapter;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by helenchan on 2/5/17.
 */

public class IceskatingFragment extends Fragment {
    private RecyclerView recyclerView;
    List<Iceskating.Facility> iceList = new ArrayList<>();
    View mRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.iceskating_fragment, container, false);
        recyclerView = (RecyclerView) mRoot.findViewById(R.id.iceskate_recyclerview);
        return mRoot;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchIceskatingData();
    }

    private void fetchIceskatingData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nycgovparks.org/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        IceskatingService service = retrofit.create(IceskatingService.class);
        Call<Iceskating> call = service.getSkatingDeets();
        call.enqueue(new Callback<Iceskating>() {
            @Override
            public void onResponse(Call<Iceskating> call, Response<Iceskating> response) {
                iceList = response.body().getFacility();
                recyclerView.setLayoutManager(new LinearLayoutManager(mRoot.getContext()));
                recyclerView.setAdapter(new IceSkatingAdapter(iceList));
            }

            @Override
            public void onFailure(Call<Iceskating> call, Throwable t) {

            }
        });
    }
}
