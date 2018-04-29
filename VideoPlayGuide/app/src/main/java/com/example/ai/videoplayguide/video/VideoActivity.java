package com.example.ai.videoplayguide.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ai.videoplayguide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AI on 2017/11/24.
 */

public class VideoActivity extends FragmentActivity {
    private ViewPager viewPager;
    private LinearLayout indicator;

    private PagerAdapter adapter;

    private List<Fragment> fragments=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        viewPager=findViewById(R.id.viewPager);
        indicator=findViewById(R.id.indicator);

        for(int i=0;i<3;i++){
            VideoGuideFragment fragment=new VideoGuideFragment();
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
        /**
         * 这个方法的作用是 把Android系统中的非标准度量尺寸转变为标准度量尺寸 (Android系统中的标准尺寸是px, 即像素)
         标准单位: px (px是安卓系统内部使用的单位, dp是与设备无关的尺寸单位 )

         非标准单位: dp, in, mm, pt, sp

         TypedValue.applyDimension()方法的功能就是把非标准尺寸转换成标准尺寸, 如:

         dp->px:  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, context.getResources().getDisplayMetrics());

         in->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_IN, 20, context.getResources().getDisplayMetrics());

         mm->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, 20, context.getResources().getDisplayMetrics());

         pt->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT, 20, context.getResources().getDisplayMetrics());

         sp->px: TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, context.getResources().getDisplayMetrics());

         */
        int width= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
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
