package nyc.c4q.jordansmith.nycevents.pointofinterests.zoo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.jordansmith.nycevents.database.EventsDatabaseHelper;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.database.DatabasePlace;
import nyc.c4q.jordansmith.nycevents.models.zoos_aquariums.Facility;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by helenchan on 2/3/17.
 */
public class ZooViewHolder extends RecyclerView.ViewHolder {
    private TextView zooNameTV;
    private TextView zooAddyTV;
    private TextView zooPhoneTV;
    private ImageView zooPurpleLikeButton;
    private ImageView zooGreenLikeButton;
    private boolean likedClicked = false;
    SQLiteDatabase db;
    Facility facility;


    public ZooViewHolder(View itemView) {
        super(itemView);
        EventsDatabaseHelper dbHelper = EventsDatabaseHelper.getInstance(itemView.getContext());
        db = dbHelper.getWritableDatabase();
        zooNameTV = (TextView) itemView.findViewById(R.id.zoo_name_tv);
        zooAddyTV = (TextView) itemView.findViewById(R.id.zoo_address_tv);
        zooPhoneTV = (TextView) itemView.findViewById(R.id.zoo_phone_tv);
        zooPhoneTV.setOnClickListener(clickPhone());
        zooPurpleLikeButton = (ImageView) itemView.findViewById(R.id.zoo_like_purple_icon);
        zooPurpleLikeButton.setOnClickListener(purpleLikeClick());
        zooGreenLikeButton = (ImageView) itemView.findViewById(R.id.zoo_like_green_icon);
        zooGreenLikeButton.setOnClickListener(greenLikeClick());
    }

    @NonNull
    private View.OnClickListener clickPhone() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemView.getContext().startActivity( new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + facility.getPhone_Num())));

            }
        };
    }


    @NonNull
    private View.OnClickListener purpleLikeClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likedClicked = true;
                zooPurpleLikeButton.setVisibility(View.INVISIBLE);
                zooGreenLikeButton.setVisibility(View.VISIBLE);
                DatabasePlace databasePlace = facility.transform();
                Toast.makeText(itemView.getContext(), "Event Saved", Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).put(databasePlace);
            }
        };
    }

    @NonNull
    private View.OnClickListener greenLikeClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likedClicked = false;
                zooGreenLikeButton.setVisibility(View.INVISIBLE);
                zooPurpleLikeButton.setVisibility(View.VISIBLE);
                cupboard().withDatabase(db).delete(DatabasePlace.class, "name = ?", facility.getName());
            }
        };
    }

    public void bind(Facility facility) {
        this.facility = facility;
        zooNameTV.setText(facility.getName());
        zooAddyTV.setText(facility.getLocation());
        zooPhoneTV.setText(facility.getPhone_Num());
    }
}
