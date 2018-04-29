package com.example.ai.viewflipper.viewflipper;

import android.app.Activity;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.ai.viewflipper.R;

/**
 * Created by AI on 2017/11/24.
 */

public class ViewFlipperActivity extends Activity implements GestureDetector.OnGestureListener{
    private ViewFlipper viewFlipper;
    private Button btn;
    private LinearLayout indicator;
    private GestureDetector gestureDetector;
    private int index=0;//当前是第几页

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);

        viewFlipper=findViewById(R.id.viewFlipper);
        btn=findViewById(R.id.btn);
        indicator=findViewById(R.id.indicator);

        initIndicator();
    }



    /**
     * 初始化指示器
     */
    private void initIndicator(){
        int width= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                10f,getResources().getDisplayMetrics());
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(width,width);
        lp.rightMargin=2*width;

        for (int i=0;i<viewFlipper.getChildCount();i++){
            View view=new View(this);
            view.setId(i);
            view.setBackgroundResource(i==0 ? R.drawable.dot_focus:R.drawable.dot_normal);
            view.setLayoutParams(lp);
            indicator.addView(view,i);
        }

        gestureDetector=new GestureDetector(this);//设置接口
    }

    //手势按下的时候
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    //左右滑动
    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    //滑动过程中
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float x, float y) {
        if(motionEvent.getX()>motionEvent1.getX()){
            viewFlipper.showNext();
            index=index<3 ? index+1:0;//是最后一页就换到第一页，不是就往后加一页
        }else if(motionEvent.getX()<motionEvent1.getX()){
            viewFlipper.showPrevious();
            index=index>0 ? index-1:3;//是第一页就换到最后一页，不是就往前减一页
        }else{
            return false;//手指开始和结束的坐标相等，就不作处理，不换页
        }
        changeIndicator();
        return true;//处理完成
    }
    private void changeIndicator() {
        for (int i=0;i<viewFlipper.getChildCount();i++){
            indicator.getChildAt(i).setBackgroundResource(index==i ? R.drawable.dot_focus:R.drawable.dot_normal);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        return gestureDetector.onTouchEvent(event);
    }
}
