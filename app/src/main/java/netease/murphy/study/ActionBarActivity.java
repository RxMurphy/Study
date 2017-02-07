package netease.murphy.study;

import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Toolbar练习用Activity
 * 实现图片沉浸状态栏
 * AppbarLayout的折叠和展开效果
 */
public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                showSnackBar("点击了添加");
                break;
            case R.id.more:
                showToast("点击了更多");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    private void showSnackBar(String content) {
        View decorView = getWindow().getDecorView();
        Snackbar.make(decorView, content, BaseTransientBottomBar.LENGTH_SHORT).show();
    }
}
