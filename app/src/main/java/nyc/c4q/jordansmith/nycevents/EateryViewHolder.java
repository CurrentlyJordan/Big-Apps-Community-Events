package nyc.c4q.jordansmith.nycevents;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.jordansmith.nycevents.models.eateries.Eateries;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by helenchan on 2/3/17.
 */
public class EateryViewHolder extends RecyclerView.ViewHolder {
    private TextView typeNameTV;
    private TextView nameTV;
    private TextView descriptionTV;
    private TextView locationTV;
    private TextView phoneTV;
    private ImageView purpleLikeButton;
    private ImageView greenLikeButton;
    private boolean likeClicked = false;
    Eateries.Facility eateries;
    SQLiteDatabase db;


    public EateryViewHolder(final View itemView) {
        super(itemView);
        EventsDatabaseHelper dbHelper = EventsDatabaseHelper.getInstance(itemView.getContext());
        db = dbHelper.getWritableDatabase();
        typeNameTV = (TextView) itemView.findViewById(R.id.eatery_type_name_tv);
        nameTV = (TextView) itemView.findViewById(R.id.eatery_name_tv);
        descriptionTV = (TextView) itemView.findViewById(R.id.eatery_description_tv);
        locationTV = (TextView) itemView.findViewById(R.id.eatery_location_tv);
        phoneTV = (TextView) itemView.findViewById(R.id.eatery_phone_tv);
        phoneTV.setOnClickListener(phoneClick(itemView));
        purpleLikeButton = (ImageView) itemView.findViewById(R.id.eatery_purple_like_icon);
        purpleLikeButton.setOnClickListener(purpleLikeClick());
        greenLikeButton = (ImageView) itemView.findViewById(R.id.eatery_green_like_icon);
        greenLikeButton.setOnClickListener(greenLikeClick());
    }

    @NonNull
    private View.OnClickListener phoneClick(final View itemView) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemView.getContext().startActivity( new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + eateries.getPhone())));

            }
        };
    }


    @NonNull
    private View.OnClickListener purpleLikeClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeClicked = true;
                purpleLikeButton.setVisibility(View.INVISIBLE);
                greenLikeButton.setVisibility(View.VISIBLE);
                Toast.makeText(itemView.getContext(), "Event Saved", Toast.LENGTH_SHORT).show();
                DatabasePlace databasePlace = eateries.transform();
                cupboard().withDatabase(db).put(databasePlace);
            }
        };
    }


    @NonNull
    private View.OnClickListener greenLikeClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeClicked = false;
                greenLikeButton.setVisibility(View.INVISIBLE);
                purpleLikeButton.setVisibility(View.VISIBLE);
                cupboard().withDatabase(db).delete(DatabasePlace.class, "name = ?", eateries.getName());
            }
        };
    }

    public void bind(Eateries.Facility eateries) {
        this.eateries = eateries;
        typeNameTV.setText(eateries.getType_name());
        nameTV.setText(eateries.getName());
        descriptionTV.setText(eateries.getDescription());
        locationTV.setText(eateries.getLocation());
        phoneTV.setText(eateries.getPhone());
    }
}
