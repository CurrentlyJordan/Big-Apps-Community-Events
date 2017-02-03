package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.jordansmith.nycevents.models.museums.Museum;

/**
 * Created by helenchan on 2/1/17.
 */
public class MuseumAdapter extends RecyclerView.Adapter<MuseumViewHolder> {
    List<Museum> museumList;

    public MuseumAdapter(List<Museum> museumsList) {
        this.museumList = museumsList;
    }

    @Override
    public MuseumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.museum_itemview, parent, false);
        return new MuseumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MuseumViewHolder holder, int position) {
        Museum museum = museumList.get(position);
        holder.bind(museum);
    }

    @Override
    public int getItemCount() {
        return museumList.size();
    }
}
