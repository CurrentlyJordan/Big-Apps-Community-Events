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
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.konifar.fab_transformation.FabTransformation;

import nyc.c4q.jordansmith.nycevents.EventsViewHolder;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.Items;

/**
 * Created by jordansmith on 1/29/17.
 */

public class EventInfoActivity extends AppCompatActivity implements View.OnClickListener {
    TextView eventNameTextView;
    TextView eventInfoTextView;
    ImageView eventPictureImageView;
    ImageView scrollingImageView;
    FloatingActionButton eventFAB;
    Toolbar fabToolbar;
    String eventUrl;

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
    }

    private void SetEventInfo() {
        Intent intent = getIntent();
        Items eventItem = (Items) intent.getSerializableExtra(EventsViewHolder.EVENT_TAG);
        eventNameTextView.setText(eventItem.getName());
        eventInfoTextView.setText(Html.fromHtml(eventItem.getDesc()).toString());
        if (eventItem.getImageUrl() == null) {
            eventPictureImageView.setVisibility(View.GONE);
        } else {
            setEventImageURL(eventItem.getImageUrl());

        }
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
