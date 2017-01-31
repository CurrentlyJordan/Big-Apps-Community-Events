package nyc.c4q.jordansmith.nycevents.tabfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import nyc.c4q.jordansmith.nycevents.NYCEventsFragments;
import nyc.c4q.jordansmith.nycevents.R;

/**
 * Created by jordansmith on 1/29/17.
 */

public class EventsFragment extends Fragment implements View.OnClickListener {
    LinearLayout nycEventButton;
    LinearLayout parkEventButton;
    View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.event_select_fragment, container, false);
        initalize(rootView);
        return rootView;
    }

    public void initalize(View rootView){
        nycEventButton = (LinearLayout) rootView.findViewById(R.id.event_button_nyc);
        nycEventButton.setOnClickListener(this);
        parkEventButton = (LinearLayout) rootView.findViewById(R.id.park_event_button);
        parkEventButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.event_button_nyc:
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.event_select_id, new NYCEventsFragments())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
