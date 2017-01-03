package netease.murphy.study.adapter;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by murphy on 2016/12/27.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private static final String TAG = "ViewPagerAdapter";
    List<Integer> list = new ArrayList<>();

    public ViewPagerAdapter() {
        list.add(Color.parseColor("#001122"));
        list.add(Color.parseColor("#112233"));
        list.add(Color.parseColor("#223344"));
        list.add(Color.parseColor("#334455"));
        list.add(Color.parseColor("#445566"));
        list.add(Color.parseColor("#556677"));
        list.add(Color.parseColor("#778899"));
        list.add(Color.parseColor("#8899aa"));
        list.add(Color.parseColor("#99aabb"));
        list.add(Color.parseColor("#aabbcc"));
        list.add(Color.parseColor("#bbccdd"));
        list.add(Color.parseColor("#ccddee"));
        list.add(Color.parseColor("#ddeeff"));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Toast.makeText(container.getContext(), "创建了第" + position + "个页面", Toast.LENGTH_SHORT).show();
        TextView textView = new TextView(container.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setBackgroundColor(list.get(position));
        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Toast.makeText(container.getContext(), "销毁了第" + position + "个页面", Toast.LENGTH_SHORT).show();

        if (object instanceof View)
            container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public float getPageWidth(int position) {
        return (float) (0.2f + position * 0.1);
    }
}
