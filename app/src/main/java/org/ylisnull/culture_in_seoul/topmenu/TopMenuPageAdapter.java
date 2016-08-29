package org.ylisnull.culture_in_seoul.topmenu;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TopMenuPageAdapter extends PagerAdapter {
    List<View> viewList;

    public TopMenuPageAdapter(List<View> viewList) {
        super();
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        return this.viewList.size();

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(this.viewList.get(position), 0);
        return this.viewList.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(this.viewList.get(position));
    }

}
