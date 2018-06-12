package com.ipk.newbianjapanese;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<MyPageModel> layoutList = new ArrayList<>();
    {
        layoutList.add(new MyPageModel(R.layout.layout_passage,R.string.tab_title_passage));
        layoutList.add(new MyPageModel(R.layout.layout_words,R.string.tab_title_words));
    }
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = MyFragment.newInstance(layoutList.get(position).layoutRes);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    @Override
    public int getCount() {
        return layoutList.size();
    }
}
