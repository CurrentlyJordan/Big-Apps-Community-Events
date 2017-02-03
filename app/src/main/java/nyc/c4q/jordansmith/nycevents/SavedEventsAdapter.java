package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.Items;

/**
 * Created by jordansmith on 2/2/17.
 */

public class SavedEventsAdapter extends RecyclerView.Adapter<SavedEventsAdapter.SavedEventsViewHolder> {

    List<Items> eventList;

    public SavedEventsAdapter(List<Items> eventList) {
        this.eventList = eventList;
    }

    @Override
    public SavedEventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_events_item_view, parent, false);
        return new SavedEventsViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(SavedEventsViewHolder holder, int position) {
        Items savedEvent = eventList.get(position);
        holder.bind(savedEvent);

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class SavedEventsViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView titleTextView;
        TextView descTextView;
        Items savedEvent;

        public SavedEventsViewHolder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.saved_event_date_tv);
            titleTextView = (TextView) itemView.findViewById(R.id.saved_event_name_of_event_tv);
            descTextView = (TextView) itemView.findViewById(R.id.saved_event_short_desc_tv);
        }

        public void bind(Items savedEvent) {
            this.savedEvent = savedEvent;
            dateTextView.setText(savedEvent.getDatePart() + " (" + savedEvent.getTimePart() + ")");
            titleTextView.setText(savedEvent.getName());
            descTextView.setText(savedEvent.getShortDesc());
        }
    }
}
