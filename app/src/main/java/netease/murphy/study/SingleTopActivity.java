package netease.murphy.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SingleTopActivity extends AppCompatActivity {
    private final static String TAG = "SingleTopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigle_top);
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
}
