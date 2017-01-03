package netease.murphy.study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = new RecyclerView(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        GridLayoutManager manager1 = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager manager2 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
    }
}
