package nyc.c4q.jordansmith.nycevents.tabfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.savedfavorites.SavedEventsChildFragment;
import nyc.c4q.jordansmith.nycevents.savedfavorites.SavedPlacesChildFragment;

/**
 * Created by jordansmith on 1/29/17.
 */

public class HomeFragment extends Fragment {
    Button showSavedPlaces;
    Button showSavedEvents;
    TextView info_display;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment_layout, container, false);
        showSavedEvents = (Button)rootView.findViewById(R.id.saved_events_button);
        showSavedPlaces = (Button)rootView.findViewById(R.id.saved_places_button);
        info_display = (TextView) rootView.findViewById(R.id.type_of_data_text_view);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.home_fragment_holder, new SavedEventsChildFragment())
                .commit();

        showSavedPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info_display.setText("Saved Places");
                info_display.setBackgroundResource(R.drawable.museum_pic);
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.home_fragment_holder, new SavedPlacesChildFragment())
                        .commit();
            }
        });

        showSavedEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info_display.setText("Saved Events");
                info_display.setBackgroundResource(R.drawable.default_event_image);
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.home_fragment_holder, new SavedEventsChildFragment())
                        .commit();
            }
        });

        return rootView;
    }

}
