package com.torkuds.nest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.torkuds.nest.fragment.ListFragment;
import com.torkuds.nest.fragment.WebFragment;
import com.torkuds.nest.widget.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ChildViewPager viewPager;
    private String[] title;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ChildViewPager) findViewById(R.id.viewPager);

        title = getResources().getStringArray(R.array.tab_name);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        viewPager.setAdapter(new TabLayoutAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.resetHeight(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        fragments = new ArrayList<>();
        fragments.add(new WebFragment());
        fragments.add(new ListFragment());
    }

    public class TabLayoutAdapter extends FragmentPagerAdapter {

        public TabLayoutAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position % title.length];
        }
    }

}
