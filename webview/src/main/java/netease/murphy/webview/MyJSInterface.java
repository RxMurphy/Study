package netease.murphy.webview;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.webkit.JavascriptInterface;

/**
 * Created by murphy on 17/2/7.
 */

public class MyJSInterface {
    private Context context;

    public MyJSInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void luanchActivity(String url) {
        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @JavascriptInterface
    public void notifyBar(String msg) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        Notification notification = builder.setContentTitle("一个来自JS的通知")
                .setContentText(msg + "我是通知内容，告诉你JS将要统治世界！")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(100, notification);
    }

}
