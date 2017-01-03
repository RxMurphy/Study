package netease.murphy.study;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import netease.murphy.study.adapter.ViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ViewPager pager = (ViewPager) findViewById(R.id.activity_view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(1);
    }
}
