package nyc.c4q.jordansmith.nycevents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jordansmith on 2/3/17.
 */

public class SavedPlacesChildFragment extends Fragment {
    RecyclerView recyclerView;
    View rootView;
    SavedPlaceAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.saved_places_fragment_layout, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.saved_places_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new SavedPlaceAdapter(SavedData.savedPlaces);
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}

