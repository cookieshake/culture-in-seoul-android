package org.ylisnull.culture_in_seoul;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import org.ylisnull.culture_in_seoul.card.CardInflator;
import org.ylisnull.culture_in_seoul.card.CardListViewAdapter;

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

        //ViewPager 생성 및 Adapter와 Listener연결
        LinearLayout viewPager = (LinearLayout) findViewById(R.id.viewpager);
        viewPager.addView(inflateNewsFeed());
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
}
