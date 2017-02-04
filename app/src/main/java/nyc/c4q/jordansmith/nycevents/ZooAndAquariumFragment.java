package nyc.c4q.jordansmith.nycevents;

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

import nyc.c4q.jordansmith.nycevents.models.zoos_aquariums.Facility;
import nyc.c4q.jordansmith.nycevents.models.zoos_aquariums.Zoos;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by helenchan on 2/2/17.
 */
public class ZooAndAquariumFragment extends Fragment {
    private RecyclerView recyclerView;
    List<Facility> zooList = new ArrayList<>();
    View mRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.zoo_fragment, container, false);
        recyclerView = (RecyclerView) mRoot.findViewById(R.id.zoo_recyclerview);
        return mRoot;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchZoos();
    }

    private void fetchZoos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nycgovparks.org/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        ZooService service = retrofit.create(ZooService.class);
        Call<Zoos> call = service.getZooAndAq();
        call.enqueue(new Callback<Zoos>() {
            @Override
            public void onResponse(Call<Zoos> call, Response<Zoos> response) {
                zooList = response.body().getFacility();
                recyclerView.setLayoutManager(new LinearLayoutManager(mRoot.getContext()));
                recyclerView.setAdapter(new ZooAdapter(zooList));
            }

            @Override
            public void onFailure(Call<Zoos> call, Throwable t) {

            }
        });
    }
}
