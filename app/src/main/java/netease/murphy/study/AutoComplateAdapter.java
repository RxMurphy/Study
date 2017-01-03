package netease.murphy.study;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by murphy on 2016/12/16.
 */
public class AutoComplateAdapter extends BaseAdapter implements Filterable {
    private static final String TAG = "AutoComplateAdapter";
    private List<String> mList;
    private String[] strings;
    private Context mContext;

    public AutoComplateAdapter(Context context) {
        mContext = context;
        strings = context.getResources().getStringArray(R.array.suffix);
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<String> list = new ArrayList();
                if (!TextUtils.isEmpty(constraint) && !constraint.toString().contains("@")) {
                    for (String string : strings) {
                        list.add(constraint.toString().concat(string));
                    }
                }
                results.values = list;
                results.count = list.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mList = (List<String>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(mContext);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(getItem(position));
        return textView;
    }
}
