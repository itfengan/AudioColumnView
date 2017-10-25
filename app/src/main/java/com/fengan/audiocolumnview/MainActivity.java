package com.fengan.audiocolumnview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AudioColumnView audioColumnView = (AudioColumnView) findViewById(R.id.acv);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!audioColumnView.isStart()) {
                    //开始跳动
                    audioColumnView.start();
                }
            }
        });
        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (audioColumnView.isStart()) {
                    //结束跳动
                    audioColumnView.stop();
                }
            }
        });
    }
}
