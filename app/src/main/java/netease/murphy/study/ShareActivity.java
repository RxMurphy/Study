package netease.murphy.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        TextView shareText = (TextView) findViewById(R.id.share_text);
        if (shareText != null) {
            String stringExtra = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            shareText.setText(stringExtra);

        }
    }
}
