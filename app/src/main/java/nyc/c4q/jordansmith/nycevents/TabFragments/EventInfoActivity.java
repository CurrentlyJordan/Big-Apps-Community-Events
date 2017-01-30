package nyc.c4q.jordansmith.nycevents.TabFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.jordansmith.nycevents.EventsViewHolder;
import nyc.c4q.jordansmith.nycevents.Models.Items;
import nyc.c4q.jordansmith.nycevents.R;

/**
 * Created by jordansmith on 1/29/17.
 */

public class EventInfoActivity extends AppCompatActivity {
    TextView eventNameTextView;
    TextView eventInfoTextView;
    ImageView eventPictureImageView;
    ImageView scrollingImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        eventNameTextView = (TextView) findViewById(R.id.event_name_textview);
        eventInfoTextView = (TextView) findViewById(R.id.event_desc_textview);
        eventPictureImageView = (ImageView) findViewById(R.id.event_imageview);
        scrollingImageView = (ImageView) findViewById(R.id.main_backdrop);
        SetEventInfo();
    }

    private void SetEventInfo() {
        Intent intent = getIntent();
        Items eventItem = (Items) intent.getSerializableExtra(EventsViewHolder.EVENT_TAG);
        eventNameTextView.setText(eventItem.getName());
        eventInfoTextView.setText(Html.fromHtml(eventItem.getDesc()).toString());
        if(eventItem.getImageUrl() == null){
            eventPictureImageView.setVisibility(View.GONE);
        }
        else{
            setEventImageURL(eventItem.getImageUrl());

        }


    }

    public void setEventImageURL(String imageURL){
        String fullEventImageUrl = "http://www1.nyc.gov" + imageURL;
        Glide.with(getApplicationContext()).load(fullEventImageUrl).into(eventPictureImageView);
        Glide.with(getApplicationContext()).load(fullEventImageUrl).centerCrop().into(scrollingImageView);

    }
}
