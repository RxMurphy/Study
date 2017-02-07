package netease.murphy.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "taskId:" + getTaskId());
    }

    public void standard(View v) {
        Intent intent = new Intent(this, StandardActivity.class);
        startActivity(intent);
    }

    public void singleTop(View v) {
        Intent intent = new Intent(this, SingleTopActivity.class);
        startActivity(intent);
    }

    public void singleTask(View v) {
        Intent intent = new Intent(this, SingleTaskActivity.class);
        startActivity(intent);
    }

    public void singleInstance(View v) {
        Intent intent = new Intent(this, SingleInstanceActivity.class);
        startActivity(intent);
    }

    public void intent(View v) {
        Intent intent = new Intent(this, IntentActivity.class);
        startActivity(intent);
    }

    public void share(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "我要分享....");
        startActivity(intent);
    }

    public void span(View v) {
        Intent intent = new Intent(this, SpanActivity.class);
        startActivity(intent);
    }

    public void homework(View v) {
        //横向布局的scrollview
        startActivity(new Intent(this, HomeworkActivity.class));
    }

    public void call(View v) {
        //仿易信拨号界面
        startActivity(new Intent(this, CallActivity.class));
    }

    public void viewPager(View v) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void toolbar(View v) {
        startActivity(new Intent(this, ToolbarActivity.class));
    }

    public void actionbar(View v) {
        startActivity(new Intent(this, ActionBarActivity.class));
    }


}
