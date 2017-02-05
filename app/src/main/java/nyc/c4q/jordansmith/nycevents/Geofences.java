package nyc.c4q.jordansmith.nycevents;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static android.content.ContentValues.TAG;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by jordansmith on 2/5/17.
 */

public class Geofences {

    List<Geofence> geofenceList;
    SQLiteDatabase db;

    public Geofences(SQLiteDatabase db){
        this.db = db;
    }

    public List<Geofence> setGeofenceList(){
        float radius = 1000.0f;
        List<DatabasePlace> databasePlaceList = new ArrayList<>();

        try {
            // Iterate Events
            QueryResultIterable<DatabaseEvent> itr = cupboard().withDatabase(db).query(DatabaseEvent.class).query();
            for (DatabaseEvent databaseEvent: itr) {
                if(databaseEvent.getLatitude() == null || databaseEvent.getLongitude() == null ){
                    geofenceList.add(new Geofence.Builder().setRequestId(databaseEvent.getName())
                            .setCircularRegion(Double.parseDouble(databaseEvent.getLatitude())
                                    ,Double.parseDouble(databaseEvent.getLongitude()),radius).setExpirationDuration(100000000)
                            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
                                    Geofence.GEOFENCE_TRANSITION_EXIT)
                            .build());
                }
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "selectAllEvents: ", e);
        }
        return geofenceList;
    }

    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(geofenceList);
        return builder.build();
    }

}
