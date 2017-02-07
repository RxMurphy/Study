package netease.murphy.webview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by murphy on 17/2/7.
 */

public class MyWebviewClient extends WebViewClient {


    /**
     * @param view
     * @param url
     * @return 是否自己处理此url
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Uri uri = Uri.parse(url);
        if ("tel".equals(uri.getScheme()) || "sms".equals(uri.getScheme()) || "mailto".equals(uri.getScheme())) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                view.getContext().startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * @param view
     * @param request
     * @return 是否拦截请求并可以对页面的部分进行处理
     */
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        if (request.getUrl().toString().equals("http:www.baidu.com")) {
            return super.shouldInterceptRequest(view, request);
        }
        return super.shouldInterceptRequest(view, request);
    }

    /**
     * @param view
     * @param request
     * @param error   当发生错误的时候自己进行处理
     */
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }
}
