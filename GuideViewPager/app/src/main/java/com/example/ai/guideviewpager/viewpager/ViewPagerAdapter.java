package com.example.ai.guideviewpager.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AI on 2017/11/23.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm,
                            List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }


}
