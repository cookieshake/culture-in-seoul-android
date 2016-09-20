package org.ylisnull.culture_in_seoul.card;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

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

        //카드 왼쪽 클릭 시 하단 메뉴 생성
        cardViewHolder.vCardContent.setClickable(true);
        cardViewHolder.vCardContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = cardViewHolder.vBottomMenuBackground.getVisibility();
                if (visibility == View.GONE) {
                    cardViewHolder.vBottomMenuBackground.setVisibility(View.VISIBLE);
                    Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
                    cardViewHolder.vBottomMenu.startAnimation(slideDown);
                } else {
                    Animation slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
                    cardViewHolder.vBottomMenu.startAnimation(slideUp);
                    cardViewHolder.vBottomMenuBackground.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            cardViewHolder.vBottomMenuBackground.setVisibility(View.GONE);
                        }
                    }, 200);
                }

            }
        });

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card, viewGroup, false);

        return new CardViewHolder(itemView);
    }


}

