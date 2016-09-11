package org.ylisnull.culture_in_seoul.topmenu;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import org.ylisnull.culture_in_seoul.R;

public class TopMenuChangeListener implements ViewPager.OnPageChangeListener {
    Context context;
    TextView textMenuIndicator;
    ImageView[] buttonImages;

    String[] menuTexts = {
            "뉴스피드", "찜", "찾기", "설정"
    };

    int[] drawableIdsWhenSelected = {
            R.drawable.mainmenu_newsfeed,
            R.drawable.mainmenu_heart_selected,
            R.drawable.mainmenu_find_selected,
            R.drawable.mainmenu_setting_selected
    };

    int[] drawableIdsWhenUnselected = {
            R.drawable.mainmenu_newsfeed,
            R.drawable.mainmenu_heart_light,
            R.drawable.mainmenu_find_light,
            R.drawable.mainmenu_setting_light
    };

    public TopMenuChangeListener(Context context) {
        this.context = context;
    }

    public void setMenuTextIndicator(TextView textView) {
        this.textMenuIndicator = textView;
    }

    public void setButtonImages(ImageView[] buttonImages) {
        this.buttonImages = buttonImages;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < this.buttonImages.length; i++) {
            ImageView button = this.buttonImages[i];

            if (i == position) {
                button.setImageResource(this.drawableIdsWhenSelected[i]);
                this.textMenuIndicator.setText(this.menuTexts[i]);
            }
            else
                button.setImageResource(this.drawableIdsWhenUnselected[i]);


        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
