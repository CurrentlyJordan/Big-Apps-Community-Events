package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.jordansmith.nycevents.models.zoos_aquariums.Facility;

/**
 * Created by helenchan on 2/3/17.
 */
public class ZooViewHolder extends RecyclerView.ViewHolder {
    private TextView zooNameTV;
    private TextView zooAddyTV;
    private TextView zooPhoneTV;

    public ZooViewHolder(View itemView) {
        super(itemView);
        zooNameTV = (TextView) itemView.findViewById(R.id.zoo_name_tv);
        zooAddyTV = (TextView) itemView.findViewById(R.id.zoo_address_tv);
        zooPhoneTV = (TextView) itemView.findViewById(R.id.zoo_phone_tv);
    }

    public void bind(Facility facility) {
        zooNameTV.setText(facility.getName());
        zooAddyTV.setText(facility.getLocation());
        zooPhoneTV.setText(facility.getPhone_Num());
    }
}
