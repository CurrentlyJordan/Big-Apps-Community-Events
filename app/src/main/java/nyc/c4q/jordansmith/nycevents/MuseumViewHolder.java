package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.jordansmith.nycevents.models.museums.Museum;

/**
 * Created by helenchan on 2/1/17.
 */
public class MuseumViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView hoursTextView;
    private TextView addressTextView;
    private TextView phoneTextView;
    private TextView ratesTextView;
    private TextView specialsTexView;

    public MuseumViewHolder(View itemView) {
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.museum_name_tv);
        hoursTextView = (TextView) itemView.findViewById(R.id.museum_hours);
        addressTextView = (TextView) itemView.findViewById(R.id.museum_address_tv);
        phoneTextView = (TextView) itemView.findViewById(R.id.museum_phone_tv);
        ratesTextView = (TextView) itemView.findViewById(R.id.museum_rate_tv);
        specialsTexView = (TextView) itemView.findViewById(R.id.museum_specials_tv);
    }

    public void bind(final Museum museum) {
        nameTextView.setText(Html.fromHtml(museum.getName()));
        ratesTextView.setText(Html.fromHtml(museum.getRates()));
        addressTextView.setText(Html.fromHtml(museum.getAddress()));
        phoneTextView.setText(Html.fromHtml(museum.getPhone()));
        if (museum.getClosing() == null) {
            ratesTextView.setVisibility(View.GONE);
        } else {
            hoursTextView.setText(Html.fromHtml(museum.getClosing()));
        }

        if (museum.getSpecials() == null) {
            specialsTexView.setVisibility(View.GONE);
        } else {
            specialsTexView.setText(Html.fromHtml(museum.getSpecials()));
        }
    }

}
