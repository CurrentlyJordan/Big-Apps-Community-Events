package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jordansmith on 2/3/17.
 */

public class SavedPlaceAdapter extends RecyclerView.Adapter<SavedPlaceAdapter.SavedPlaceViewHolder> {

    List<DatabasePlace> placeList;

    SavedPlaceAdapter(List<DatabasePlace> placeList){
        this.placeList = placeList;
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
        TextView rateTextView;
        TextView specialsTextView;

        public SavedPlaceViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.saved_museum_name_tv);
            addressTextView = (TextView) itemView.findViewById(R.id.saved_museum_address_tv);
            phoneTextView = (TextView) itemView.findViewById(R.id.saved_museum_phone_tv);
            rateTextView = (TextView) itemView.findViewById(R.id.saved_museum_rate_tv);
            specialsTextView = (TextView) itemView.findViewById(R.id.saved_museum_specials_tv);
        }

        public void bind(DatabasePlace databasePlace) {
            nameTextView.setText(databasePlace.getName());
            addressTextView.setText(databasePlace.getAddress());
            phoneTextView.setText(databasePlace.getPhone());
            rateTextView.setText(databasePlace.getRates());
            specialsTextView.setText(databasePlace.getSpecials());
        }
    }
}
