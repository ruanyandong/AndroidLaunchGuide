package com.example.ai.guideviewpager.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ai.guideviewpager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AI on 2017/11/23.
 */

public class ViewPagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    private LinearLayout indicator;

    private PagerAdapter adapter;
    private List<Fragment> fragments=new ArrayList<Fragment>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        viewPager=findViewById(R.id.viewPager);
        indicator=findViewById(R.id.indicator);

        /**
         * 创建FRAGMENT
         */
        for(int i=0;i<4;i++){
            ContentFragment fragment=new ContentFragment();
            Bundle bundle=new Bundle();

            bundle.putInt("index",i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }

        adapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i=0;i<fragments.size();i++){
                    indicator.getChildAt(i).setBackgroundResource(i==position ? R.drawable.dot_focus:R.drawable.dot_normal);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initIndicator();
    }

    /**
     * 初始化指示器
     */
    private void initIndicator(){
        int width= (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                10f,getResources().getDisplayMetrics());

        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(width,width);

        lp.rightMargin=2*width;

        for (int i=0;i<fragments.size();i++){
            View view=new View(this);
            view.setId(i);
            view.setBackgroundResource(i==0 ? R.drawable.dot_focus:R.drawable.dot_normal);
            view.setLayoutParams(lp);
            indicator.addView(view,i);
        }
    }


}
