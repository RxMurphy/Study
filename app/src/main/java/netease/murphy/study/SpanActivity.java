package netease.murphy.study;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpanActivity extends AppCompatActivity {

    @Bind(R.id.image_span)
    TextView imageSpan;
    @Bind(R.id.under_line_span)
    TextView underLineSpan;
    @Bind(R.id.foreground_color_span)
    TextView foregroundColorSpan;
    @Bind(R.id.clickable_span)
    TextView clickableSpan;
    @Bind(R.id.absolute_size_span)
    TextView absoluteSizeSpan;
    @Bind(R.id.style_span)
    TextView styleSpan;
    @Bind(R.id.typeface_span)
    TextView typefaceSpan;
    @Bind(R.id.my_span)
    TextView mySpan;
    @Bind(R.id.mix_span)
    TextView mixSpan;
    @Bind(R.id.auto_complete_text)
    AutoCompleteTextView autoCompleteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span);
        ButterKnife.bind(this);
        initSpan();
        showSpan();
        initView();
//        http://api.msd985.com/api.php?version=1&resource=courses&method=list
    }

    private void initView() {
        autoCompleteText.setAdapter(new AutoComplateAdapter(this));
        autoCompleteText.setThreshold(1);
    }

    private void initSpan() {

    }

    private void showSpan() {
        SpannableString spannableString = new SpannableString("我是测试用String");
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(SpanActivity.this, "...", Toast.LENGTH_SHORT).show();
            }
        }, 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickableSpan.setText(spannableString);
        clickableSpan.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
