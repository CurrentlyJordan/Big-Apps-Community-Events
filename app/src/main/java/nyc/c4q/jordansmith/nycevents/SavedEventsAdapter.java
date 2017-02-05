package nyc.c4q.jordansmith.nycevents;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        ImageView calendarButton;

        public SavedEventsViewHolder(final View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.saved_event_date_tv);
            titleTextView = (TextView) itemView.findViewById(R.id.saved_event_name_of_event_tv);
            calendarButton = (ImageView) itemView.findViewById(R.id.calendar_events_purple_icon);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onEventLongClicked(savedEvent);

                    return true;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), SavedEventInfoActivity.class);
                    intent.putExtra("Saved Event", savedEvent);
                    itemView.getContext().startActivity(intent);
                }
            });

            calendarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle("Add event to calendar")
                            .setMessage("Do you want to add this event to your calendar?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                                    intent.putExtra(CalendarContract.Events.TITLE, savedEvent.getName());
                                    intent.putExtra(CalendarContract.Events.DESCRIPTION, savedEvent.getShortDesc());

                                    itemView.getContext().startActivity(intent);
                                }

                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .show();
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
