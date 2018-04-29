package com.example.ai.guideviewpager.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.ai.guideviewpager.MainActivity;
import com.example.ai.guideviewpager.R;

/**
 * Created by AI on 2017/11/23.
 */

public class ContentFragment extends Fragment {

    private int[] bgRes={
            R.drawable.icon_launch,
            R.drawable.icon_launch1,
            R.drawable.icon_launch2,
            R.drawable.icon_launch3
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_content,null);
        Button btn=view.findViewById(R.id.btn);
        RelativeLayout rl=view.findViewById(R.id.relative);

        int index=getArguments().getInt("index");
        rl.setBackgroundResource(bgRes[index]);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        btn.setVisibility(index==3 ? View.VISIBLE:View.GONE);
        return view;
    }

}
