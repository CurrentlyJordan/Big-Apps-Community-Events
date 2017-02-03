package nyc.c4q.jordansmith.nycevents;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.Items;

/**
 * Created by jordansmith on 2/2/17.
 */

public class SavedData {

    public static List<Items> savedEvents = new ArrayList<>();

    public static List<Items> getSavedEvents() {
        return savedEvents;
    }

    public static void setSavedEvents(List<Items> savedEvents) {
        SavedData.savedEvents = savedEvents;
    }
}
