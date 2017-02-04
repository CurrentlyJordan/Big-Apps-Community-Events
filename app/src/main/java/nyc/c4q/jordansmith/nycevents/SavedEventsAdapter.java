package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jordansmith on 2/2/17.
 */

public class SavedEventsAdapter extends RecyclerView.Adapter<SavedEventsAdapter.SavedEventsViewHolder> {

    List<DatabaseEvent> eventList;
    Listener listener;

    public SavedEventsAdapter(List<DatabaseEvent> eventList, Listener listener) {
        this.eventList = eventList;
        this.listener = listener;
    }

    @Override
    public SavedEventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_events_item_view, parent, false);
        return new SavedEventsViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(SavedEventsViewHolder holder, int position) {
        DatabaseEvent savedEvent = eventList.get(position);
        holder.bind(savedEvent);

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class SavedEventsViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView titleTextView;
        DatabaseEvent savedEvent;

        public SavedEventsViewHolder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.saved_event_date_tv);
            titleTextView = (TextView) itemView.findViewById(R.id.saved_event_name_of_event_tv);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onEventLongClicked(savedEvent);

                    return true;
                }
            });
        }

        public void bind(DatabaseEvent savedEvent) {
            this.savedEvent = savedEvent;
            dateTextView.setText(savedEvent.getStartDate() + " (" + savedEvent.getStartTime() + ")");
            titleTextView.setText(savedEvent.getName());
        }
    }

    interface Listener{

        void onEventLongClicked(DatabaseEvent databaseEvent);

    }
}
