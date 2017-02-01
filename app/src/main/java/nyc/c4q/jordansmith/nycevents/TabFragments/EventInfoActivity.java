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
<<<<<<< HEAD
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
=======
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de
import com.konifar.fab_transformation.FabTransformation;

import nyc.c4q.jordansmith.nycevents.EventsViewHolder;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.Items;
<<<<<<< HEAD

import static nyc.c4q.jordansmith.nycevents.R.id.map;
=======
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de


<<<<<<< HEAD
public class EventInfoActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

=======
public class EventInfoActivity extends AppCompatActivity implements View.OnClickListener {
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de
    TextView eventNameTextView;
    TextView eventInfoTextView;
    TextView eventTimeTextVIew;
    ImageView scrollingImageView;
    FloatingActionButton eventFAB;
    Toolbar fabToolbar;
    String eventUrl;
<<<<<<< HEAD
    LinearLayout mapHolderLinearLayout;
    Toolbar toolbar;
    GoogleMap mMap;
    LatLng eventLocation;
    String eventTitle;
    SupportMapFragment mapFragment;

=======
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        initialize();
        initializeButtons();
        SetEventInfo();
<<<<<<< HEAD
//        mapFragment = (SupportMapFragment) getSupportFragmentManager()
//        .findFragmentById(map);
//        mapFragment.getMapAsync(this);
    }

    private void initialize() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
=======
    }

    private void initialize() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de
        setSupportActionBar(toolbar);
        fabToolbar = (Toolbar) findViewById(R.id.fab_toolbar);
        eventFAB = (FloatingActionButton) findViewById(R.id.fab_event_info_button);
        eventFAB.setOnClickListener(this);
        eventNameTextView = (TextView) findViewById(R.id.event_name_textview);
        eventInfoTextView = (TextView) findViewById(R.id.event_desc_textview);
        eventTimeTextVIew = (TextView)findViewById(R.id.event_time_textview);
        scrollingImageView = (ImageView) findViewById(R.id.main_backdrop);
<<<<<<< HEAD
        mapHolderLinearLayout = (LinearLayout) findViewById(R.id.map_holder);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }

    private void initializeButtons() {
=======

    }

    private void initializeButtons(){
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de
        ImageView closeButton = (ImageView) findViewById(R.id.close_toolbar);
        closeButton.setOnClickListener(this);
        ImageView chromeButton = (ImageView) findViewById(R.id.chrome_button_toolbar);
        chromeButton.setOnClickListener(this);
        ImageView shareButton = (ImageView) findViewById(R.id.share_button_toolbar);
        shareButton.setOnClickListener(this);
<<<<<<< HEAD
        SetEventInfo();

=======
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de
    }



    private void SetEventInfo() {
        Intent intent = getIntent();
        Items eventItem = (Items) intent.getSerializableExtra(EventsViewHolder.EVENT_TAG);
        eventNameTextView.setText(eventItem.getName());
        eventInfoTextView.setText(Html.fromHtml(eventItem.getDesc()).toString());
<<<<<<< HEAD
        eventTimeTextVIew.setText(eventItem.getDatePart() + " (" + eventItem.getTimePart() + ")");
        eventTitle = eventItem.getName();
        if(eventItem.getImageUrl() == null){
            scrollingImageView.setImageResource(R.drawable.default_event_image);
        }
        else{
=======
        if (eventItem.getImageUrl() == null) {
            eventPictureImageView.setVisibility(View.GONE);
        } else {
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de
            setEventImageURL(eventItem.getImageUrl());
        }
<<<<<<< HEAD
        if(eventItem.getGeometry() != null){
            double eventLat = convertCoordinates(eventItem.getGeometry().get(0).getLat());
            double eventLong = convertCoordinates(eventItem.getGeometry().get(0).getLng());
            eventLocation = new LatLng(eventLat,eventLong);
        }
        else{
            mapHolderLinearLayout.setVisibility(View.GONE);
        }
        eventUrl = eventItem.getWebsite();
        if (eventUrl == null) {
            eventUrl = eventItem.getPermalink();
        }

    }



    public void setEventImageURL(String imageURL){
        String fullEventImageUrl = "http://www1.nyc.gov" + imageURL;
        Glide.with(getApplicationContext())
                .load(fullEventImageUrl)
                .centerCrop()
                .into(scrollingImageView);

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



=======
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

>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_event_info_button:
                FabTransformation.with(eventFAB)
                        .transformTo(fabToolbar);
                break;
<<<<<<< HEAD
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

=======
>>>>>>> 21479da14ca1f4c63efd9c5ef739faa81beac2de

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

}




