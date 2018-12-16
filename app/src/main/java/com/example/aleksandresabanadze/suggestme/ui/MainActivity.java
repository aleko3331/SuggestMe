package com.example.aleksandresabanadze.suggestme.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.aleksandresabanadze.suggestme.R;
import com.example.aleksandresabanadze.suggestme.adapters.WPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private WPagerAdapter wPagerAdapter;
    private TextView page_1;
    private TextView page_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();

        viewPager = findViewById(R.id.view_pager);
        wPagerAdapter = new WPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(wPagerAdapter);
        viewPager.setCurrentItem(0);
        page_1.setTextColor(Color.rgb(52,179,129));
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                switch (viewPager.getCurrentItem()) {
                    case 0:
                        page_1.setTextColor(Color.rgb(52,179,129));
                        page_2.setTextColor(Color.WHITE);
                        break;
                    case 1:
                        page_2.setTextColor(Color.rgb(52,179,129));
                        page_1.setTextColor(Color.WHITE);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    public void PageSelected(View view) {
        switch (view.getId()) {
            case R.id.page_1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.page_2:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    private void initView() {
        page_1 = findViewById(R.id.page_1);
        page_2 = findViewById(R.id.page_2);
    }
}
