package nyc.c4q.jordansmith.nycevents.savedfavorites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.database.DatabaseEvent;

import static nyc.c4q.jordansmith.nycevents.R.id.saved_event_map;

public class SavedEventInfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    ImageView scrollingImageView;
    TextView nameOfEvent;
    TextView timeOfEvent;
    TextView eventDescription;
    LinearLayout mapHolderLinearLayout;
    GoogleMap mMap;
    DatabaseEvent databaseEvent;
    LatLng eventLocation;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_event_info);
        initializeButtons();
        setEventInfo();
    }

    private void initializeButtons() {
        scrollingImageView = (ImageView) findViewById(R.id.saved_event_main_backdrop);
        nameOfEvent = (TextView) findViewById(R.id.saved_event_name_textview);
        timeOfEvent = (TextView) findViewById(R.id.saved_event_time_textview);
        eventDescription = (TextView) findViewById(R.id.saved_event_descrip_textview);
        mapHolderLinearLayout = (LinearLayout) findViewById(R.id.saved_event_map_holder);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(saved_event_map);
        mapFragment.getMapAsync(this);
    }


    public void setEventInfo(){
        Intent intent = getIntent();
        databaseEvent = (DatabaseEvent) intent.getSerializableExtra("Saved Event");
        nameOfEvent.setText(databaseEvent.getName());
        timeOfEvent.setText(databaseEvent.getStartTime());
        eventDescription.setText(Html.fromHtml(databaseEvent.getDescription()).toString());
        setImage();
        if(databaseEvent.getLatitude() == null || databaseEvent.getLongitude() == null){
            mapHolderLinearLayout.setVisibility(View.GONE);
        }
        else { double eventLat = Double.parseDouble(databaseEvent.getLatitude());
            double eventLong = Double.parseDouble(databaseEvent.getLongitude());
            eventLocation = new LatLng(eventLat, eventLong);
        }
    }

    public void setImage(){
        if (databaseEvent.getImageUrl() == null) {
            scrollingImageView.setImageResource(R.drawable.default_event_image);
        } else {
            Glide.with(getApplicationContext())
                    .load(databaseEvent.getImageUrl())
                    .centerCrop()
                    .into(scrollingImageView);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (eventLocation != null) {
            mMap.addMarker(new MarkerOptions().position(eventLocation).title(databaseEvent.getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eventLocation, 15));

        }

    }
}
