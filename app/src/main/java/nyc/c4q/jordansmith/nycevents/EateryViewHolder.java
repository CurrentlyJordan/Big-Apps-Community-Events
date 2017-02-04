package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.jordansmith.nycevents.models.eateries.Eateries;

/**
 * Created by helenchan on 2/3/17.
 */
public class EateryViewHolder extends RecyclerView.ViewHolder{
    private TextView typeNameTV;
    private TextView nameTV;
    private TextView descriptionTV;
    private TextView locationTV;
    private TextView phoneTV;

    public EateryViewHolder(View itemView) {
        super(itemView);
        typeNameTV = (TextView) itemView.findViewById(R.id.eatery_type_name_tv);
        nameTV = (TextView) itemView.findViewById(R.id.eatery_name_tv);
        descriptionTV = (TextView) itemView.findViewById(R.id.eatery_description_tv);
        locationTV = (TextView) itemView.findViewById(R.id.eatery_location_tv);
        phoneTV = (TextView) itemView.findViewById(R.id.eatery_phone_tv);
    }

    public void bind(Eateries.Facility eateries) {
        typeNameTV.setText(eateries.getType_name());
        nameTV.setText(eateries.getName());
        descriptionTV.setText(eateries.getDescription());
        locationTV.setText(eateries.getLocation());
        phoneTV.setText(eateries.getPhone());
    }
}
