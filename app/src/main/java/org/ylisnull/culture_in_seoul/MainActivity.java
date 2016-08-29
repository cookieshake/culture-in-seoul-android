package org.ylisnull.culture_in_seoul;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.viewpagerindicator.UnderlinePageIndicator;

import org.ylisnull.culture_in_seoul.card.CardInflator;
import org.ylisnull.culture_in_seoul.card.CardListViewAdapter;
import org.ylisnull.culture_in_seoul.topmenu.TopMenuChangeListener;
import org.ylisnull.culture_in_seoul.topmenu.TopMenuPageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflateTopMenus();

    }

    private void inflateTopMenus() {
        ArrayList<View> views = new ArrayList<>();

        //각 메뉴에 해당하는 View들 추가
        views.add(inflateNewsFeed());
        views.add(inflateLikes());
        views.add(inflateSearch());
        views.add(inflateNewsFeed());

        //ViewPager 생성 및 Adapter와 Listener연결
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new TopMenuPageAdapter(views));
        viewPager.addOnPageChangeListener(new TopMenuChangeListener(this));

        //메뉴 지시기 추가
        UnderlinePageIndicator pager_indicator = (UnderlinePageIndicator) findViewById(R.id.pager_indicator);
        pager_indicator.setViewPager(viewPager);
        pager_indicator.setSelectedColor(Color.parseColor("#232323"));
        pager_indicator.setFades(false);


    }

    private RecyclerView inflateNewsFeed() {
        RecyclerView newsfeed = (RecyclerView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.cardlist, null);
        newsfeed.setHasFixedSize(true);

        //RecyclerView에는 LayoutManager가 필요
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        newsfeed.setLayoutManager(llm);

        //cardList에 카드 내용추가
        CardListViewAdapter clva = new CardListViewAdapter(new CardInflator().getCardContents(), this);
        newsfeed.setAdapter(clva);

        return newsfeed;
    }

    private LinearLayout inflateSearch() {
        LinearLayout search = (LinearLayout) getLayoutInflater().from(this).inflate(R.layout.search, null);

        return search;
    }

    private LinearLayout inflateLikes() {
        LinearLayout search = (LinearLayout) getLayoutInflater().from(this).inflate(R.layout.likes, null);

        return search;
    }
}
