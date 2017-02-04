package nyc.c4q.jordansmith.nycevents.tabfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nyc.c4q.jordansmith.nycevents.EateriesFragment;
import nyc.c4q.jordansmith.nycevents.MuseumFragment;
import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.ZooAndAquariumFragment;

/**
 * Created by helenchan on 2/2/17.
 */
public class POISelectActivity extends Fragment implements View.OnClickListener{
    View itemView;
    private Button museumButton;
    private Button zooButton;
    private Button eateryButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.poi_buttons_layout, container, false);
        initalize();
        return itemView;
    }

    private void initalize() {
        museumButton = (Button) itemView.findViewById(R.id.poi_museum_button);
        museumButton.setOnClickListener(this);
        zooButton = (Button)itemView.findViewById(R.id.poi_zoo_button);
        zooButton.setOnClickListener(this);
        eateryButton = (Button) itemView.findViewById(R.id.poi_eatery_button);
        eateryButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.poi_museum_button:
                getFragmentManager().beginTransaction()
                        .add(R.id.poi_button_layout_id, new MuseumFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.poi_zoo_button:
                getFragmentManager().beginTransaction()
                        .add(R.id.poi_button_layout_id, new ZooAndAquariumFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.poi_eatery_button:
                getFragmentManager().beginTransaction()
                        .add(R.id.poi_button_layout_id, new EateriesFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }

    }
}
