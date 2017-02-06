package nyc.c4q.jordansmith.nycevents.savedfavorites;

import android.database.sqlite.SQLiteDatabase;
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

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.database.DatabasePlace;
import nyc.c4q.jordansmith.nycevents.database.EventsDatabaseHelper;
import nyc.c4q.jordansmith.nycevents.savedfavorites.SavedPlaceAdapter;

import static android.content.ContentValues.TAG;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by jordansmith on 2/3/17.
 */

public class SavedPlacesChildFragment extends Fragment implements SavedPlaceAdapter.Listener {
    RecyclerView recyclerView;
    View rootView;
    SavedPlaceAdapter adapter;
    SQLiteDatabase db;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventsDatabaseHelper dbHelper = EventsDatabaseHelper.getInstance(getContext());
        db = dbHelper.getWritableDatabase();
        rootView = inflater.inflate(R.layout.saved_places_fragment_layout, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.saved_places_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new SavedPlaceAdapter(retrieveDatabasePlaces(), this);
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter = new SavedPlaceAdapter(retrieveDatabasePlaces(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPlaceLongClicked(DatabasePlace databasePlace) {
        long databaseId = databasePlace.get_id();
        cupboard().withDatabase(db).delete(DatabasePlace.class, databaseId );
        Toast.makeText(getContext(), "Place Deleted!", Toast.LENGTH_SHORT).show();
        adapter = new SavedPlaceAdapter(retrieveDatabasePlaces(),this);
        recyclerView.setAdapter(adapter);
    }


    public List<DatabasePlace> retrieveDatabasePlaces(){
        List<DatabasePlace> databasePlaceList = new ArrayList<>();

        try {
            // Iterate Events
            QueryResultIterable<DatabasePlace> itr = cupboard().withDatabase(db).query(DatabasePlace.class).query();
            for (DatabasePlace databasePlace: itr) {
                databasePlaceList.add(databasePlace);
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "selectAllEvents: ", e);
        }
        return databasePlaceList;

    }
}

