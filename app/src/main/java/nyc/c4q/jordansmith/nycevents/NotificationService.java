package nyc.c4q.jordansmith.nycevents;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;

/**
 * Created by helenchan on 2/4/17.
 */

public class NotificationService extends IntentService {
    public NotificationService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int NOTIFICATION_ID = 1;
        int requestID = (int) System.currentTimeMillis();
        Intent intents = new Intent(this, MainActivity.class);
        int flags = PendingIntent.FLAG_CANCEL_CURRENT;
    }
}
