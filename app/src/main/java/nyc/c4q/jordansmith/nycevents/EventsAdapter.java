package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.nycevents.Items;

/**
 * Created by helenchan on 1/29/17.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsViewHolder> {
    List<Items> eventsList = new ArrayList<>();

    public EventsAdapter(List<Items> eventsList) {

        this.eventsList = eventsList;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_itemview, parent, false);
        return new EventsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        Items eventItems = eventsList.get(position);
        holder.bind(eventItems);

    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}
