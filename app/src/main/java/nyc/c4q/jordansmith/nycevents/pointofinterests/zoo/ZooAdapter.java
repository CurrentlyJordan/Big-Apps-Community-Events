package nyc.c4q.jordansmith.nycevents.pointofinterests.zoo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.zoos_aquariums.Facility;
import nyc.c4q.jordansmith.nycevents.pointofinterests.zoo.ZooViewHolder;

/**
 * Created by helenchan on 2/3/17.
 */
public class ZooAdapter extends RecyclerView.Adapter<ZooViewHolder> {
    List<Facility> zooList;

    public ZooAdapter(List<Facility> zooList) {
        this.zooList = zooList;
    }

    @Override
    public ZooViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.zoo_itemview, parent, false);
        return new ZooViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ZooViewHolder holder, int position) {
        Facility facility = zooList.get(position);
        holder.bind(facility);
    }

    @Override
    public int getItemCount() {
        return zooList.size();
    }
}
