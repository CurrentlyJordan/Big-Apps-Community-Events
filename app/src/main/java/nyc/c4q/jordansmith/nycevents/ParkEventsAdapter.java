package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.nycevents.Items;

/**
 * Created by jordansmith on 2/1/17.
 */

public class ParkEventsAdapter extends RecyclerView.Adapter<ParkEventsViewHolder> {
    List<Items> eventsList = new ArrayList<>();

    public ParkEventsAdapter(List<Items> eventsList) {

        this.eventsList = eventsList;
    }

    @Override
    public ParkEventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_itemview, parent, false);
        return new ParkEventsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ParkEventsViewHolder holder, int position) {
        Items eventItem = eventsList.get(position);
        holder.bind(eventItem);



    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}
