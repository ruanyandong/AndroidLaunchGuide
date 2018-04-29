package com.example.ai.videoplayguide.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.example.ai.videoplayguide.MainActivity;
import com.example.ai.videoplayguide.R;


/**
 * Created by AI on 2017/11/24.
 */

public class VideoGuideFragment extends Fragment{
    private int[] video=new int[]{
            R.raw.video1,
            R.raw.video2,
            R.raw.video3
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_layout,null);
        final VideoView videoView=view.findViewById(R.id.videoview);
        Button btn=view.findViewById(R.id.btn_start);

        int index=getArguments().getInt("index");

        videoView.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+video[index]));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        btn.setVisibility(index==2 ? View.VISIBLE:View.GONE);

        return view;
    }
}
