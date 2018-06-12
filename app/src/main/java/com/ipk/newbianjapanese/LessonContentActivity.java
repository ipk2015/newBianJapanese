package com.ipk.newbianjapanese;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LessonContentActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<MyPageModel> layoutList = new ArrayList<>();
    {
        layoutList.add(new MyPageModel(R.layout.layout_passage,R.string.tab_title_passage));
        layoutList.add(new MyPageModel(R.layout.layout_words,R.string.tab_title_words));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        tabLayout = this.<TabLayout>findViewById(R.id.tabLayout);
        viewPager = this.<ViewPager>findViewById(R.id.viewPager);
        init();
    }

    private void init(){
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = MyFragment.newInstance(layoutList.get(position).layoutRes);
                return fragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(layoutList.get(position).titleRes);
            }

            @Override
            public int getCount() {
                return layoutList.size();
            }
        });

        tabLayout.setupWithViewPager(viewPager);

    }
}
