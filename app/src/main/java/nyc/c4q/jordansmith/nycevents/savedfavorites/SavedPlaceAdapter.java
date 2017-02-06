package nyc.c4q.jordansmith.nycevents.savedfavorites;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.database.DatabasePlace;

/**
 * Created by jordansmith on 2/3/17.
 */

public class SavedPlaceAdapter extends RecyclerView.Adapter<SavedPlaceAdapter.SavedPlaceViewHolder> {

    List<DatabasePlace> placeList;
    Listener listener;

    SavedPlaceAdapter(List<DatabasePlace> placeList, Listener listener ){
        this.placeList = placeList;
        this.listener = listener;
    }

    @Override
    public SavedPlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_places_item_view, parent, false);

        return new SavedPlaceViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(SavedPlaceViewHolder holder, int position) {
        DatabasePlace databasePlace = placeList.get(position);
        holder.bind(databasePlace);

    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }


    public class SavedPlaceViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView addressTextView;
        TextView phoneTextView;
        DatabasePlace savedPlace;


        public SavedPlaceViewHolder(final View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.saved_museum_name_tv);
            addressTextView = (TextView) itemView.findViewById(R.id.saved_museum_address_tv);
            phoneTextView = (TextView) itemView.findViewById(R.id.saved_museum_phone_tv);
            phoneTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.getContext().startActivity( new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + savedPlace.getPhone())));

                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onPlaceLongClicked(savedPlace);
                    return true;
                }
            });

        }

        public void bind(DatabasePlace savedPlace) {
            this.savedPlace = savedPlace;
            nameTextView.setText(savedPlace.getName());
            addressTextView.setText(savedPlace.getAddress());
            phoneTextView.setText(savedPlace.getPhone());
        }
    }

    interface Listener{
        void onPlaceLongClicked(DatabasePlace databasePlace);

    }
}
