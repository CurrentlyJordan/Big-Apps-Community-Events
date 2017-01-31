package nyc.c4q.jordansmith.nycevents.tabfragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import com.konifar.fab_transformation.FabTransformation;

import nyc.c4q.jordansmith.nycevents.EventsViewHolder;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.Items;
import retrofit2.http.HEAD;

import static nyc.c4q.jordansmith.nycevents.R.id.map;


/**
 * Created by jordansmith on 1/29/17.
 */


public class EventInfoActivity extends AppCompatActivity implements View.OnClickListener {
    TextView eventNameTextView;
    TextView eventInfoTextView;
    TextView eventTimeTextVIew;
    ImageView scrollingImageView;
    FloatingActionButton eventFAB;
    Toolbar fabToolbar;
    String eventUrl;
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
        initialize();
        initializeButtons();
        SetEventInfo();
    }

    private void initialize() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        fabToolbar = (Toolbar) findViewById(R.id.fab_toolbar);
        eventFAB = (FloatingActionButton) findViewById(R.id.fab_event_info_button);
        eventFAB.setOnClickListener(this);
        eventNameTextView = (TextView) findViewById(R.id.event_name_textview);
        eventInfoTextView = (TextView) findViewById(R.id.event_desc_textview);
        eventPictureImageView = (ImageView) findViewById(R.id.event_imageview);
        scrollingImageView = (ImageView) findViewById(R.id.main_backdrop);

    }

    private void initializeButtons(){
        ImageView closeButton = (ImageView) findViewById(R.id.close_toolbar);
        closeButton.setOnClickListener(this);
        ImageView chromeButton = (ImageView) findViewById(R.id.chrome_button_toolbar);
        chromeButton.setOnClickListener(this);
        ImageView shareButton = (ImageView) findViewById(R.id.share_button_toolbar);
        shareButton.setOnClickListener(this);
=======
        initViews();
        SetEventInfo();
//        mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(map);
//        mapFragment.getMapAsync(this);
>>>>>>> ddba71577bec6fa3cfa1b87e4e188d88e400f5d8
    }

    private void SetEventInfo() {
        Intent intent = getIntent();
        Items eventItem = (Items) intent.getSerializableExtra(EventsViewHolder.EVENT_TAG);
        eventNameTextView.setText(eventItem.getName());
        eventInfoTextView.setText(Html.fromHtml(eventItem.getDesc()).toString());
<<<<<<< HEAD
        if (eventItem.getImageUrl() == null) {
            eventPictureImageView.setVisibility(View.GONE);
        } else {
=======
        eventTimeTextVIew.setText(eventItem.getDatePart() + " (" + eventItem.getTimePart() + ")");
        eventTitle = eventItem.getName();
        if(eventItem.getImageUrl() == null){
            scrollingImageView.setImageResource(R.drawable.default_event_image);
        }
        else{
>>>>>>> ddba71577bec6fa3cfa1b87e4e188d88e400f5d8
            setEventImageURL(eventItem.getImageUrl());
        }
<<<<<<< HEAD
        eventUrl = eventItem.getWebsite();
        if(eventUrl == null){
            eventUrl = eventItem.getPermalink();
        }
    }

    public void setEventImageURL(String imageURL) {
        String fullEventImageUrl = "http://www1.nyc.gov" + imageURL;
        Glide.with(getApplicationContext())
                .load(fullEventImageUrl)
                .into(eventPictureImageView);
        Glide.with(getApplicationContext())
                .load(fullEventImageUrl)
                .centerCrop().into(scrollingImageView);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_event_info_button:
                FabTransformation.with(eventFAB)
                        .transformTo(fabToolbar);
                break;
=======
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
>>>>>>> ddba71577bec6fa3cfa1b87e4e188d88e400f5d8

            case R.id.close_toolbar:
                FabTransformation.with(eventFAB)
                        .duration(200)
                        .transformFrom(fabToolbar);
                break;

            case R.id.chrome_button_toolbar:
                Uri uri = Uri.parse(eventUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                FabTransformation.with(eventFAB)
                        .transformFrom(fabToolbar);
                break;

            case R.id.share_button_toolbar:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, eventUrl);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
                break;

        }
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
