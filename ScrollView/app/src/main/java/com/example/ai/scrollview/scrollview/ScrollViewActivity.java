package com.example.ai.scrollview.scrollview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ai.scrollview.MainActivity;
import com.example.ai.scrollview.R;

/**
 * Created by AI on 2017/11/24.
 */

public class ScrollViewActivity extends Activity {
    private LinearLayout Anim;
    private MyScrollView myScrollView;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);

        Anim=findViewById(R.id.anim);
        myScrollView=findViewById(R.id.myScrollView);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScrollViewActivity.this, MainActivity.class));
            }
        });

        myScrollView.setOnScrollChangedListener(new MyScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChange(int top, int oldTop) {
                if(top<oldTop){//上滑
                    Animation anim= AnimationUtils.loadAnimation(ScrollViewActivity.this,R.anim.show);
                    Anim.setVisibility(View.VISIBLE);
                    Anim.startAnimation(anim);
                }else{//下滑

                    Animation anim= AnimationUtils.loadAnimation(ScrollViewActivity.this,R.anim.close);
                    Anim.setVisibility(View.INVISIBLE);
                    Anim.startAnimation(anim);
                }
            }
        });
        Anim.setVisibility(View.INVISIBLE);
    }
}
