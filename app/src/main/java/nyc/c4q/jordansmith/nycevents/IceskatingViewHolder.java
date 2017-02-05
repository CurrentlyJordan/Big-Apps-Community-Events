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

import nyc.c4q.jordansmith.nycevents.models.iceskating.Iceskating;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by helenchan on 2/5/17.
 */
public class IceskatingViewHolder extends RecyclerView.ViewHolder {
    private TextView iceNameTV;
    private TextView iceLockerTV;
    private TextView iceType;
    private TextView iceLocation;
    private TextView icePhone;
    private TextView iceNotes;
    private ImageView purpleLikeButton;
    private ImageView greenLikeButton;
    Iceskating.Facility iceskating;
    SQLiteDatabase db;


    public IceskatingViewHolder(View itemView) {
        super(itemView);
        EventsDatabaseHelper dbHelper = EventsDatabaseHelper.getInstance(itemView.getContext());
        db = dbHelper.getWritableDatabase();
        iceNameTV = (TextView) itemView.findViewById(R.id.ice_name_tv);
        iceLockerTV = (TextView) itemView.findViewById(R.id.ice_rates_tv);
        iceType = (TextView) itemView.findViewById(R.id.ice_type_name_tv);
        iceLocation = (TextView) itemView.findViewById(R.id.ice_location_tv);
        iceNotes = (TextView) itemView.findViewById(R.id.ice_notes_tv);
        icePhone = (TextView) itemView.findViewById(R.id.ice_phone_tv);
        icePhone.setOnClickListener(phoneClick());
        purpleLikeButton = (ImageView) itemView.findViewById(R.id.ice_purple_like_icon);
        purpleLikeButton.setOnClickListener(purpleLikeClick());
        greenLikeButton = (ImageView) itemView.findViewById(R.id.ice_green_like_icon);
        greenLikeButton.setOnClickListener(greenLikeClick());
    }

    @NonNull
    private View.OnClickListener purpleLikeClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purpleLikeButton.setVisibility(View.INVISIBLE);
                greenLikeButton.setVisibility(View.VISIBLE);
                DatabasePlace databasePlace = iceskating.transform();
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
                greenLikeButton.setVisibility(View.INVISIBLE);
                purpleLikeButton.setVisibility(View.VISIBLE);
                Toast.makeText(itemView.getContext(), "Event Deleted", Toast.LENGTH_SHORT).show();
                cupboard().withDatabase(db).delete(DatabasePlace.class,"name = ?", iceskating.getName());
            }
        };
    }

    @NonNull
    private View.OnClickListener phoneClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemView.getContext().startActivity( new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + iceskating.getPhone())));

            }
        };
    }

    public void bind(Iceskating.Facility iceskating) {
        this.iceskating = iceskating;
        iceNameTV.setText(iceskating.getName());
        iceType.setText(iceskating.getIceSkating_Type());
        iceLocation.setText(iceskating.getLocation());
        icePhone.setText(iceskating.getPhone());
        if(iceskating.getNotes() == null){
            iceNotes.setVisibility(View.GONE);
        } else {
            iceNotes.setText(iceskating.getNotes());
        }
        if(iceskating.getLocker_Information() == null){
            iceLockerTV.setVisibility(View.GONE);
        }else {
            iceLockerTV.setText(iceskating.getLocker_Information());
        }
    }
}
