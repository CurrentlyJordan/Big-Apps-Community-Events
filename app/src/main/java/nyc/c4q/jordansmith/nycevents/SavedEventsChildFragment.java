package nyc.c4q.jordansmith.nycevents;

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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.jordansmith.nycevents.models.Items;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by jordansmith on 2/2/17.
 */

public class SavedEventsChildFragment extends Fragment implements SavedEventsAdapter.Listener{
    RecyclerView recyclerView;
    View rootView;
    SavedEventsAdapter adapter;
    List<Items> testEventList = new ArrayList<>();
    TextView textView;
    SQLiteDatabase db;
    private static final String TAG = SavedEventsChildFragment.class.getSimpleName();






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.saved_events_fragment_layout, container, false);

        EventsDatabaseHelper dbHelper = EventsDatabaseHelper.getInstance(getContext());
        db = dbHelper.getWritableDatabase();


        recyclerView = (RecyclerView) rootView.findViewById(R.id.saved_events_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new SavedEventsAdapter(retrieveDatabaseEvents(),this);
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    public void refreshEventsList(){
        adapter.notifyDataSetChanged();
    }

//    public void selectAllEvents(){
//        List<DatabaseEvent> databaseEventList = new ArrayList<>();
//
//        try {
//            // Iterate Events
//            QueryResultIterable<DatabaseEvent> itr = cupboard().withDatabase(db).query(DatabaseEvent.class).query();
//            for (DatabaseEvent databaseEvent: itr) {
//                databaseEventList.add(databaseEvent);
//            }
//            itr.close();
//        } catch (Exception e) {
//            Log.e(TAG, "selectAllEvents: ", e);
//        }
//        SavedData.savedEvents = databaseEventList;
//
//    }

    public List<DatabaseEvent> retrieveDatabaseEvents(){
        List<DatabaseEvent> databaseEventList = new ArrayList<>();

        try {
            // Iterate Events
            QueryResultIterable<DatabaseEvent> itr = cupboard().withDatabase(db).query(DatabaseEvent.class).query();
            for (DatabaseEvent databaseEvent: itr) {
                databaseEventList.add(databaseEvent);
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "selectAllEvents: ", e);
        }
        return databaseEventList;

    }


    @Override
    public void onResume() {
        super.onResume();
        adapter = new SavedEventsAdapter(retrieveDatabaseEvents(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onEventLongClicked(DatabaseEvent databaseEvent) {
        long databaseId = databaseEvent.get_id();
        cupboard().withDatabase(db).delete(DatabaseEvent.class, databaseId );
        Toast.makeText(getContext(), "event deleted!", Toast.LENGTH_SHORT).show();
        adapter = new SavedEventsAdapter(retrieveDatabaseEvents(),this);
        recyclerView.setAdapter(adapter);

    }


}
