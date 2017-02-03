package nyc.c4q.jordansmith.nycevents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.Items;

/**
 * Created by jordansmith on 2/2/17.
 */

public class SavedEventsChildFragment extends Fragment {
    RecyclerView recyclerView;
    View rootView;
    SavedEventsAdapter adapter;
    List<Items> testEventList = new ArrayList<>();
    TextView textView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.saved_events_fragment_layout, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.saved_events_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new SavedEventsAdapter(SavedData.savedEvents);
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
