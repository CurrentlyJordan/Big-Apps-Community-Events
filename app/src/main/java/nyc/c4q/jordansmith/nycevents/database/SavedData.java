package nyc.c4q.jordansmith.nycevents.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordansmith on 2/2/17.
 */

public class SavedData {

    public static List<DatabaseEvent> savedEvents = new ArrayList<>();
    public static List<DatabasePlace> savedPlaces = new ArrayList<>();


    public static List<DatabasePlace> getSavedPlaces() {
        return savedPlaces;
    }

    public static void setSavedPlaces(List<DatabasePlace> savedPlaces) {
        SavedData.savedPlaces = savedPlaces;
    }

    public static List<DatabaseEvent> getSavedEvents() {
        return savedEvents;
    }

    public static void setSavedEvents(List<DatabaseEvent> savedEvents) {
        SavedData.savedEvents = savedEvents;
    }

}
