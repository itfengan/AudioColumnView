# AudioColumnView
An audio beat view
闲来无事,看到网易云音乐还有很多播放软件播放音乐有个随音乐跳动的柱状view,就简单撸了下

# 效果图如下
<img src="https://github.com/itfengan/AudioColumnView/blob/master/screenshot/20171025154215079.gif" width = "350"/>
# usage

    <?xml version="1.0" encoding="utf-8"?>
	<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.fengan.audiocolumnview.MainActivity">
    <Button
        android:id="@+id/btn_start"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="开始"/>
    <Button
        android:id="@+id/btn_stop"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="结束"/>
    <com.fengan.audiocolumnview.AudioColumnView
        android:id="@+id/acv"
        android:layout_width="50dp"
        android:layout_gravity="center_horizontal"
        android:background="@android:color/background_dark"
        android:layout_height="50dp"/>
	</LinearLayout>

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

# over 嘻嘻
