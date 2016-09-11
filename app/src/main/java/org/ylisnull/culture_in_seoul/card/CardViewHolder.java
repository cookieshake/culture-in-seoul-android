package org.ylisnull.culture_in_seoul.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ylisnull.culture_in_seoul.R;

public class CardViewHolder extends RecyclerView.ViewHolder {
    protected LinearLayout vCardContent;

    protected TextView vTitle;
    protected TextView vPlace;
    protected TextView vStrtdate;
    protected TextView vCodename;

    protected ImageView vMain_image;
    protected FrameLayout vBottomMenuBackground;
    protected LinearLayout vBottomMenu;

    public CardViewHolder(View v) {
        super(v);

        vCardContent = (LinearLayout) v.findViewById(R.id.card_content);

        vTitle = (TextView) v.findViewById(R.id.card_title);
        vPlace = (TextView) v.findViewById(R.id.card_place);
        vStrtdate = (TextView) v.findViewById(R.id.card_date);
        vCodename = (TextView) v.findViewById(R.id.card_codename);

        vMain_image = (ImageView) v.findViewById(R.id.card_image);

        vBottomMenuBackground = (FrameLayout) v.findViewById(R.id.card_bottomMenuBackground);
        vBottomMenu = (LinearLayout) v.findViewById(R.id.card_bottomMenu);
    }
}
