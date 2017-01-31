package nyc.c4q.jordansmith.nycevents.tabfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

import nyc.c4q.jordansmith.nycevents.EventsViewHolder;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.Items;

import static nyc.c4q.jordansmith.nycevents.R.id.map;

/**
 * Created by jordansmith on 1/29/17.
 */

public class EventInfoActivity extends AppCompatActivity implements OnMapReadyCallback {
    TextView eventNameTextView;
    TextView eventInfoTextView;
    TextView eventTimeTextVIew;
    ImageView scrollingImageView;
    LinearLayout mapHolderLinearLayout;
    Toolbar toolbar;
    GoogleMap mMap;
    LatLng eventLocation;
    String eventTitle;
    SupportMapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        initViews();
        SetEventInfo();
//        mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(map);
//        mapFragment.getMapAsync(this);
    }

    private void SetEventInfo() {
        Intent intent = getIntent();
        Items eventItem = (Items) intent.getSerializableExtra(EventsViewHolder.EVENT_TAG);
        eventNameTextView.setText(eventItem.getName());
        eventInfoTextView.setText(Html.fromHtml(eventItem.getDesc()).toString());
        eventTimeTextVIew.setText(eventItem.getDatePart() + " (" + eventItem.getTimePart() + ")");
        eventTitle = eventItem.getName();
        if(eventItem.getImageUrl() == null){
            scrollingImageView.setImageResource(R.drawable.default_event_image);
        }
        else{
            setEventImageURL(eventItem.getImageUrl());
        }
        if(eventItem.getGeometry() != null){
            double eventLat = convertCoordinates(eventItem.getGeometry().get(0).getLat());
            double eventLong = convertCoordinates(eventItem.getGeometry().get(0).getLng());
            eventLocation = new LatLng(eventLat,eventLong);
        }
        else{
            mapHolderLinearLayout.setVisibility(View.GONE);
        }

    }

    public void setEventImageURL(String imageURL){
        String fullEventImageUrl = "http://www1.nyc.gov" + imageURL;
        Glide.with(getApplicationContext()).load(fullEventImageUrl).centerCrop().into(scrollingImageView);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(eventLocation != null){
            mMap.addMarker(new MarkerOptions().position(eventLocation).title(eventTitle));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eventLocation, 15));

        }

    }

    private double convertCoordinates(String coordinate){
        return Double.parseDouble(coordinate);
    }

    private void initViews(){
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        eventNameTextView = (TextView) findViewById(R.id.event_name_textview);
        eventInfoTextView = (TextView) findViewById(R.id.event_desc_textview);
        scrollingImageView = (ImageView) findViewById(R.id.main_backdrop);
        eventTimeTextVIew = (TextView) findViewById(R.id.event_time_textview);
        mapHolderLinearLayout = (LinearLayout) findViewById(R.id.map_holder);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);

    }
}
