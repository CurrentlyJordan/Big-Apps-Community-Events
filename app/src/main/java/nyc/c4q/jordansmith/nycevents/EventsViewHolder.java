package nyc.c4q.jordansmith.nycevents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.jordansmith.nycevents.models.Items;

/**
 * Created by helenchan on 1/29/17.
 */
public class EventsViewHolder extends RecyclerView.ViewHolder {
    TextView date_TV;
    TextView nameTV;
    TextView descriptionTV;
    ImageView eventImage;
    String imageURL;

    public EventsViewHolder(View itemView) {
        super(itemView);
        date_TV = (TextView)itemView.findViewById(R.id.date_tv);
        nameTV = (TextView)itemView.findViewById(R.id.name_of_event_tv);
        descriptionTV = (TextView) itemView.findViewById(R.id.short_desc_tv);
        eventImage = (ImageView)itemView.findViewById(R.id.event_imageview);
    }

    public void bind(Items eventItems) {
        date_TV.setText(eventItems.getDatePart() + " (" + eventItems.getTimePart() + ")");
        nameTV.setText(eventItems.getName());
        descriptionTV.setText(eventItems.getShortDesc());
        imageURL = eventItems.getImageUrl();
        if(imageURL == null) {
            eventImage.setVisibility(View.GONE);
        }else {
            imageURL = setImageURL(imageURL);
            setImage(imageURL);
        }
    }

    public String setImageURL(String imageURL){
        return "http://www1.nyc.gov" + imageURL;
    }

    public void setImage(String imageURL){
        Picasso.with(itemView.getContext())
                .load(imageURL)
                .fit()
                .into(eventImage);
    }

}
