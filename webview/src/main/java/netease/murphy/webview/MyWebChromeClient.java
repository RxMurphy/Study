package netease.murphy.webview;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by murphy on 17/2/7.
 */

public class MyWebChromeClient extends WebChromeClient {
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        //必须调用此方法，否则JS认为用户没有确认此alert，无法进行后续操作
        result.confirm();
        return true;

    }
}
