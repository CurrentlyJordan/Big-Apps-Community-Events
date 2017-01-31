package nyc.c4q.jordansmith.nycevents.tabfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.jordansmith.nycevents.EventsViewHolder;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.Items;

/**
 * Created by jordansmith on 1/29/17.
 */

public class EventInfoActivity extends AppCompatActivity {
    TextView eventNameTextView;
    TextView eventInfoTextView;
    TextView eventTimeTextVIew;
    ImageView scrollingImageView;
    Button openInMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        eventNameTextView = (TextView) findViewById(R.id.event_name_textview);
        eventInfoTextView = (TextView) findViewById(R.id.event_desc_textview);
        scrollingImageView = (ImageView) findViewById(R.id.main_backdrop);
        eventTimeTextVIew = (TextView) findViewById(R.id.event_time_textview);
        openInMaps = (Button) findViewById(R.id.open_in_maps_button);
        SetEventInfo();
    }

    private void SetEventInfo() {
        Intent intent = getIntent();
        Items eventItem = (Items) intent.getSerializableExtra(EventsViewHolder.EVENT_TAG);
        eventNameTextView.setText(eventItem.getName());
        eventInfoTextView.setText(Html.fromHtml(eventItem.getDesc()).toString());
        eventTimeTextVIew.setText(eventItem.getDatePart() + " (" + eventItem.getTimePart() + ")");
        if(eventItem.getImageUrl() == null){
<<<<<<< HEAD
            eventPictureImageView.setVisibility(View.GONE);
=======
>>>>>>> 46d622f8beed8d7e9874a296929ccb3554fe407b
            scrollingImageView.setImageResource(R.drawable.default_event_image);
        }
        else{
            setEventImageURL(eventItem.getImageUrl());

        }


    }

    public void setEventImageURL(String imageURL){
        String fullEventImageUrl = "http://www1.nyc.gov" + imageURL;
        Glide.with(getApplicationContext()).load(fullEventImageUrl).centerCrop().into(scrollingImageView);

    }
}
