package org.ylisnull.culture_in_seoul.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import org.ylisnull.culture_in_seoul.R;

import java.util.List;

public class CardListViewAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<CardContent> contentList;
    private Context context;

    public CardListViewAdapter(List<CardContent> contentList, Context context) {
        this.contentList = contentList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    @Override
    public void onBindViewHolder(final CardViewHolder cardViewHolder, int i) {
        CardContent cc = contentList.get(i);

        cardViewHolder.vCodename.setText(cc.getCodename());
        cardViewHolder.vTitle.setText(cc.getTitle());
        cardViewHolder.vPlace.setText(cc.getPlace());

        String strtdate = cc.getStrtdate();
        String end_date = cc.getEnd_date();
        if (strtdate.equals(end_date))
            cardViewHolder.vStrtdate.setText(cc.getStrtdate());
        else
            cardViewHolder.vStrtdate.setText(cc.getStrtdate() + " ~ " + cc.getEnd_date());

        String main_img = cc.getMain_img();

        //Picasso가 대문자 URI에서 동작안함, 파일 확장자 대소문자 구분 필요
        main_img = main_img.substring(0, main_img.lastIndexOf(".")).toLowerCase() + main_img.substring(main_img.lastIndexOf("."));
        Picasso.with(this.context).load(main_img).error(R.drawable.noimage).fit().centerInside().into(cardViewHolder.vMain_image);

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card, viewGroup, false);

        return new CardViewHolder(itemView);
    }


}

