package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.eateries.Eateries;

/**
 * Created by helenchan on 2/3/17.
 */
public class EateryAdapter extends RecyclerView.Adapter<EateryViewHolder> {
    List<Eateries.Facility> eateriesList;

    public EateryAdapter(List<Eateries.Facility> eateriesList) {
        this.eateriesList = eateriesList;
    }

    @Override
    public EateryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.eatery_itemview, parent, false);
        return new EateryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EateryViewHolder holder, int position) {
        Eateries.Facility eateries = eateriesList.get(position);
        holder.bind(eateries);
    }

    @Override
    public int getItemCount() {
        return eateriesList.size();
    }
}
