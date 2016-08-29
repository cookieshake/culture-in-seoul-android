package org.ylisnull.culture_in_seoul.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.ylisnull.culture_in_seoul.R;

public class CardViewHolder extends RecyclerView.ViewHolder {
    protected TextView vTitle;
    protected TextView vPlace;
    protected TextView vStrtdate;
    protected TextView vCodename;

    protected ImageView vMain_image;

    public CardViewHolder(View v) {
        super(v);

        vTitle = (TextView) v.findViewById(R.id.card_title);
        vPlace = (TextView) v.findViewById(R.id.card_place);
        vStrtdate = (TextView) v.findViewById(R.id.card_date);
        vCodename = (TextView) v.findViewById(R.id.card_codename);

        vMain_image = (ImageView) v.findViewById(R.id.card_image);
    }
}
