package nyc.c4q.jordansmith.nycevents;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by jordansmith on 2/3/17.
 */

public class NYCEventsApplication extends Application {
    public void onCreate() {
        Stetho.initializeWithDefaults(this);
    }
}
