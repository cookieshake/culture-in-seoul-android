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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.UnderlinePageIndicator;

import org.ylisnull.culture_in_seoul.card.CardInflator;
import org.ylisnull.culture_in_seoul.card.CardListViewAdapter;
import org.ylisnull.culture_in_seoul.topmenu.TopMenuChangeListener;
import org.ylisnull.culture_in_seoul.topmenu.TopMenuOnClickListener;
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
        views.add(inflateSetting());

        //Button들 지정
        ImageView menu0 = (ImageView) ((ImageView) findViewById(R.id.menu0));
        ImageView menu1 = (ImageView) ((ImageView) findViewById(R.id.menu1));
        ImageView menu2 = (ImageView) ((ImageView) findViewById(R.id.menu2));
        ImageView menu3 = (ImageView) ((ImageView) findViewById(R.id.menu3));

        //ViewPager 생성 및 Adapter와 Listener연결
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new TopMenuPageAdapter(views));

        TopMenuChangeListener tmcl = new TopMenuChangeListener(this);
        ImageView[] buttonImages = {menu0, menu1, menu2, menu3};
        TextView menuText = (TextView) findViewById(R.id.menuText);

        tmcl.setButtonImages(buttonImages);
        tmcl.setMenuTextIndicator(menuText);

        viewPager.addOnPageChangeListener(tmcl);

        //메뉴버튼 클릭리스너 생성 및 버튼에 연결
        TopMenuOnClickListener tmocl = new TopMenuOnClickListener();
        tmocl.setViewPagerToChange(viewPager);
        menu0.setOnClickListener(tmocl);
        menu1.setOnClickListener(tmocl);
        menu2.setOnClickListener(tmocl);
        menu3.setOnClickListener(tmocl);

        //메뉴 지시기 추가
        UnderlinePageIndicator pager_indicator = (UnderlinePageIndicator) findViewById(R.id.pager_indicator);
        pager_indicator.setViewPager(viewPager);
        pager_indicator.setSelectedColor(Color.parseColor("#e64a19"));
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

    private LinearLayout inflateSetting() {
        LinearLayout setting = (LinearLayout) getLayoutInflater().from(this).inflate(R.layout.setting, null);

        return setting;
    }
}
