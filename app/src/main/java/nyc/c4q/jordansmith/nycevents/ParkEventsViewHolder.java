package nyc.c4q.jordansmith.nycevents;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import nyc.c4q.jordansmith.nycevents.models.Items;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by jordansmith on 2/1/17.
 */

public class ParkEventsViewHolder extends RecyclerView.ViewHolder {
    Items eventItems;
    TextView date_TV;
    TextView nameTV;
    TextView descriptionTV;
    ImageView eventImage;
    String imageURL;
    public final static String EVENT_TAG = "SELECTED IMAGE";
    private ImageView purpleLikeButton;
    private ImageView greenLikeButton;
    SQLiteDatabase db;



    public ParkEventsViewHolder(View itemView) {
        super(itemView);
        EventsDatabaseHelper dbHelper = EventsDatabaseHelper.getInstance(itemView.getContext());
        db = dbHelper.getWritableDatabase();
        final Context context = itemView.getContext();
        date_TV = (TextView)itemView.findViewById(R.id.date_tv);
        nameTV = (TextView)itemView.findViewById(R.id.name_of_event_tv);
        descriptionTV = (TextView) itemView.findViewById(R.id.short_desc_tv);
        eventImage = (ImageView)itemView.findViewById(R.id.event_imageview);
        purpleLikeButton = (ImageView) itemView.findViewById(R.id.evnts_purple_like);
        purpleLikeButton.setOnClickListener(purpleLikeClick());
        greenLikeButton = (ImageView) itemView.findViewById(R.id.evnts_green_like);
        greenLikeButton.setOnClickListener(greenLikeClick());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ParkEventInfoActivity.class);
                intent.putExtra(EVENT_TAG, eventItems);
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    private View.OnClickListener purpleLikeClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purpleLikeButton.setVisibility(View.INVISIBLE);
                greenLikeButton.setVisibility(View.VISIBLE);
//                DatabaseEvent databaseEvent = eventItems;
                Toast.makeText(itemView.getContext(), "Event Saved", Toast.LENGTH_SHORT).show();
//                cupboard().withDatabase(db).put(eventItems);

            }
        };
    }

    @NonNull
    private View.OnClickListener greenLikeClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greenLikeButton.setVisibility(View.INVISIBLE);
                purpleLikeButton.setVisibility(View.VISIBLE);
                Toast.makeText(itemView.getContext(), "Event Deleted", Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(DatabasePlace.class,"name = ?", eventItems.getName());
            }
        };
    }

    public void bind(Items eventItems) {
        this.eventItems = eventItems;
        date_TV.setText(eventItems.getDatePart() + " (" + eventItems.getTimePart() + ")");
        nameTV.setText(eventItems.getName());
        descriptionTV.setText(Html.fromHtml(eventItems.getShortDesc()).toString());
        imageURL = eventItems.getImageUrl();
        if(imageURL == null) {
            eventImage.setVisibility(View.GONE);
        }else {
            eventImage.setVisibility(View.VISIBLE);
            setImage(imageURL);
        }
    }

    public void setImage(String imageURL){
        Glide.with(itemView.getContext()).load(imageURL).centerCrop().into(eventImage);

    }
}
