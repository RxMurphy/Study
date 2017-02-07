package me.netease.unit8;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paintLine;
    private Paint paintColor;
    private Paint paintText;
    private Paint paintDivider;
    private int width;
    private int height;
    private ImageView imageView;
    private int dp40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv_table);
        prepareCanvas();
        createRect();
        drawTable();
        saveImg();
    }




    private void prepareCanvas() {
        dp40 = DensityUtils.dp2px(this, 40);
        int dp20 = DensityUtils.dp2px(this, 20);
        width = dp20 * 24;
        height = dp20 * 16;
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageView.setImageBitmap(bitmap);
        paintLine = new Paint();
        paintLine.setAntiAlias(true);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(1);
        paintColor = new Paint();
        paintColor.setAntiAlias(true);
        paintColor.setStyle(Paint.Style.FILL);
        paintText = new Paint();
        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(DensityUtils.sp2px(this, 12));
        paintDivider = new Paint();
        paintDivider.setAntiAlias(true);
        paintDivider.setStyle(Paint.Style.STROKE);
        paintDivider.setStrokeWidth(2);
    }

    private void createRect() {
        paintLine.setColor(Color.BLACK);
        canvas.drawRect(0, 0, width, height, paintLine);
    }

    private void drawTable() {
        canvas.translate(1, 1);
        for (int i = 0; i < 8; i++) {
            int startY = i * dp40;
            for (int blockIndex = 0; blockIndex < 12; blockIndex++) {
                drawBlock(blockIndex * dp40, startY);
            }
        }
        for (int i = 1; i < 12; i++) {
            int startX = i * dp40;
            drawDivider(startX, 1, startX, 1 + height);
        }
        for (int i = 1; i < 8; i++) {
            int startY = i * dp40;
            drawDivider(1, startY, 1 + width, startY);
        }
    }

    private void saveImg() {
        String path = Environment.getExternalStorageDirectory().getPath() + "/bitmap_table.png";
        try {
//            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
            Log.d("Success","保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void drawDivider(int startX, int startY, int endX, int endY) {
        canvas.drawLine(startX, startY, endX, endY, paintDivider);
    }

    private void drawBlock(int left, int top) {
        int[] colors = geteRamdomColor();
        int bgColor = Color.argb(colors[0], colors[1], colors[2], colors[3]);
        paintColor.setColor(bgColor);
        Rect rect = new Rect(left, top, left + dp40, top + dp40);
        canvas.drawRect(rect, paintColor);
        canvas.drawLine(left + dp40 / 2, top, left + dp40 / 2, top + dp40, paintLine);
        canvas.drawLine(left, top + dp40 / 2, left + dp40, top + dp40 / 2, paintLine);
        canvas.drawText(Integer.toHexString(colors[0]).toUpperCase(), left + dp40 / 4, top + dp40 / 4 + getFontHeight() / 4, paintText);
        canvas.drawText(Integer.toHexString(colors[1]).toUpperCase(), left + dp40 / 4 * 3, top + dp40 / 4 + getFontHeight() / 4, paintText);
        canvas.drawText(Integer.toHexString(colors[2]).toUpperCase(), left + dp40 / 4, top + dp40 / 4 * 3 + getFontHeight() / 4, paintText);
        canvas.drawText(Integer.toHexString(colors[3]).toUpperCase(), left + dp40 / 4 * 3, top + dp40 / 4 * 3 + getFontHeight() / 4, paintText);
    }

    public int getFontHeight() {
        Paint.FontMetrics fm = paintText.getFontMetrics();
        return (int) Math.ceil(fm.descent - fm.top) + 2;
    }


    private int[] geteRamdomColor() {
        int alpha;
        int red;
        int green;
        int blue;
        Random random = new Random();
        alpha = random.nextInt(256);
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
        return new int[]{alpha, red, green, blue};
    }


}
