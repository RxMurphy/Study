package netease.murphy.study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by murphy on 2016/12/19.
 */
public class CallActivity extends AppCompatActivity {
    private static final String TAG = "CallActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
    }
}
