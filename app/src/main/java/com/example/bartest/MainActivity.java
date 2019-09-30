package com.example.bartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private LinearLayout barTest;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;
    private SeekBar seekBar;
    //方法较多，用全局变量的方法
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//滑杆移动

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {//离开滑杆
            //得到seekBar的进度
            int progress=seekBar.getProgress();
            //设置为ProgressBar的进度
            progressBar2.setProgress(progress);
            //判断是否达到最大值
            if(progress==seekBar.getMax()){
                //  若达到，设置progressBar不可见
                progressBar.setVisibility(View.INVISIBLE);}
            //若没达到，设置显示
            else{
                progressBar.setVisibility(View.VISIBLE);
            }


        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {//按下滑杆

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barTest = findViewById(R.id.barTest);
        progressBar = findViewById(R.id.progressBar);
        seekBar = findViewById(R.id.seekBar);

        //给seekbar设置监听
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
}