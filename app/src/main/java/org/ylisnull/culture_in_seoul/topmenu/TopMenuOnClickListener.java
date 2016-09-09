package org.ylisnull.culture_in_seoul.topmenu;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import org.ylisnull.culture_in_seoul.R;


public class TopMenuOnClickListener implements View.OnClickListener{
    ViewPager viewPager;

    public void setViewPagerToChange(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu0:
                this.viewPager.setCurrentItem(0);
                break;

            case R.id.menu1:
                this.viewPager.setCurrentItem(1);
                break;

            case R.id.menu2:
                this.viewPager.setCurrentItem(2);
                break;

            case R.id.menu3:
                this.viewPager.setCurrentItem(3);
                break;

        }

    }
}
