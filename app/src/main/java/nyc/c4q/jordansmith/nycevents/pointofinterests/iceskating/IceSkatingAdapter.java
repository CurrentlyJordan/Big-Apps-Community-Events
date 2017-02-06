package nyc.c4q.jordansmith.nycevents.pointofinterests.iceskating;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.jordansmith.nycevents.R;
import nyc.c4q.jordansmith.nycevents.models.iceskating.Iceskating;

/**
 * Created by helenchan on 2/5/17.
 */
public class IceSkatingAdapter extends RecyclerView.Adapter<IceskatingViewHolder> {
    List<Iceskating.Facility> iceList;

    public IceSkatingAdapter(List<Iceskating.Facility> iceList) {
        this.iceList = iceList;
    }

    @Override
    public IceskatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.iceskating_itemview, parent, false);
        return new IceskatingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IceskatingViewHolder holder, int position) {
        Iceskating.Facility iceskating = iceList.get(position);
        holder.bind(iceskating);
    }

    @Override
    public int getItemCount() {
        return iceList.size();
    }
}
