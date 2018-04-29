package com.example.ai.scrollview.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by AI on 2017/11/24.
 */

public class MyScrollView extends ScrollView {

    public OnScrollChangedListener getOnScrollChangedListener() {
        return onScrollChangedListener;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    private OnScrollChangedListener onScrollChangedListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param left 左边距
     * @param top 上边距
     * @param oldleft 上一次的左边距
     * @param oldtop 上一次的上边距
     *             这个方法在滑动过程中会不断被调用
     */
    @Override
    protected void onScrollChanged(int left, int top, int oldleft, int oldtop) {
        super.onScrollChanged(left, top, oldleft, oldtop);
        if (onScrollChangedListener!=null){
            onScrollChangedListener.onScrollChange(top,oldtop);//放大动画区域
        }
    }


    public interface OnScrollChangedListener{
        void onScrollChange(int top,int oldTop);//上下滑动
    }

}
